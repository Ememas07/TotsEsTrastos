/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tricountmarcmas.Despesa;

/**
 *
 * @author Marc Mas
 */
@Entity

@Table(name = "grup")
@NamedQueries({
    @NamedQuery(name = "Grup.findAll", query = "SELECT g FROM Grup g"),
    @NamedQuery(name = "Grup.findById", query = "SELECT g FROM Grup g WHERE g.id = :id"),
    @NamedQuery(name = "Grup.findByDescripcio", query = "SELECT g FROM Grup g WHERE g.descripcio = :descripcio"),
    @NamedQuery(name = "Grup.findByDatacreacio", query = "SELECT g FROM Grup g WHERE g.datacreacio = :datacreacio")})
public class Grup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grup_id_seq")
    @SequenceGenerator(name = "grup_id_seq", sequenceName = "grup_id_seq", allocationSize = 1, initialValue = 1)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "descripcio")
    private String descripcio;
    @Basic(optional = false)
    @Column(name = "datacreacio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacreacio;
    @JoinTable(name = "usuarigrup", joinColumns = {
        @JoinColumn(name = "idgrup", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idusuari", referencedColumnName = "correu")})
    @ManyToMany
    private List<Usuari> usuariList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgrup")
    private List<Despesa> despesaList;

    public Grup() {
    }

    public Grup(Integer id) {
        this.id = id;
    }

    public Grup(Integer id, Date datacreacio) {
        this.id = id;
        this.datacreacio = datacreacio;
    }

    public Grup(String descripcio) {
        this.descripcio = descripcio;
    }

    public Grup(String nom, String descripcio, Date datacreacio) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.datacreacio = new Date();
    }

    public static Grup crearGrupConsola(Scanner s) {
        s.nextLine(); //buidam el búfer de scanner
        System.out.println("Quin es el nom del grup?");
        String nom = s.nextLine();
        System.out.println("Introdueix la descripcio del teu grup");
        String descripcio = s.nextLine();
        Date datacreacio = new Date();
        return new Grup(nom, descripcio, datacreacio);
    }

    public static Grup obtenirGrupConsola(Scanner s, EntityManager em) {
        s.nextLine(); //buidam el búfer de scanner
        System.out.println("Introdueix la id del grup");
        Grup g = null; //inicializam com a null
        while (g == null) {
            int idGrup = s.nextInt(); //agafam la id del grup
            g = GrupDAO.find(idGrup); // assignam el grup que trobem a la variable, si no el trobam serà null
            if (g == null) { //mostram un error per consola
                System.out.println("El grup introduit no existeix!");
                System.out.println("Introdueix una id de grup valida");
            }
        }
        return g;
    }

    public static Grup obtenirGrup(int idGrup) {
        return GrupDAO.find(idGrup);
    }

    public static Grup obtenirGrup(int idGrup, EntityManager em) {
        return GrupDAO.find(idGrup, em);
    }

    public void afegirUsuaris(Scanner s, EntityManager em) {
        String correu = "";
        s.nextLine(); //per resetejar scanner
        while (!correu.equals("Atura")) { //mentres no introduesqui "atura", afegirem usuaris
            System.out.println("Introduint Usuaris al grup: " + this); //mostram l'id del grup al que esteim afegint
            this.veureUsuaris();
            this.veureUsuarisDisponibles();
            System.out.println("Per aturar d'introduir, escrigui \"Atura\"");
            System.out.println("Introdueixi el correu de l'usuari");
            correu = s.nextLine();
            if (!correu.equals("Atura")) {
                this.afegirUsuari(correu, em);
            }
        }
    }

    public void afegirUsuari(String mailUsuari, EntityManager em) {
        List<Usuari> usuarisAntics = this.getUsuariList();
        Usuari u = Usuari.obtenirUsuari(mailUsuari); //retornarà null i un missatge per consola si l'usuari no és valid
        if (usuarisAntics.contains(u)) { //comprovam si la llista d'usuari ja conté l'usuari que intentam agregar
            System.out.println("L'usuari ja està al grup!");
        } else {
            if (u != null) { //si l'usuari és vàlid, i no està al grup, l'afegim al grup
                usuarisAntics.add(u);
                this.setUsuariList(usuarisAntics);
                GrupDAO gDAO = new GrupDAO(em);
                gDAO.updateDatabase();
                System.out.println("S'ha afegit l'usuari " + u + " al grup " + this);
            }
        }
    }

    public void veureUsuaris() {
        List<Usuari> l = this.getUsuariList(); //agafam la llista dins el grup
        Object usuaris[] = l.toArray(); //ho convertesc a un array
        if (usuaris.length == 0) {
            System.out.println("Actualment no hi ha usuaris al grup!");
        } else {
            System.out.println("Usuaris actuals:");
            for (Object usuari : usuaris) {
                System.out.println((Usuari) usuari); //imprimesc tots els usuaris del grup
            }
        }
    }

    public static void printAll() {
        List<Grup> l = GrupDAO.getAll();
        Object grups[] = l.toArray(); //ho convertesc a un array
        for (Object grup : grups) {
            Grup g = (Grup) grup;
            System.out.println(g);
        }
    }

    public void veureUsuarisDisponibles() {
        List<Usuari> l = UsuariDAO.getAll();
        Object usuaris[] = l.toArray(); //ho convertesc a un array
        System.out.println("Grups disponibles: ");
        for (Object usuari : usuaris) {
            Usuari u = (Usuari) usuari;
            if (!this.getUsuariList().contains(u)) { //si la llista d'usuaris no conté l'usuari, el mostram
                System.out.println(u);
            }
        }
    }

    public void veureDespeses() {
        List<Despesa> l = this.getDespesaList(); //agafam la llista dins el grup
        Object despeses[] = l.toArray(); //ho convertesc a un array
        if (despeses.length == 0) {
            System.out.println("Actualment no hi ha despeses al grup!");
        } else {
            System.out.println("Despeses del grup:");
            for (Object despesa : despeses) {
                System.out.println((Despesa) despesa); //imprimesc totes les despeses
            }
        }
    }

    public void mostrarPagamentsEntreUsuaris(boolean nomesPendents) {
        boolean hiHaDeutes = false;
        List<Despesa> lDespeses = this.getDespesaList();
        Object[] despeses = lDespeses.toArray();
        List<Usuari> pagadorsOriginals = new ArrayList();
        for (Object despesa : despeses) { //per cada despesa (del grup)
            // vaig despesa per despesa i agaf els seus pagadors a una llista
            Despesa d = (Despesa) despesa;
            Usuari PO = d.getPagadororiginal(); // PO = PagadorOriginal
            if (!pagadorsOriginals.contains(PO)) {
                pagadorsOriginals.add(PO);
            }
        }
        List<Usuari> lUsuaris = this.getUsuariList(); //agaf tots els usuaris i despeses del grup, les pas a array per iterar
        Object[] usuaris = lUsuaris.toArray();
        for (Usuari pagadorOriginal : pagadorsOriginals) {
            // per cada pagador original
            for (Object usuari : usuaris) {
                BigDecimal importPagat = new BigDecimal(0);
                //hem d'agrup per usuari i pagadorOriginal, aixi que agaf tots els pagadors per després agafar les despeses de cada usuari del grup
                Usuari u = (Usuari) usuari;
                if (!u.equals(pagadorOriginal)) { //si el pagador original no som nosaltres
                    List<Pagador> pagadorsUsuari = u.getPagadorList();
                    for (Object pagador : pagadorsUsuari) { //per cada despesa, mir si el pagadorOriginal és el que esteim mirant
                        Pagador p = (Pagador) pagador;
                        if (p.getDespesa().getPagadororiginal().equals(pagadorOriginal)) {
                            // agafam la despesa del pagador
                            // i de la despesa agafam el pagador original
                            // si el pagador original és el que esteim mirant

                            if ((nomesPendents && !p.haPagat()) || (!nomesPendents && p.haPagat())) {
                                // si nomes vull pendents i no han pagat
                                // o les vull totes i han pagat
                                importPagat = importPagat.add(p.getContribucio());
                            }

                        }
                    }
                    if (!importPagat.equals(new BigDecimal(0))) { //si l'import no es 0
                        hiHaDeutes = true;
                        if (nomesPendents) {
                            System.out.println(u + " deu " + importPagat + " € a " + pagadorOriginal.getFullName());
                        } else {
                            System.out.println(u + " ha pagat " + importPagat + " € a " + pagadorOriginal.getFullName());
                        }
                    }
                }
            }
        }

        if (!hiHaDeutes) {
            System.out.println("El grup seleccionat no té deutes entre cap usuari!");
        }
    }

    public void mostrarDespesesPerCategoria() {
        List<Despesa> lDespeses = this.getDespesaList();
        Object[] despeses = lDespeses.toArray();
        List<String> categories = new ArrayList();
        for (Object despesa : despeses) { //anam per totes les despeses
            Despesa d = (Despesa) despesa;
            String categoria = d.getCategoria(); //agafam la seva categoria
            if (!categories.contains(categoria)) { // si l'array de categories NO conté la despesa, l'afegim
                categories.add(categoria);
            }
        }
        //ara tenim totes les categories a un arrayList, podem anar per totes les categories i anar sumant cada despesa
        for (int i = 0; i < categories.size(); i++) {
            BigDecimal importTotal = new BigDecimal(0);
            for (Object despesa : despeses) { //anam per totes les despeses
                Despesa d = (Despesa) despesa;
                if (d.getCategoria().equals(categories.get(i))) { //si la categoria que esteim mirant es igual a la categoria de la despesa, sumam a l'import de la despesa
                    importTotal = importTotal.add(d.getImportpagat());
                }
            }
            System.out.print("La categoria " + categories.get(i) + " té un total de " + importTotal + " en despeses");
            System.out.println("(" + (importTotal.divide(totalGastatGrup(), 4, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100))) + "%)");
            //divideix import total gastat entre total gastat del grup i multiplica per 100
        }
    }

    public BigDecimal totalGastatGrup() {
        BigDecimal importGastat = new BigDecimal(0);
        List<Despesa> lDespeses = this.getDespesaList();
        Object[] despeses = lDespeses.toArray();
        for (Object despesa : despeses) { //anam per totes les despeses
            Despesa d = (Despesa) despesa;
            importGastat = importGastat.add(d.getImportpagat());
        }
        return importGastat;
    }

    public void mostrarDespesesPerUsuari() {
        List<Usuari> lUsuaris = this.getUsuariList(); //agaf tots els usuaris i despeses del grup, les pas a array per iterar
        Object[] usuaris = lUsuaris.toArray();
        List<Despesa> lDespeses = this.getDespesaList();
        Object[] despeses = lDespeses.toArray();
        for (Object usuari : usuaris) {
            //per cada usuari del grup, faré un bucle 
            BigDecimal importPagat = new BigDecimal(0);
            Usuari u = (Usuari) usuari; //convertesc objecte a usuari
            List<Pagador> lPagadorsUsuari = u.getPagadorList(); //agaf tots els pagadors que pengen de l'usuari
            Object[] pagadorsUsuaris = lPagadorsUsuari.toArray(); //ho convertesc a un array per iterar després
            for (Object despesa : despeses) { //per cada despesa (del grup)
                // vaig despesa per despesa i agaf els seus pagadors a una llista
                Despesa d = (Despesa) despesa;
                List<Pagador> lPagadorDespesa = d.getPagadorList();
                for (Object pagadorsUsuari : pagadorsUsuaris) {
                    // per cada pagador de l'usuari, mir si està a la llista de pagadors de la despesa
                    Pagador pagadorUsuari = (Pagador) pagadorsUsuari;
                    if (lPagadorDespesa.contains(pagadorUsuari) && pagadorUsuari.haPagat()) { //si hi està hi han pagat, sum 
                        importPagat = importPagat.add(pagadorUsuari.getContribucio());
                    }
                }
            }
            System.out.println("L'usuari " + u + "ha pagat " + importPagat + " €"); //al final del bucle, imprimesc
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grup)) {
            return false;
        }
        Grup other = (Grup) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Grup[id= " + id + " Nom:" + nom + " ]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Date getDatacreacio() {
        return datacreacio;
    }

    public void setDatacreacio(Date datacreacio) {
        this.datacreacio = datacreacio;
    }

    public List<Usuari> getUsuariList() {
        return usuariList;
    }

    public void setUsuariList(List<Usuari> usuariList) {
        this.usuariList = usuariList;
    }

    public List<Despesa> getDespesaList() {
        return despesaList;
    }

    public void setDespesaList(List<Despesa> despesaList) {
        this.despesaList = despesaList;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tricountmarcmas.Despesa;

/**
 *
 * @author Marc Mas
 */
@Entity

@Table(name = "usuari")
@NamedQueries({
    @NamedQuery(name = "Usuari.findAll", query = "SELECT u FROM Usuari u"),
    @NamedQuery(name = "Usuari.findByCorreu", query = "SELECT u FROM Usuari u WHERE u.correu = :correu"),
    @NamedQuery(name = "Usuari.findByNom", query = "SELECT u FROM Usuari u WHERE u.nom = :nom"),
    @NamedQuery(name = "Usuari.findByLlinatge1", query = "SELECT u FROM Usuari u WHERE u.llinatge1 = :llinatge1"),
    @NamedQuery(name = "Usuari.findByLlinatge2", query = "SELECT u FROM Usuari u WHERE u.llinatge2 = :llinatge2"),
    @NamedQuery(name = "Usuari.findByIban", query = "SELECT u FROM Usuari u WHERE u.iban = :iban"),
    @NamedQuery(name = "Usuari.findByAlias", query = "SELECT u FROM Usuari u WHERE u.alias = :alias")})
public class Usuari implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "correu")
    private String correu;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "llinatge1")
    private String llinatge1;
    @Column(name = "llinatge2")
    private String llinatge2;
    @Basic(optional = false)
    @Column(name = "iban")
    private String iban;
    @Column(name = "alias")
    private String alias;
    @ManyToMany(mappedBy = "usuariList")
    private List<Grup> grupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagadororiginal")
    private List<Despesa> despesaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuari")
    private List<Pagador> pagadorList;

    public Usuari() {
    }

    public Usuari(String correu) {
        this.correu = correu;
    }

    public Usuari(String correu, String nom, String llinatge1, String iban) {
        this.correu = correu;
        this.nom = nom;
        this.llinatge1 = llinatge1;
        this.iban = iban;
    }

    public Usuari(String correu, String nom, String llinatge1, String llinatge2, String iban) {
        this.correu = correu;
        this.nom = nom;
        this.llinatge1 = llinatge1;
        this.llinatge2 = llinatge2;
        this.iban = iban;
    }

    public Usuari(String correu, String nom, String llinatge1, String llinatge2, String alias, String iban) {
        this.correu = correu;
        this.nom = nom;
        this.llinatge1 = llinatge1;
        this.llinatge2 = llinatge2;
        this.alias = alias;
        this.iban = iban;
    }

    public static Usuari crearUsuariConsola(Scanner s) {
        s.nextLine(); //buidam el búfer de scanner
        System.out.println("Quin es el seu correu?");
        String correu = s.nextLine();
        while (Usuari.correuExisteix(correu)) { //si el correu ja existeix, demanam el correu un altre vegada
            System.out.println("El correu introduit ja està a la base de dades!");
            System.out.println("Introdueix un correu que no estigui present!");
            correu = s.nextLine();
        }
        while (!correuValid(correu)) { //si falla la validacio de regex, el tornam a demanar
            System.out.println("El correu introduit no es vàlid!");
            System.out.println("Introdueix un correu vàlid");
            correu = s.nextLine();
        }
        System.out.println("Quin es el seu nom d'usuari?"); //agafam tots els paràmetres per consola
        String alias = s.nextLine();
        System.out.println("Quin es el seu nom");
        String nom = s.nextLine();
        while (nom.length() == 0) {
            System.out.println("Not pot deixar el nom buit, per favor, introdueixi un nom");
            nom = s.nextLine();
        }
        System.out.println("Quin es el seu primer llinatge?");
        String llinatge1 = s.nextLine();
        System.out.println("Quin es el seu segon llinatge");
        String llinatge2 = s.nextLine();
        System.out.println("Quin es el seu IBAN?");
        String iban = s.nextLine();
        while (!ibanValid(iban)) { //fa una validacio de regex per validar l'iban
            System.out.println("Introdueixi un IBAN vàlid!");
            System.out.println("Format: 2 lletres, de 4 a 30 nombres");
            iban = s.nextLine();
        }
        return new Usuari(correu, nom, llinatge1, llinatge2, alias, iban);
    }

    public void mostrarDespeses(boolean nomesPendents) {
        List<Pagador> l = this.getPagadorList(); //agaf tots els pagadors que pengen de l'usuari
        Object pagadors[] = l.toArray(); //ho convertesc a un array
        boolean hiHaDespeses = true;
        if (pagadors.length == 0) {  //si no existeix cap pagador assignat a l'usuari
            System.out.println("No formes part de cap despesa!");
            hiHaDespeses = false;
        }
        if (nomesPendents) {
            if (!this.teDespesesPendents()) { //mostrà un missatge si no hi ha despeses pendents
                hiHaDespeses = false;
            }
        }
        if (hiHaDespeses) { //si tenim més d'un pagador, i tenim despeses pendents (en cas de que ho haguem especificat), mostram
            System.out.println("Formes part de les seguents despeses");
            for (Object pagador : pagadors) {
                //per cada element pagador, agaf la seva despesa i deman la part de l'usuari d'aquella despesa
                Pagador p = (Pagador) pagador;
                Despesa d = p.getDespesa();
                d.mostrarPart((Usuari) this, nomesPendents);
            }
        }
    }

    public boolean teDespesesPendents() {
        List<Pagador> l = this.getPagadorList(); //agaf tots els pagadors que pengen de l'usuari
        Object pagadors[] = l.toArray(); //ho convertesc a un array
        for (Object pagador : pagadors) {
            Pagador p = (Pagador) pagador;
            if (!p.haPagat()) {
                return true; //vaig per tot l'array, si hi ha cap despesa que NO hagui pagat, te despeses pendents
            }
        }
        System.out.println("No tens despeses pendents!");
        return false;
    }

    public static Usuari obtenirUsuari(String correu) {
        Usuari u = UsuariDAO.find(correu);
        if (u == null) {
            System.out.println("Aquest email no està la BBDD!"); //si obtenc resultats, l'usuari ja està a la BBDD aixi que rollback i mostram error
        }
        return u;
    }

    public static Usuari obtenirUsuari(String correu, EntityManager em) {
        Usuari u = UsuariDAO.find(correu, em);
        if (u == null) {
            System.out.println("Aquest email no està la BBDD!"); //si obtenc resultats, l'usuari ja està a la BBDD aixi que rollback i mostram error
        }
        return u;
    }

    public static Usuari obtenirUsuariConsola(Scanner s, EntityManager em) {
        System.out.println("Introdueix el correu de l'usuari");
        String correu = s.next();
        Usuari u = UsuariDAO.find(correu, em);
        while (u == null) {
            System.out.println("Aquest email no està la BBDD!");
            System.out.println("Introdueix un correu valid!");
            correu = s.next();
            u = UsuariDAO.find(correu);
        }
        return u;
    }

    public void afegirGrups(Scanner s, EntityManager em) {
        int idGrup = 1; //per que el bucle s'executi
        s.nextLine(); //per resetejar scanner
        while (idGrup > 0) {
            System.out.println("Introduint l'usuari " + this.getCorreu() + " a grups: "); //mostram quin usuari esteim afegint
            this.veureGrups(); //mostram els grups actuals de l'usuari
            System.out.println("Per aturar d'introduir, escrigui un nombre negatiu");
            System.out.println("Introdueixi l'id del grup"); //demanam l'id del grup
            idGrup = s.nextInt();
            if (idGrup > 0) { //si es positiva, volem afegir un altre grup, aixi que obtenim el grup 
                Grup g = Grup.obtenirGrup(idGrup, em);
                while (g == null && idGrup > 0) {
                    System.out.println("Introdueix una id valida!");
                    idGrup = s.nextInt();
                    g = Grup.obtenirGrup(idGrup, em);
                }
                g.afegirUsuari(correu, em); //afegim l'usuari al grup, i afegim el grup a l'usuari també (per evitar que no es mostri a la llista)
                this.afegirGrup(g.getId(), em);
            }
        }

    }

    public void afegirGrup(int idGrup, EntityManager em) {
        List<Grup> grupsAntics = this.getGrupList(); //agafam la llista de grups de l'usuari
        Grup g = Grup.obtenirGrup(idGrup); //trobam el grup amb l'id passat per consola
        grupsAntics.add(g); //afegim el grup a la llista de grups
        this.setGrupList(grupsAntics); //actualitazam
        UsuariDAO uDAO = new UsuariDAO(em); //cridam un DAO i persistim a BBDD
        uDAO.updateDatabase();
    }

    public void veureGrups() {
        List<Grup> l = this.getGrupList(); //agafam la llista de l'usuari
        Object grups[] = l.toArray(); //ho convertesc a un array
        if (grups.length == 0) {
            System.out.println("Actualment no pertany a cap grup!");
        } else {
            System.out.println("Grups actuals:");
            for (Object grup : grups) {
                System.out.println((Grup) grup); //imprimesc tots els grups de l'usuari
            }
        }
    }

    public static boolean correuExisteix(String correu) {
        Usuari u = UsuariDAO.find(correu);
        return u != null;
    }

    public static boolean ibanValid(String iban) {
        Pattern p = Pattern.compile("^[A-Z]{2}[0-9]{4,30}"); //regex que comprova que hi ha dues lletres, i despres entre 4 i 30 numeros
        // ES30 -> no passa
        // 300000 -> no passa
        // ES300603 -> passa
        // 3000ES -> no passa
        Matcher m = p.matcher(iban);
        return m.find();
    }

    public static boolean correuValid(String correu) {
        Pattern p = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"); //regex per comprovar que hi ha una paraula, una @, una altra paraula, un . i entre 2 i 4 caràcters
        // test@gmail.com -> passa
        // test@gmail -> no passa
        // test -> no passa
        // testgmail.com -> no passa
        Matcher m = p.matcher(correu);
        return m.find();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correu != null ? correu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuari)) {
            return false;
        }
        Usuari other = (Usuari) object;
        return !((this.correu == null && other.correu != null) || (this.correu != null && !this.correu.equals(other.correu)));
    }

    @Override
    public String toString() {
        return this.getFullName() + "(" + correu + ")";
    }

    public void printFull() {
        System.out.println("Correu: " + correuCensurat());
        System.out.println("Nom Complet: " + nom + " " + llinatge1 + " " + " " + llinatge2);
        System.out.println("Alias: " + alias);
        System.out.println("IBAN: " + ibanCensurat());
    }

    public String correuCensurat() {
        String correuSeparat[] = this.correu.split("@");
        String correuCensurat = "";
        for (String tros : correuSeparat) {
            correuCensurat += tros.substring(0, 3) + "****";
        }
        return correuCensurat;
    }

    public String ibanCensurat() {
        String part1 = iban.substring(0, 4);
        return part1 + "*******";
    }

    public String getFullName() {
        return "" + nom + " " + llinatge1 + " " + llinatge2;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatge1() {
        return llinatge1;
    }

    public void setLlinatge1(String llinatge1) {
        this.llinatge1 = llinatge1;
    }

    public String getLlinatge2() {
        return llinatge2;
    }

    public void setLlinatge2(String llinatge2) {
        this.llinatge2 = llinatge2;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Grup> getGrupList() {
        return grupList;
    }

    public void setGrupList(List<Grup> grupList) {
        this.grupList = grupList;
    }

    public List<Despesa> getDespesaList() {
        return despesaList;
    }

    public void setDespesaList(List<Despesa> despesaList) {
        this.despesaList = despesaList;
    }

    public List<Pagador> getPagadorList() {
        return pagadorList;
    }

    public void setPagadorList(List<Pagador> pagadorList) {
        this.pagadorList = pagadorList;
    }
}

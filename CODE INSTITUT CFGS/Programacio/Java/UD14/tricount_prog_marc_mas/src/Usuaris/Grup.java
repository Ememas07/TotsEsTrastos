/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.io.Serializable;
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
import javax.persistence.Query;
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

    public Grup(String descripcio, Date datacreacio) {
        this.descripcio = descripcio;
        this.datacreacio = new Date();
    }

    public static Grup crearGrupConsola(Scanner s) {
        System.out.println("Introdueix la descripcio del teu grup");
        String descripcio = s.nextLine();
        Date datacreacio = new Date();
        return new Grup(descripcio, datacreacio);
    }

    public static Grup obtenirGrupConsola(Scanner s, EntityManager em) {
        GrupDAO gDAO = new GrupDAO(em);
        System.out.println("Introdueix la id del grup");
        Grup g = null;
        while (g == null) {
            int idGrup = s.nextInt();
            g = GrupDAO.find(idGrup);
            if (g == null) {
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
        while (!correu.equals("Atura")) {
            System.out.println("Introduint Usuaris al grup: " + this.getId());
            this.veureUsuaris();
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
        Usuari u = Usuari.obtenirUsuari(mailUsuari);
        if (usuarisAntics.contains(u)) {
            System.out.println("L'usuari ja està al grup!");
        } else {
            if (u != null) {
                usuarisAntics.add(u);
                this.setUsuariList(usuarisAntics);
                GrupDAO gDAO = new GrupDAO(em);
                gDAO.edit(this);
                System.out.println("S'ha afegit l'usuari " + u.toString() + " al grup " + this.getId());
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
            for (int i = 0; i < usuaris.length; i++) {
                System.out.println((Usuari) usuaris[i]); //imprimesc tots els usuaris del grup
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
            for (int i = 0; i < despeses.length; i++) {
                System.out.println((Despesa) despeses[i]); //imprimesc tots els usuaris del grup
            }
        }
    }

    public void mostrarDeutes(EntityManager em) {
        String jpql = "SELECT * FROM mostrarDeutes(?)";
        Query q = em.createNativeQuery(jpql).setParameter(1, this.getId());
        List<Object> l = q.getResultList();
        if (l.isEmpty()) {
            System.out.println("No hi ha deutes al grup!");
        }
        Object[] files = l.toArray();
        // Aquesta llista conté dos arrays
        // La llista es converteix a un array (files) que conté un Objecte per cada fila
        for (Object columnes : files) {
            //Recorresc tot l'array de files, i per cada element, agaf un element i el guard a "columnes" (temporalment)
            Object[] c = (Object[]) columnes;
            // Després, com "columnes" és un array amb les 3 columnes, faig un cast de objecte a array de objectes
            // i ho assigna a la variable c (columna)
            // despres faig un print, 0 es el recaudador, 1 el debtor, 2 la quantitat, per com está la funció a PostgresQL
            System.out.println("" + c[1] + " deu " + c[2] + " € a " + c[0]);
        }
    }

    public void mostrarDespesesPerCategoria(EntityManager em) {
        String jpql = "SELECT * FROM mostrarDespesesCategoria(?)";
        Query q = em.createNativeQuery(jpql).setParameter(1, this.getId());
        List<Object> l = q.getResultList(); // mirar
        Object[] files = l.toArray();
        if (l.isEmpty()) {
            System.out.println("No hi ha despeses al grup!");
        }
        // Aquesta llista conté dos arrays
        // La llista es converteix a un array (files) que conté un Objecte per cada fila
        for (Object columnes : files) {
            //Recorresc tot l'array de files, i per cada element, agaf un element i el guard a "columnes" (temporalment)
            Object[] c = (Object[]) columnes;
            // Després, com "columnes" és un array amb les 3 columnes, faig un cast de objecte a array de objectes
            // i ho assigna a la variable c (columna)
            // despres faig un print, 0 es la categoria, 1 l'import, 2 el %, per com está la funció a PostgresQL
            System.out.println("Categoria: " + c[0]);
            System.out.println("Import Gastat " + c[1] + " (" + c[2] + ")");
        }
    }

    public void mostrarDespesesPerUsuari(EntityManager em) {
        String jpql = "SELECT * FROM mostrarDespesesUsuari(?)";
        Query q = em.createNativeQuery(jpql).setParameter(1, this.getId());
        List<Object> l = q.getResultList();
        Object[] files = l.toArray();
        if (l.isEmpty()) {
            System.out.println("No hi ha despeses al grup!");
        }
        // Aquesta llista conté dos arrays
        // La llista es converteix a un array (files) que conté un Objecte per cada fila
        for (Object columnes : files) {
            //Recorresc tot l'array de files, i per cada element, agaf un element i el guard a "columnes" (temporalment)
            Object[] c = (Object[]) columnes;
            // Després, com "columnes" és un array amb les 3 columnes, faig un cast de objecte a array de objectes
            // i ho assigna a la variable c (columna)
            // despres faig un print, 0 es el recaudador, 1 el debtor, 2 la quantitat, per com está la funció a PostgresQL
            System.out.println("Usuari" + c[0] + " Import Gastat: " + c[1] + " €");
        }
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tricountmarcmas.Grup[ id=" + id + " ]";
    }

}

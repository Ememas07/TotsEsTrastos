/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("Quin es el seu correu?");
        String correu = s.nextLine();
        while (Usuari.correuExisteix(correu)) {
            System.out.println("El correu introduit ja està a la base de dades!");
            System.out.println("Introdueix un correu que no estigui present!");
            correu = s.nextLine();
        }
        System.out.println("Quin es el seu nom d'usuari?");
        String alias = s.nextLine();
        System.out.println("Quin es el seu nom");
        String nom = s.nextLine();
        System.out.println("Quin es el seu primer llinatge?");
        String llinatge1 = s.nextLine();
        System.out.println("Quin es el seu segon llinatge");
        String llinatge2 = s.nextLine();
        System.out.println("Quin es el seu IBAN?");
        String iban = s.nextLine();
        return new Usuari(correu, alias, nom, llinatge1, llinatge2, iban);
    }

    public void mostrarDespeses() {
        List<Despesa> l = this.getDespesaList();
        Object despeses[] = l.toArray(); //ho convertesc a un array
        if (despeses.length == 0) {
            System.out.println("No has fet cap despesa");
        } else {
            System.out.println("Formes part de les seguents despeses: ");
            for (Object despesa : despeses) {
                Despesa d = (Despesa) despesa;
                d.mostrarPart(this);
            }
        }
    }

    public void mostrarDespesesPendents() {
        List<Despesa> l = this.getDespesaList();
        Object despeses[] = l.toArray(); //ho convertesc a un array
        if (despeses.length == 0) {
            System.out.println("No has fet cap despesa");
        } else {
            System.out.println("Formes part de les seguents despeses: ");
            for (Object despesa : despeses) {
                Despesa d = (Despesa) despesa;
                d.mostrarPartPendent(this);
            }
        }
    }

    public static Usuari obtenirUsuari(String correu) {
        Usuari u = UsuariDAO.find(correu);
        if (u == null) {
            System.out.println("Aquest email no està la BBDD!"); //si obtenc resultats, l'usuari ja està a la BBDD aixi que rollback i mostram error
        }
        return u;
    }

    public static Usuari obtenirUsuariConsola(Scanner s, EntityManager em) {
        System.out.println("Introdueix el correu de l'usuari que vol afegir a grups");
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
            System.out.println("Introduint l'usuari " + this.getCorreu() + " a grups: ");
            this.veureGrups();
            System.out.println("Per aturar d'introduir, escrigui un nombre negatiu");
            System.out.println("Introdueixi l'id del grup");
            idGrup = s.nextInt();
            if (idGrup > 0) {
                Grup g = Grup.obtenirGrup(idGrup, em);
                while (g == null && idGrup > 0) {
                    System.out.println("Introdueix una id valida!");
                    idGrup = s.nextInt();
                    g = Grup.obtenirGrup(idGrup, em);
                }
                if (idGrup > 0 && g != null) {
                    g.afegirUsuari(correu, em);
                    this.afegirGrup(g.getId(), em);
                }
            }
        }

    }

    public void afegirGrup(int idGrup, EntityManager em) {
        List<Grup> grupsAntics = this.getGrupList();
        Grup g = Grup.obtenirGrup(idGrup);
        grupsAntics.add(g);
        this.setGrupList(grupsAntics);
        UsuariDAO uDAO = new UsuariDAO(em);
        uDAO.edit(this);
    }

    public void veureGrups() {
        List<Grup> l = this.getGrupList(); //agafam la llista de l'usuari
        Object grups[] = l.toArray(); //ho convertesc a un array
        System.out.println("Llista: " + grups.length);
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
        return "tricountmarcmas.Usuari[ correu=" + correu + " Nom Complet =" + nom + " " + llinatge1 + " " + " " + llinatge2 + "]";
    }

    public void printFull() {
        System.out.println("Correu: " + correu);
        System.out.println("Nom: " + nom);
        System.out.println("Llinatges: " + llinatge1 + " " + llinatge2);
        System.out.println("Alias: " + alias);
        System.out.println("IBAN: " + iban);
    }

    public String getFullName() {
        return "" + nom + " " + llinatge1 + " " + llinatge2;
    }
}

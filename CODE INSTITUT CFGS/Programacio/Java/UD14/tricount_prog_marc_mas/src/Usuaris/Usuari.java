/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import javax.persistence.*;
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
    @Column(name = "iban2")
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

    public Usuari(Scanner s) {
        System.out.println("Quin es el seu correu?");
        this.correu = s.nextLine();
        System.out.println("Quin es el seu nom d'usuari?");
        this.alias = s.nextLine();
        System.out.println("Quin es el seu nom");
        this.nom = s.nextLine();
        System.out.println("Quin es el seu primer llinatge?");
        this.llinatge1 = s.nextLine();
        System.out.println("Quin es el seu segon llinatge");
        this.llinatge2 = s.nextLine();
        System.out.println("Quin es el seu IBAN?");
        this.iban = s.nextLine();
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
        if ((this.correu == null && other.correu != null) || (this.correu != null && !this.correu.equals(other.correu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tricountmarcmas.Usuari[ correu=" + correu + " ]";
    }
    
    public void printFull(){
        System.out.println("Correu: "+correu);
        System.out.println("Nom: "+nom);
        System.out.println("Llinatges: "+llinatge1+" "+llinatge2);
        System.out.println("Alias: "+alias);
        System.out.println("IBAN: "+iban);
    }
}

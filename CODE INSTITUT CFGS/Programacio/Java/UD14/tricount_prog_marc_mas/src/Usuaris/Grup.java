/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Basic(optional = false)
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
    
    public Grup(Scanner s){
        System.out.println("Introdueix la descripcio del teu grup");
        this.descripcio = s.nextLine();
        this.datacreacio = new Date();
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

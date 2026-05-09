/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuaris;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import tricountmarcmas.Despesa;

/**
 *
 * @author Marc Mas
 */
@Entity
@Table(name = "pagador")
@NamedQueries({
    @NamedQuery(name = "Pagador.findAll", query = "SELECT p FROM Pagador p"),
    @NamedQuery(name = "Pagador.findById", query = "SELECT p FROM Pagador p WHERE p.id = :id"),
    @NamedQuery(name = "Pagador.findByContribucio", query = "SELECT p FROM Pagador p WHERE p.contribucio = :contribucio"),
    @NamedQuery(name = "Pagador.findByHapagat", query = "SELECT p FROM Pagador p WHERE p.hapagat = :hapagat")})
public class Pagador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "contribucio")
    private double contribucio;
    @Basic(optional = false)
    @Column(name = "hapagat")
    private boolean hapagat;
    @JoinColumn(name = "iddespesa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Despesa iddespesa;
    @JoinColumn(name = "idusuari", referencedColumnName = "correu")
    @ManyToOne(optional = false)
    private Usuari idusuari;

    public Pagador() {
    }

    public Pagador(Integer id) {
        this.id = id;
    }

    public Pagador(Integer id, double contribucio, boolean hapagat) {
        this.id = id;
        this.contribucio = contribucio;
        this.hapagat = hapagat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getContribucio() {
        return contribucio;
    }

    public void setContribucio(double contribucio) {
        this.contribucio = contribucio;
    }

    public boolean getHapagat() {
        return hapagat;
    }

    public void setHapagat(boolean hapagat) {
        this.hapagat = hapagat;
    }

    public Despesa getIddespesa() {
        return iddespesa;
    }

    public void setIddespesa(Despesa iddespesa) {
        this.iddespesa = iddespesa;
    }

    public Usuari getIdusuari() {
        return idusuari;
    }

    public void setIdusuari(Usuari idusuari) {
        this.idusuari = idusuari;
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
        if (!(object instanceof Pagador)) {
            return false;
        }
        Pagador other = (Pagador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tricountmarcmas.Pagador[ id=" + id + " ]";
    }
    
}

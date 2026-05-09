/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tricountmarcmas;

import Usuaris.Grup;
import Usuaris.Pagador;
import Usuaris.Usuari;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marc Mas
 */
@Entity
@Table(name = "despesa")
@NamedQueries({
    @NamedQuery(name = "Despesa.findAll", query = "SELECT d FROM Despesa d"),
    @NamedQuery(name = "Despesa.findById", query = "SELECT d FROM Despesa d WHERE d.id = :id"),
    @NamedQuery(name = "Despesa.findByDatadespesa", query = "SELECT d FROM Despesa d WHERE d.datadespesa = :datadespesa"),
    @NamedQuery(name = "Despesa.findByDescripcio", query = "SELECT d FROM Despesa d WHERE d.descripcio = :descripcio"),
    @NamedQuery(name = "Despesa.findByCategoria", query = "SELECT d FROM Despesa d WHERE d.categoria = :categoria"),
    @NamedQuery(name = "Despesa.findByImporttotal", query = "SELECT d FROM Despesa d WHERE d.importtotal = :importtotal"),
    @NamedQuery(name = "Despesa.findByImportpagat", query = "SELECT d FROM Despesa d WHERE d.importpagat = :importpagat")})
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "datadespesa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datadespesa;
    @Column(name = "descripcio")
    private String descripcio;
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @Column(name = "importtotal")
    private double importtotal;
    @Basic(optional = false)
    @Column(name = "importpagat")
    private double importpagat;
    @JoinColumn(name = "idgrup", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Grup idgrup;
    @JoinColumn(name = "pagadororiginal", referencedColumnName = "correu")
    @ManyToOne(optional = false)
    private Usuari pagadororiginal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddespesa")
    private List<Pagador> pagadorList;

    public Despesa() {
    }

    public Despesa(Integer id) {
        this.id = id;
    }

    public Despesa(Integer id, Date datadespesa, double importtotal, double importpagat) {
        this.id = id;
        this.datadespesa = datadespesa;
        this.importtotal = importtotal;
        this.importpagat = importpagat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatadespesa() {
        return datadespesa;
    }

    public void setDatadespesa(Date datadespesa) {
        this.datadespesa = datadespesa;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getImporttotal() {
        return importtotal;
    }

    public void setImporttotal(double importtotal) {
        this.importtotal = importtotal;
    }

    public double getImportpagat() {
        return importpagat;
    }

    public void setImportpagat(double importpagat) {
        this.importpagat = importpagat;
    }

    public Grup getIdgrup() {
        return idgrup;
    }

    public void setIdgrup(Grup idgrup) {
        this.idgrup = idgrup;
    }

    public Usuari getPagadororiginal() {
        return pagadororiginal;
    }

    public void setPagadororiginal(Usuari pagadororiginal) {
        this.pagadororiginal = pagadororiginal;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despesa)) {
            return false;
        }
        Despesa other = (Despesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tricountmarcmas.Despesa[ id=" + id + " ]";
    }
    
}

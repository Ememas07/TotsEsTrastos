/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tricountmarcmas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Usuaris.Grup;
import Usuaris.Pagador;
import Usuaris.PagadorDAO;
import Usuaris.Usuari;

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

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "despesa_id_seq")
    @SequenceGenerator(name = "despesa_id_seq", sequenceName = "despesa_id_seq", allocationSize = 1, initialValue = 1)
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
    private BigDecimal importtotal;
    @Basic(optional = false)
    @Column(name = "importpagat")
    private BigDecimal importpagat;
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

    public Despesa(Integer id, Date datadespesa, BigDecimal importtotal, BigDecimal importpagat) {
        this.id = id;
        this.datadespesa = datadespesa;
        this.importtotal = importtotal;
        this.importpagat = importpagat;
    }

    private Despesa(Date datadespesa, Usuari pagadororiginal, Grup grup, BigDecimal importtotal, String descripcio, String categoria) {
        this.datadespesa = datadespesa;
        this.pagadororiginal = pagadororiginal;
        this.idgrup = grup;
        this.importtotal = importtotal;
        this.importpagat = new BigDecimal(0);
        this.descripcio = descripcio;
        this.categoria = categoria;
    }

    public static Despesa crearDespesaConsola(Scanner s, EntityManager em) {
        System.out.println("Quina es la data de la despesa?");
        System.out.println("Es pot deixar buit si ha estat creada ara");
        String d = s.nextLine();
        Date datadespesa = new Date();
        if (d.length() != 0) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            try {
                datadespesa = formatter.parse(d);
            } catch (ParseException ex) {
                System.out.println("Error guardant la data");
                datadespesa = new Date();
            }
        }
        Usuari pagadororiginal = Usuari.obtenirUsuariConsola(s, em);
        Grup grup = Grup.obtenirGrupConsola(s, em);
        System.out.println("Quin va ser l'import total de la depesa?");
        BigDecimal bd = new BigDecimal(s.nextFloat());
        BigDecimal importtotal = bd;
        s.nextLine();
        System.out.println("Descripcio de la despesa");
        String descripcio = s.nextLine();
        System.out.println("Categoria de la despesa");
        String categoria = s.nextLine();
        return new Despesa(datadespesa, pagadororiginal, grup, importtotal, descripcio, categoria);
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

    public BigDecimal getImporttotal() {
        return importtotal;
    }

    public BigDecimal getImporttotalBD() {
        return importtotal;
    }

    public void setImporttotal(BigDecimal importtotal) {
        this.importtotal = importtotal;
    }

    public BigDecimal getImportpagat() {
        return importpagat;
    }

    public BigDecimal getImportpagatBD() {
        return importpagat;
    }

    public void setImportpagat(BigDecimal importpagat) {
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "tricountmarcmas.Despesa[ id=" + id + " Descripcio: " + descripcio + " Categoria: " + categoria + " ]";
    }

    public void actualitzarImport(EntityManager em) {
        List<Pagador> l = this.getPagadorList();
        Object pagadors[] = l.toArray();
        BigDecimal totalPagat = new BigDecimal(0);
        for (Object pagador : pagadors) {
            Pagador p = (Pagador) pagador;
            if (p.haPagat()) {
                totalPagat = totalPagat.add(p.getContribucio());
            }
        }
        this.setImportpagat(totalPagat);
        DespesaDAO dDAO = new DespesaDAO(em);
        dDAO.edit(this);
    }

    public void assignarPagadorsTeclat(Scanner s, EntityManager em) {
        System.out.println("Vol assignar un import manual o pagar a parts iguals entre els pagadors restants?");
        System.out.println("1: Asignar imports manuals");
        System.out.println("2: Parts iguals");
        int distribucio = s.nextInt();
        System.out.println("Quants de pagadors més hi ha?");
        int numPagadors = (int) s.nextFloat();
        PagadorDAO pDAO = new PagadorDAO(em);
        BigDecimal importPendent = this.getImporttotal();
        BigDecimal partsIguals = importPendent.divide(new BigDecimal(numPagadors), 2, RoundingMode.DOWN);
        BigDecimal contribucio = partsIguals;
        if (distribucio != 2) {
            System.out.println("Import total: " + importPendent);
            System.out.println("Quin es l'import que paga " + this.getPagadororiginal().getFullName() + "?");
            contribucio = new BigDecimal(s.nextFloat());
        }
        Pagador[] pagadors = new Pagador[numPagadors + 1]; //guardam a un array per poder crear tots els pagadors al final i no poder deixar la despesa a mitges
        pagadors[0] = new Pagador(contribucio, this.getPagadororiginal(), this, true); //la primera se guarda com true perque es l'original
        int valorsAssignats = 1;
        importPendent = importPendent.subtract(contribucio);
        for (int i = 0; i < numPagadors; i++) {
            System.out.println("Pagador extra " + (i + 1));
            Usuari u = Usuari.obtenirUsuariConsola(s, em);
            if (distribucio != 2) {
                System.out.println("Si vol seguir assignants imports individuals, introdueix 1");
                System.out.println("Si vol assignar imports iguals a tots els usuaris restants, introdueix 2");
                distribucio = s.nextInt();
            }
            contribucio = importPendent.divide(new BigDecimal(numPagadors + 1 - valorsAssignats), 2, RoundingMode.DOWN);
            if (distribucio != 2) {
                valorsAssignats += 1;
                System.out.println("Pendent per pagar: " + importPendent);
                System.out.println("Quin es l'import que paga " + u.getFullName() + "?");
                contribucio = new BigDecimal(s.nextFloat());
                importPendent = importPendent.subtract(contribucio);
            }
            pagadors[i + 1] = new Pagador(contribucio, u, this, false);
        }
        for (Pagador pagador : pagadors) {
            pDAO.create(pagador); //recorresc tot l'array i afegesc tots els pagadors
        }
        this.actualitzarImport(em);
    }

    public void mostrarPart(Usuari u) {
        List<Pagador> l = this.getPagadorList();
        Object pagadors[] = l.toArray(); //ho convertesc a un array
        for (int i = 0; i < pagadors.length; i++) {
            Pagador p = (Pagador) pagadors[i];
            if (p.getUsuari().getCorreu().equals(u.getCorreu())) {
                System.out.println(this);
                System.out.print("La teva part és: " + p.getContribucio());
                if (p.haPagat()) {
                    System.out.println("(Pagada)");
                } else {
                    System.out.println("(No Pagada)");
                }
            }
        }
    }

    public void mostrarPartPendent(Usuari u) {
        List<Pagador> l = this.getPagadorList();
        Object pagadors[] = l.toArray(); //ho convertesc a un array
        for (int i = 0; i < pagadors.length; i++) {
            Pagador p = (Pagador) pagadors[i];
            if (p.getUsuari().getCorreu().equals(u.getCorreu())) {
                if (!p.haPagat()) {
                    System.out.println(this);
                    System.out.println("La teva part és: " + p.getContribucio());
                }
            }
        }
    }

    public static void marcarPagament(Scanner s, EntityManager em) {
        System.out.println("Formes part de les seguents despeses: ");
        Usuari u = Usuari.obtenirUsuariConsola(s, em);
        u.mostrarDespeses();
        Despesa d = Despesa.obtenirDespesaConsola(s);
        d.marcarPagament(u, s, em);
    }

    public void marcarPagament(Usuari u, Scanner s, EntityManager em) {
        List<Pagador> l = this.getPagadorList();
        Object pagadors[] = l.toArray(); //ho convertesc a un array
        boolean trobat = false; //ho emprarem per si introdueix una despesa on ell no pertany per mostrar un error
        for (Object pagador : pagadors) {
            Pagador p = (Pagador) pagador;
            if (p.getUsuari().getCorreu().equals(u.getCorreu())) {
                trobat = true;
                System.out.println("Despesa: " + this);
                System.out.println("Confirmi que vol pagar " + p.getContribucio() + " de la despesa ");
                System.out.println("Introdueixi 1 per confirmar, 0 per cancellar");
                int decisio = s.nextInt();
                if (decisio == 1) {
                    p.setPagat(true);
                    System.out.println("S'ha confirmat el pagament de " + p.getContribucio());
                    PagadorDAO pDAO = new PagadorDAO(em);
                    pDAO.edit(p);
                }
            }
        }
        if (!trobat) {
            System.out.println("No s'ha trobat el vostre registre de pagador a la despesa seleccionada!");
        }
    }

    public static Despesa obtenirDespesa(int idDespesa) {
        Despesa d = DespesaDAO.find(idDespesa);
        if (d == null) {
            System.out.println("Aquesta despesa no s'ha trobat!");
        }
        return d;
    }

    public static Despesa obtenirDespesaConsola(Scanner s) {
        System.out.println("Introdueix l'id de la despesa");
        int idDespesa = s.nextInt();
        Despesa d = DespesaDAO.find(idDespesa);
        while (d == null) {
            System.out.println("Aquesta despesa no s'ha trobat!");
            System.out.println("Introdueix una despesa valida");
            idDespesa = s.nextInt();
            d = DespesaDAO.find(idDespesa);
        }
        return d;
    }

}

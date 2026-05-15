/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tricountmarcmas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        s.nextLine(); //buidam el búfer de scanner
        System.out.println("La despesa s'ha creat ara o vol introduir una data?");
        System.out.println("1: Introduir data");
        System.out.println("2: Emprar data actual");
        int seleccioData = s.nextInt();
        Date datadespesa = new Date();
        if (seleccioData == 1) {
            datadespesa = demanarDataConsola(s);
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

    public static Date demanarDataConsola(Scanner s) {
        System.out.println("Per favor, introdueixi la dada en format DD/MM/YYYY");
        System.out.println("Assegura't de posar 0s si cal, es a dir, 03/07/2026");
        String text = s.next();
        Pattern p = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
        Matcher m = p.matcher(text);
        while (!m.find()) {
            System.out.println("Introdueix una data amb el format correcte!");
            System.out.println("Assegura't de posar 0s si cal, es a dir, 03/07/2026");
            text = s.next();
            m = p.matcher(text);
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parsedDate = LocalDate.parse(text, formatter);
            LocalTime currentTime = LocalTime.now();
            LocalDateTime combinedDateTime = LocalDateTime.of(parsedDate, currentTime);
            return Date.from(combinedDateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            System.out.println("Ha ocorregut un error guardant la data");
            System.out.println("La despesa es crearà amb la data actual");
        }
        return new Date();

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
        int numPagadors = s.nextInt();
        BigDecimal importPendent = this.getImporttotal(); //import Pendent per pagar a la despesa
        BigDecimal partsIguals = importPendent.divide(new BigDecimal(numPagadors), 2, RoundingMode.DOWN);
        //dividesc l'import total de la despesa entre els pagadors que hi ha
        BigDecimal contribucio = partsIguals; //la contribucio sera a parts iguals 
        if (distribucio != 2) { //si la contribucio NO son parts iguals, demanam quan paga el pagador original
            System.out.println("Import total: " + importPendent);
            System.out.println("Quin es l'import que paga " + this.getPagadororiginal().getFullName() + "?");
            contribucio = new BigDecimal(s.nextFloat()); //i li assignam la seva contribució
        }
        Pagador[] pagadors = new Pagador[numPagadors + 1]; //guardam a un array per poder crear tots els pagadors al final i no poder deixar la despesa a mitges
        pagadors[0] = new Pagador(contribucio, this.getPagadororiginal(), this, true); //la primera se guarda com true perque es l'original
        int valorsAssignats = 1; //valors assignats es quants de pagadors han pagat ja, en aquest cas, 1, perque el pagador original ha posat el seu troç
        importPendent = importPendent.subtract(contribucio); //actualitzam importPendent
        for (int i = 0; i < numPagadors; i++) {
            System.out.println("Pagador extra " + (i + 1));
            Usuari u = Usuari.obtenirUsuariConsola(s, em);
            if (distribucio != 2) { //si hem posat parts iguals per tots, no entram aqui
                System.out.println("Si vol seguir assignants imports individuals, introdueix 1");
                System.out.println("Si vol assignar imports iguals a tots els usuaris restants, introdueix 2");
                distribucio = s.nextInt();
            }
            contribucio = importPendent.divide(new BigDecimal(numPagadors - valorsAssignats), 2, RoundingMode.DOWN);
            // la contribucio = numPagadors - valors assignats, i la necessitam per quan volguem assignar parts iguals a tots els pagadors
            // si posam imports manuals, sobre-escrivim el valor cada vegada
            // si anam per parts iguals, numPagadors i valorsAssignats no canvien, per lo qual sempre tenim el mateix resultat
            // cada import manual que assignam fa que valors assignats pugi
            // exemple:
            // total: 5000
            // pagador original: 500 -> valorsAssignats: 1
            // pagadors apart de l'original: 4 (total: 5 pagadors)
            // queden 4500
            // assignam manualment 1000 al pagador 2
            // queden 3500 -> valorsAssignats: 2
            // parts iguals per els restants
            // queden 2 pagadors (3 i 4)
            // part igual per ells: 3500 / (4-2 = 2 
            if (distribucio != 2) { //si esteim posant valors manuals
                valorsAssignats += 1; //sumam valors assignats (per que la part restant seguesqui correcta)
                System.out.println("Pendent per pagar: " + importPendent);
                System.out.println("Quin es l'import que paga " + u.getFullName() + "?");
                contribucio = new BigDecimal(s.nextFloat());
                importPendent = importPendent.subtract(contribucio); //actualitzam import pendent
            }
            pagadors[i + 1] = new Pagador(contribucio, u, this, false);
        }
        PagadorDAO pDAO = new PagadorDAO(em);
        for (Pagador pagador : pagadors) {
            pDAO.create(pagador); //recorresc tot l'array i afegesc tots els pagadors
        }
        this.actualitzarImport(em);
    }

    public void mostrarPart(Usuari u, boolean nomesPendents) {
        List<Pagador> l = this.getPagadorList();
        Object pagadors[] = l.toArray(); //ho convertesc a un array
        for (Object pagador : pagadors) {
            Pagador p = (Pagador) pagador;
            if (p.getUsuari().getCorreu().equals(u.getCorreu())) {
                System.out.println(this);
                if (nomesPendents == true) {
                    if (!p.haPagat()) {
                        System.out.println("La teva part és: " + p.getContribucio());
                    }
                } else {
                    System.out.print("La teva part és: " + p.getContribucio());
                    if (p.haPagat()) {
                        System.out.println("(Pagada)");
                    } else {
                        System.out.println("(No Pagada)");
                    }
                }
            }
        }
    }

    public static void marcarPagament(Scanner s, EntityManager em) {
        s.nextLine(); //buidam el búfer de scanner
        Usuari u = Usuari.obtenirUsuariConsola(s, em);
        if (u.teDespesesPendents()) {
            u.mostrarDespeses(true);
            Despesa d = Despesa.obtenirDespesaConsola(s);
            d.marcarPagament(u, s, em);
        }
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
}

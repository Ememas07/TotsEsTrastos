/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tricountmarcmas;

import Usuaris.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Marc Mas
 */
public class DespesaDAO implements Serializable {
    
    private EntityManager em;
    
    DespesaDAO(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }
    
    DespesaDAO(EntityManager em) {
        this.em = em;
    }
    
    public void create(Despesa d, String correu, int idGrup) {
        // UsuariDAO uDAO = new UsuariDAO(em);
        // Usuari u = uDAO.obtenirUsuari(correu); //recuperam l'usuari amb el correu
        // GrupDAO gDAO = new GrupDAO(em);
        // Grup g = gDAO.obtenirGrup(idGrup); //recuperam el grup amb l'id
        Usuari u = em.find(Usuari.class, correu); //pues a re-escriure tot divendres 
        Grup g = em.find(Grup.class, idGrup);
        if (u != null && d != null) {
            d.setPagadororiginal(u);
            d.setIdgrup(g);
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(d);
            tx.commit(); //i feim commit
        }
    }
    
    public void edit(Despesa d) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.flush();
        tx.commit(); //i feim commit
    }
    
    public void actualitzarImport(Despesa d) {
        List<Pagador> l = d.getPagadorList();
        Object pagadors[] = l.toArray();
        BigDecimal totalPagat = new BigDecimal(0);
        for (int i = 0; i < pagadors.length; i++) {
            Pagador p = (Pagador) pagadors[i];
            if (p.haPagat()) {
                totalPagat = totalPagat.add(p.getContribucio());
            }
        }
        d.setImportpagat(totalPagat);
        this.edit(d);
    }
    
    public EntityManager getEM() {
        return this.em;
    }
}

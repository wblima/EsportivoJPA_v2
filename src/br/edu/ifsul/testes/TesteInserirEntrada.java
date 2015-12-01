/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Entrada;
import br.edu.ifsul.modelo.Fornecedor;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author William
 */
public class TesteInserirEntrada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("EsportivoPC2PU");
        EntityManager em = emf.createEntityManager();
        Fornecedor e = em.find(Fornecedor.class, 2);
        Entrada c = new Entrada();
        c.setData(Calendar.getInstance());
        c.setFornecedor(e);
        c.setValor(50.0);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}

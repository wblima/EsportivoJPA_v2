/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Conta;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author William
 */
public class TesteInserirConta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("EsportivoPC2PU");
        EntityManager em = emf.createEntityManager();
        Conta obj = new Conta();
        obj.setData(Calendar.getInstance());
        obj.setDataPgmto(Calendar.getInstance());
        obj.setStatus('P');
        obj.setValor(200.00);
        obj.setValorPago(200.00);
        obj.setCliente(em.find(Cliente.class, 1));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}

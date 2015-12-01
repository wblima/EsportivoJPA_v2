/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;



import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Conta;
import br.edu.ifsul.modelo.Horario;
import br.edu.ifsul.modelo.Recurso;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author William
 */
public class TesteInserirHorario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("EsportivoPC2PU");
        EntityManager em = emf.createEntityManager();
        Horario obj = new Horario();
        //obj.setInicio(Date.from(Instant.EPOCH));
        //obj.setFim(Date.from(Instant.EPOCH));
        obj.setStatus("Ocupado");
        obj.setCliente(em.find(Cliente.class, 1));
        obj.setConta(em.find(Conta.class, 1));
        obj.setRecurso(em.find(Recurso.class, 1));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}

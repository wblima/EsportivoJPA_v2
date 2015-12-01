/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Cliente;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author William
 */
public class TesteInserirCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("EsportivoPC2PU");
        EntityManager em = emf.createEntityManager();
        Cliente c = new Cliente();
        c.setNome("Pedro");
        c.setCpf("11111111111112");
        c.setDataCadastro(Calendar.getInstance());
        c.setEndereco("Rua F");
        c.setLogin("p1234");
        c.setSenha("123");
        c.setTelefone("3333-0908");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Fornecedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author William
 */
public class TesteInserirFornecedor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("EsportivoPC2PU");
        EntityManager em = emf.createEntityManager();
        Fornecedor c = new Fornecedor();
        c.setNome("Coca-Cola");
        c.setCnpj("27.143.472/0001-50");
        c.setEndereco("Rua A");
        c.setTelefone("3313-0101");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}

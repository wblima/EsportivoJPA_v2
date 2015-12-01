/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Entrada;
import br.edu.ifsul.modelo.EntradaItens;
import br.edu.ifsul.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author William
 */
public class TesteInserirEntradaItens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("EsportivoPC2PU");
        EntityManager em = emf.createEntityManager();
        EntradaItens obj = new EntradaItens();
        obj.setQuatidade(10);
        obj.setValorTotal(20.00);
        obj.setValorUnitario(2.00);
        obj.setEntrada(em.find(Entrada.class, 2));
        obj.setProduto(em.find(Produto.class, 1));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}

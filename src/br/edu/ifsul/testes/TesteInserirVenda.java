/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;



import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Conta;
import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Venda;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author William
 */
public class TesteInserirVenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("EsportivoPC2PU");
        EntityManager em = emf.createEntityManager();
        Venda obj = new Venda();
        obj.setData(Calendar.getInstance());
        obj.setValor(200.0);
        obj.setCliente(em.find(Cliente.class, 1));
        obj.setConta(em.find(Conta.class, 1));
        obj.setFuncionario(em.find(Funcionario.class, 3));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}

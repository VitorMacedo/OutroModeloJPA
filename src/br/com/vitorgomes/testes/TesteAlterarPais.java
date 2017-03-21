/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgomes.testes;

import br.com.vitorgomes.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vitor
 */
public class TesteAlterarPais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OutroModeloPU");
        EntityManager em = emf.createEntityManager();
        //alterando no banco
        Pais p = em.find(Pais.class, 2); //encontrar registro pelo id
        p.setIso("ARG");
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}

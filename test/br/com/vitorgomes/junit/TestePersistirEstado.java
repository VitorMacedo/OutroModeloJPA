/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgomes.junit;

import br.com.vitorgomes.jpa.EntityManagerUtil;
import br.com.vitorgomes.modelo.Estado;
import br.com.vitorgomes.modelo.Pais;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vitor
 */
public class TestePersistirEstado {
    EntityManager em;
    
    public TestePersistirEstado() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste() {
        boolean exception = false;
        try{
            Estado e = new Estado();
            e.setNome("Pará");
            e.setUf("PA");
            e.setPais(em.find(Pais.class, 1));
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
        }catch(Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

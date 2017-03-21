/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgomes.junit;

import br.com.vitorgomes.jpa.EntityManagerUtil;
import br.com.vitorgomes.modelo.Estado;
import br.com.vitorgomes.modelo.Pais;
import br.com.vitorgomes.modelo.PessoaFisica;
import java.util.Calendar;
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
public class TestePersistirPessoaFisica {
    EntityManager em;
    
    public TestePersistirPessoaFisica() {
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
            PessoaFisica pf = new PessoaFisica();
            pf.setCpf("185.195.260-80");
            pf.setEmail("mateus@gmail.com");
            pf.setNascimento(Calendar.getInstance());
            pf.setNome("Mateus Jorge");
            pf.setNomeUsuario("mateusjorge");
            pf.setRg("452635587");
            pf.setSenha("usuario");
            pf.setTelefone("(21)3258455");
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
        }catch(Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

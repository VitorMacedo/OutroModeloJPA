/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgomes.junit;

import br.com.vitorgomes.jpa.EntityManagerUtil;
import br.com.vitorgomes.modelo.Endereco;
import br.com.vitorgomes.modelo.Estado;
import br.com.vitorgomes.modelo.Pais;
import br.com.vitorgomes.modelo.PessoaFisica;
import br.com.vitorgomes.modelo.TipoEndereco;
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
public class TestePersistirEndereco {
    EntityManager em;
    
    public TestePersistirEndereco() {
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
            PessoaFisica pf = em.find(PessoaFisica.class, 3); // carregando pessoafisica existente no banco de dados
            Endereco e = new Endereco();
            e.setBairro("Centro");
            e.setCep("96458.654");
            e.setEndereco("Rua XXX");
            e.setComplemento("AP X");
            e.setNickname("Casa");
            e.setNumero("1024");
            e.setReferencia("Perto do Mercado");
            e.setTipoEndereco(em.find(TipoEndereco.class, 3));
            pf.adicionarEndereco(e);
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

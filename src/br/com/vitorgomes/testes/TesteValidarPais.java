/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgomes.testes;

import br.com.vitorgomes.jpa.EntityManagerUtil;
import br.com.vitorgomes.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Vitor
 */
public class TesteValidarPais {
    private static Object Validador;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManager em = EntityManagerUtil.getEntityManager();
        Pais p = new Pais();
        p.setNome("Chile");
        p.setIso("CHI");
        em.getTransaction().begin();
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validador.validate(p);
        if(erros.size() >0) {
            for(ConstraintViolation<Pais> erro : erros) {
                System.out.println("Erro: " + erro.getMessage());
            }
        }else {
            em.persist(p);
        }
        em.getTransaction().commit();
        em.close();
        
    }
    
}

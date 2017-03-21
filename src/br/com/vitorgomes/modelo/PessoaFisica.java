/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgomes.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Vitor
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {
    @Length(max = 10, message = "O RG não pode ter mais de [max] caracteres")
    @NotBlank(message = "O RG deve ser informado")
    @NotNull(message = "O RG não pode ser nulo")
    @Column(name = "RG", nullable = false, length = 10)
    private String rg;
    @Length(max = 14, message = "O CPF não pode ter mais de [max] caracteres")
    @NotBlank(message = "O CPF deve ser informado")
    @NotNull(message = "O CPF não pode ser nulo")
    @Column(name = "CPF", nullable = false, length = 14)
    @CPF(message = "O CPF deve ser válido")
    private String cpf;
    @NotNull(message = "O Nascimento não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    @Length(max = 20, message = "O nome de usuário não pode ter mais de [max] caracteres")
    @NotBlank(message = "O nome de usuário deve ser informado")
    @NotNull(message = "O nome de usuário não pode ser nulo")
    @Column(name = "nome_usuario", nullable = false, length = 20, unique = true)
    private String nomeUsuario;
    @Length(max = 10, message = "A senha não pode ter mais de [max] caracteres")
    @NotBlank(message = "A senha deve ser informado")
    @NotNull(message = "A senha não pode ser nulo")
    @Column(name = "senha", nullable = false, length = 10)
    private String senha;

    public PessoaFisica() {
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nascimento
     */
    public Calendar getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}

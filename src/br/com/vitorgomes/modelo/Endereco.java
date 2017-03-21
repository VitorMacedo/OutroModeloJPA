/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorgomes.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vitor
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_endereco", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 20, message = "O apelido não pode ter mais de [max] caracteres")
    @NotBlank(message = "O apelido deve ser informado")
    @NotNull(message = "O apelido não pode ser nulo")
    @Column(name = "nickname", nullable = false, length = 20)
    private String nickname;
    @Length(max = 50, message = "O endereco não pode ter mais de [max] caracteres")
    @NotBlank(message = "O endereco deve ser informado")
    @NotNull(message = "O endereco não pode ser nulo")
    @Column(name = "endereco", nullable = false, length = 50)
    private String endereco;
    @Length(max = 10, message = "O numero não pode ter mais de [max] caracteres")
    @NotBlank(message = "O numero deve ser informado")
    @NotNull(message = "O numero não pode ser nulo")
    @Column(name = "numero", nullable = false, length = 10)
    private String numero;
    @Length(max = 50, message = "O complemento não pode ter mais de [max] caracteres")
    @NotBlank(message = "O complemento deve ser informado")
    @NotNull(message = "O complemento não pode ser nulo")
    @Column(name = "complemento", length = 50)
    private String complemento;
    @Length(max = 9, message = "O cep não pode ter mais de [max] caracteres")
    @NotBlank(message = "O cep deve ser informado")
    @NotNull(message = "O cep não pode ser nulo")
    @Column(name = "cep", nullable = false, length = 9)
    private String cep;
    @Length(max = 40, message = "O bairro não pode ter mais de [max] caracteres")
    @NotBlank(message = "O bairro deve ser informado")
    @NotNull(message = "O bairro não pode ser nulo")
    @Column(name = "bairro", nullable = false, length = 40)
    private String bairro;
    @Length(max = 30, message = "O referencia não pode ter mais de [max] caracteres")
    @NotBlank(message = "A referencia deve ser informado")
    @NotNull(message = "O referencia não pode ser nulo")
    @Column(name = "referencia", nullable = false, length = 30)
    private String referencia;
    @NotNull(message = "A pessoa não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
    @org.hibernate.annotations.ForeignKey(name = "fk_pessoa_id")
    private Pessoa pessoa;
    @NotNull(message = "O tipo de endereço não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "tipo_endereco", referencedColumnName = "id", nullable = false)
    @org.hibernate.annotations.ForeignKey(name = "fk_tipo_endereco_id")
    private TipoEndereco tipoEndereco;

    public Endereco() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the tipoEndereco
     */
    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    /**
     * @param tipoEndereco the tipoEndereco to set
     */
    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
    
    
    
}

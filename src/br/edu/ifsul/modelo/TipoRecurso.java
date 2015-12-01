/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author William
 */
@Entity
@Table(name = "tipoRecurso")
public class TipoRecurso implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_tipoRecurso", sequenceName = "gen_tipoRecurso_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_tipoRecurso",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(min = 2, max = 50, message = "O nome deve ter entre {min} e {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado")
    @Column(name = "nome",length = 50, nullable = false,unique = true)
    private String nome;

    public TipoRecurso() {
    }

    public TipoRecurso(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.getId());
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
        final TipoRecurso other = (TipoRecurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
    
    
    
    
}

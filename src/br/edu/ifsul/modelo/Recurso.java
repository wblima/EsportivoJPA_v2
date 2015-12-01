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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author William
 */
@Entity
@Table(name = "recurso" )
public class Recurso implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50,message = "O nome não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O nome deve ser informado")
    @Column(name = "nome",length = 50,nullable = false)
    private String nome;
    @Length(max = 100,message = "A localização não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "A localização deve ser informada")
    @Column(name = "localizacao",length = 50,nullable = false)
    private String localizacao;
    @NotNull(message = "O tipo de recurso deve ser informado")
    @ManyToOne
    @JoinColumn(name = "tipoRecurso", referencedColumnName = "id", nullable = false)
    private TipoRecurso tipoRecurso;

    public Recurso() {
    }

    public Recurso(Integer id, String nome, String localizacao, TipoRecurso tipoRecurso) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tipoRecurso = tipoRecurso;
    }

    

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}

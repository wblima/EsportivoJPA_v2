/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Date;
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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author William
 */
@Entity
@Table(name = "horario")
public class Horario implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_horario", sequenceName = "gen_horario_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_horario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 5,message = "O inicio não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O inicio deve ser informado")
    @Column(name = "inicio",length = 5,nullable = false)
    private String inicio;
    @Length(max = 5,message = "O fim não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "O fim deve ser informado")
    @Column(name = "fim",length = 5,nullable = false)
    private String fim;
    @Column(name = "status",length = 20,nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = true)
    private Recurso recurso;
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = true)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "conta", referencedColumnName = "id", nullable = true)
    private Conta conta;

    public Horario() {
    }

    public Horario(Integer id, String inicio, String fim, String status, Recurso recurso, Cliente cliente, Conta conta) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.status = status;
        this.recurso = recurso;
        this.cliente = cliente;
        this.conta = conta;
    }

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Horario other = (Horario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }
    
    
    
}

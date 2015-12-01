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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author William
 */
@Entity
@Table(name = "funcionario")
public class Funcionario extends Usuario implements Serializable{
    @Length(max = 5,message = "A hora de entrada não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "A hora de entrada deve ser informada")
    @Column(name = "horaEntrada",length = 5,nullable = false)
    private String horaEntrada;
    @Length(max = 5,message = "A hora de saida não pode ultrapassar {max} caracteres")
    @NotEmpty(message = "A hora de saida deve ser informada")
    @Column(name = "horaSaida",length = 5,nullable = false)
    private String horaSaida;

    public Funcionario() {
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.horaEntrada);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.horaEntrada, other.horaEntrada)) {
            return false;
        }
        return true;
    }
    
    

   

    
    
    
    
}

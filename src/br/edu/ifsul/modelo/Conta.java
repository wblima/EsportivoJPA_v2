/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author William
 */
@Entity
@Table(name = "conta")
public class Conta implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_conta", sequenceName = "gen_conta_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_conta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data",nullable = false)
    private Calendar data;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor;
    @NotNull(message = "O valor pago deve ser informado")
    @Column(name = "valorPago", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valorPago;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPgmto",nullable = false)
    private Calendar dataPgmto;
    @Column(name = "status",length = 1,nullable = false)
    private Character status;
    @NotNull(message = "O cliente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    public Conta() {
    }

    public Conta(Integer id, Calendar data, Double valor, Double valorPago, Calendar dataPgmto, Character status, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.valorPago = valorPago;
        this.dataPgmto = dataPgmto;
        this.status = status;
        this.cliente = cliente;
    }

    

    

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Calendar getDataPgmto() {
        return dataPgmto;
    }

    public void setDataPgmto(Calendar dataPgmto) {
        this.dataPgmto = dataPgmto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }    
    
}

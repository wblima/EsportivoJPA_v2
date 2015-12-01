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

/**
 *
 * @author William
 */
@Entity
@Table(name = "EntradaItens")
public class EntradaItens implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_entradaItens", sequenceName = "gen_entradaItens_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_entradaItens", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A quatidade deve ser informada")
    @Column(name = "quantidade", nullable = false)
    private Integer quatidade;
    @NotNull(message = "O valor unitario deve ser informado")
    @Column(name = "valorUnitario", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valorUnitario;
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valorTotal", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valorTotal;
    @NotNull(message = "A entrada deve ser informada")
    @ManyToOne
    @JoinColumn(name = "entrada", referencedColumnName = "id", nullable = false)
    private Entrada entrada;
    @NotNull(message = "O produto deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
    private Produto produto;
     

    public EntradaItens() {
    }

    public EntradaItens(Integer id, Integer quatidade, Double valorUnitario, Double valorTotal, Entrada entrada, Produto produto) {
        this.id = id;
        this.quatidade = quatidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.entrada = entrada;
        this.produto = produto;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(Integer quatidade) {
        this.quatidade = quatidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final EntradaItens other = (EntradaItens) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
    
}

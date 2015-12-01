/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "entrada" )
public class Entrada implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_entrada", sequenceName = "seq_entrada_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_entrada",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data",nullable = false)
    private Calendar data;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor;
    @NotNull(message = "O fornecedor deve ser informado")
    @ManyToOne
    @JoinColumn(name = "fornecedor", referencedColumnName = "id", nullable = false)
    private Fornecedor fornecedor;
    @OneToMany(mappedBy = "entrada", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)    
    private List<EntradaItens> entradaItens = new ArrayList<>();

    public Entrada() {
    }

    public Entrada(Integer id, Calendar data, Double valor, Fornecedor fornecedor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    

    

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Entrada other = (Entrada) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<EntradaItens> getEntradaItens() {
        return entradaItens;
    }

    public void setEntradaItens(List<EntradaItens> entradaItens) {
        this.entradaItens = entradaItens;
    }

    public void adicionarEntradaItens(EntradaItens obj){
        obj.setEntrada(this);
        this.entradaItens.add(obj);        
    }
    
    public void removerEntradaItens(int index){
        this.entradaItens.remove(index);        
    }
    
    public void removerTodos(){
        this.entradaItens.clear();
    }    
    
    
    
    
    
    
}

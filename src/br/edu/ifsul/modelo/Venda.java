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
@Table(name = "venda")
public class Venda implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_venda", sequenceName = "gen_venda_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_venda", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data",nullable = false)
    private Calendar data;
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor;
    @NotNull(message = "O funcionario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;
    @NotNull(message = "O cliente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;
    @NotNull(message = "A conta deve ser informada")
    @ManyToOne
    @JoinColumn(name = "conta", referencedColumnName = "id", nullable = false)
    private Conta conta;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)    
    private List<VendaItens> vendaItens = new ArrayList<>();

    public Venda() {
    }

    public Venda(Integer id, Calendar data, Double valor, Funcionario funcionario, Cliente cliente, Conta conta) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.conta = conta;
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
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    public List<VendaItens> getVendaItens() {
        return vendaItens;
    }

    public void setVendaItens(List<VendaItens> vendaItens) {
        this.vendaItens = vendaItens;
    }
    
    public void adicionarVendaItens(VendaItens obj){
        obj.setVenda(this);
        this.vendaItens.add(obj);        
    }
    
    public void removerVendaItens(int index){
        this.vendaItens.remove(index);        
    }
    
    public void removerTodos(){
        this.vendaItens.clear();
    }    
    
    
    
}

package com.mycompany.dscproject.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author euluc
 */
@Entity
@NamedQueries(
        {
            @NamedQuery(
                    name = "Categoria.PorLoja",
                    query = "SELECT c FROM NotaFiscal c WHERE c.loja.nome LIKE :loja ORDER BY c.id"
            )
        }
)
public class NotaFiscal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notaFiscal", fetch = FetchType.EAGER)
    private List<Item> itens;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo")
    private Usuario donoDaNota;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "codigo_loja", referencedColumnName = "codigo")
    private Loja loja;
    
    @Column(name = "chaveDeAcesso", nullable = false)
    private String chaveDeAcesso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataEmissao", nullable = false)
    private Date dataEmissao;

    @Column(name = "valor", nullable = false)
    private Double valor;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item i) {
        if (itens == null) { itens = new ArrayList<>(); }
        
        itens.add(i);
        i.setNotaFiscal(this);
    }
    
    public boolean removerItem(Item i) {
        return itens.remove(i);
    }
    
    public Usuario getDonoDaNota() {
        return donoDaNota;
    }

    public void setDonoDaNota(Usuario donoDaNota) {
        this.donoDaNota = donoDaNota;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getChaveDeAcesso() {
        return chaveDeAcesso;
    }

    public void setChaveDeAcesso(String chaveDeAcesso) {
        this.chaveDeAcesso = chaveDeAcesso;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof NotaFiscal)) { return false; }
        NotaFiscal other = (NotaFiscal) object;
        return !((this.codigo == null && other.codigo != null) ||
                  (this.codigo != null && !this.codigo.equals(other.codigo)));
    }

    @Override
    public String toString() {
        return "com.mycompany.dscproject.model.NotaFiscal[ id=" + codigo + " ]";
    }
}

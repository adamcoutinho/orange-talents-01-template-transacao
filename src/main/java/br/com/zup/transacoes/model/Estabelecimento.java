package br.com.zup.transacoes.model;

import br.com.zup.transacoes.domain.EstabelecimentoMessage;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estabelecimento")
public class Estabelecimento {


    @Deprecated
    public Estabelecimento() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "sequence_estabelecimento")
    @SequenceGenerator(name = "sequence_estabelecimento",sequenceName = "sq_estabelecimento",allocationSize = 1)
    private Long id;

    private String nome;

    private String cidade;

    private String endereco;

    @OneToOne(mappedBy = "estabelecimento")
    private Transacao transacao;

    public Estabelecimento(EstabelecimentoMessage estabelecimento) {
        this.nome=estabelecimento.getNome();
        this.endereco=estabelecimento.getEndereco();
        this.cidade =estabelecimento.getCidade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}

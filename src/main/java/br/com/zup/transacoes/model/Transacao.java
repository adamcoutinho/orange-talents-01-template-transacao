package br.com.zup.transacoes.model;

import br.com.zup.transacoes.domain.TransacaoMessage;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Deprecated
    public Transacao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "sequence_transacao")
    @SequenceGenerator(name = "sequence_transacao",sequenceName = "sq_transacao",allocationSize = 1)
    private Long id;

    @NotBlank
    private String uuid;

    @NotNull
    private BigDecimal valor;

    @OneToOne(cascade = CascadeType.PERSIST)
    @NotNull
    private Estabelecimento estabelecimento;

    @OneToOne(cascade = CascadeType.PERSIST)
    @NotNull
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public Transacao(TransacaoMessage transacaoMessage) {
        this.uuid = transacaoMessage.getId();
        this.estabelecimento  = new Estabelecimento(transacaoMessage.getEstabelecimento());
        this.cartao = new Cartao(transacaoMessage.getCartao().getId(),transacaoMessage.getCartao().getEmail());
        this.efetivadaEm  = transacaoMessage.getEfetivadaEm();
        this.valor=transacaoMessage.getValor();
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

}

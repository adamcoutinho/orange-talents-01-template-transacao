package br.com.zup.transacoes.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMessage {


        private String id;


        private BigDecimal valor;


        private EstabelecimentoMessage estabelecimento;


        private CartaoMessage cartao;


        private LocalDateTime efetivadaEm;

        @Deprecated
        public TransacaoMessage() {
        }

        public TransacaoMessage(String id, BigDecimal valor, EstabelecimentoMessage estabelecimento, CartaoMessage cartao, LocalDateTime efetivadaEm) {
                this.id = id;
                this.valor = valor;
                this.estabelecimento = estabelecimento;
                this.cartao = cartao;
                this.efetivadaEm = efetivadaEm;
        }


        public String getId() {
                return id;
        }

        public BigDecimal getValor() {
                return valor;
        }

        public EstabelecimentoMessage getEstabelecimento() {
                return estabelecimento;
        }

        public CartaoMessage getCartao() {
                return cartao;
        }

        public LocalDateTime getEfetivadaEm() {
                return efetivadaEm;
        }

        @Override
        public String toString() {
                return "Transactions{" +
                        "id='" + id + '\'' +
                        ", valor=" + valor +
                        ", estabelecimento=" + estabelecimento.toString() +
                        ", cartao=" + cartao.toString() +
                        ", efetivadaEm=" + efetivadaEm +
                        '}';
        }
}

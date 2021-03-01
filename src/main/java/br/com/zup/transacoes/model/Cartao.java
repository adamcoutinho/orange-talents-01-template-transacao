package br.com.zup.transacoes.model;

import br.com.zup.transacoes.domain.CartaoMessage;

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

@Entity
@Table(name = "cartao")
public class Cartao {
    @Deprecated
    public Cartao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "sequence_cartao")
    @SequenceGenerator(name = "sequence_cartao",sequenceName = "sq_cartao",allocationSize = 1)
    private Long id;
    @NotBlank
    private String uuid;
    @NotBlank
    private String email;

    @OneToOne(mappedBy = "cartao")
    @NotNull
    private Transacao transacao;

    public Cartao(@NotBlank String uuid, @NotBlank String email) {
        this.uuid = uuid;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }
}

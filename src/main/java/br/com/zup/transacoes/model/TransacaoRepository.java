package br.com.zup.transacoes.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {


    List<Transacao> findTop10ByCartaoUuid(String identificadorCartao);

}

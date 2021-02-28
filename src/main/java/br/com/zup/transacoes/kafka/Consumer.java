package br.com.zup.transacoes.kafka;

import br.com.zup.transacoes.domain.TransacaoMessage;
import br.com.zup.transacoes.model.Transacao;
import br.com.zup.transacoes.model.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Consumer {


    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(TransacaoMessage transacaoMessage) {
        transacaoRepository.save(new Transacao(transacaoMessage));
    }

}
package br.com.zup.transacoes.endpoints;

import br.com.zup.transacoes.model.Transacao;
import br.com.zup.transacoes.model.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultar")
public class ConsultarEndPoint {

        @Autowired
        private TransacaoRepository transacaoRepository;

        @GetMapping("/{identificador-cartao}")
        public ResponseEntity<?> consultar(@PathVariable("identificador-cartao") String identificadorCartao) {

            List<Transacao> transacoes = transacaoRepository.findTop10ByCartaoUuid(identificadorCartao);

            if(transacoes.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe transações para este cartão.");
            }

            return ResponseEntity.status(HttpStatus.OK).body(transacoes);

        }

}

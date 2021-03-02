package br.com.zup.transacoes.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "cartao-conta-resource",url = "http://localhost:7777/" )
public interface CartoesFeign {

    @DeleteMapping("/api/cartaoes/{id?")
    public void delete(@PathVariable("id") Long id);

}

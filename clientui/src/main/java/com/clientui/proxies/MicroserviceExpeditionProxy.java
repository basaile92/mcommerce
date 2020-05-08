package com.clientui.proxies;

import com.clientui.beans.CommandeBean;
import com.clientui.beans.ExpeditionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-expeditions")
public interface MicroserviceExpeditionProxy {

    @PostMapping(value = "/microservice-commandes/commandes")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);

    @PostMapping(value = "/microservice-expeditions/expedition")
    ResponseEntity<ExpeditionBean> creerExpedition(@RequestBody ExpeditionBean expedition);

    @GetMapping(value = "/microservice-expeditions/expedition/{id}")
    ExpeditionBean recupererExpedition(@PathVariable int id);

    @PutMapping(value = "/microservice-expeditions/expedition")
    ResponseEntity<ExpeditionBean> mettreAJourExpedition(@RequestBody ExpeditionBean expedition);
}

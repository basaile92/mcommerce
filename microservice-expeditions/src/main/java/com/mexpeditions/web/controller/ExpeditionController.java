package com.mexpeditions.web.controller;

import com.mexpeditions.dao.ExpeditionDao;
import com.mexpeditions.model.Expedition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    @PostMapping(value = "/expedition")
    public ResponseEntity<Expedition> creerExpedition(@RequestBody Expedition expedition){
        expeditionDao.save(expedition);
        return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);
    }

    @GetMapping(value = "/expedition/{id}")
    public Expedition recupererExpedition(@PathVariable int id){
        return expeditionDao.getOne(id);
    }

    @PutMapping(value = "/expedition")
    public ResponseEntity<Expedition> mettreAJourExpedition(@RequestBody Expedition expedition){
        expeditionDao.delete(expedition);
        expeditionDao.save(expedition);
        return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);
    }

}

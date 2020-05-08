package com.mexpeditions.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Expedition {

    @Id
    @GeneratedValue
    private int id;

    @Id
    private int idCommande;

    private int etat;
}

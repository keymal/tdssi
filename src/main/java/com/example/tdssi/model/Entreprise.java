package com.example.tdssi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entreprise extends AbstractEntity implements Serializable {

    private String nom;
    private String raisonSociale;
    private String adresse;
    private String pays;
    private String courriel;

}

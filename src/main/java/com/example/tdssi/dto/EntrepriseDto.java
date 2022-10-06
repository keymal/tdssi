package com.example.tdssi.dto;

import com.example.tdssi.model.Entreprise;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Entreprise} entity
 */
@Data
public class EntrepriseDto implements Serializable {
    public String id;
    public String nom;
    public String raisonSociale;
    public String adresse;
    public String pays;
    public String courriel;
}

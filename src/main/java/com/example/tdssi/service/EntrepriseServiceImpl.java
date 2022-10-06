package com.example.tdssi.service;

import com.example.tdssi.model.Entreprise;
import com.example.tdssi.dto.EntrepriseDto;
import com.example.tdssi.repository.EntrepriseRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    private final ModelMapper modelMapper;

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        Entreprise entreprise = modelMapper.map(entrepriseDto, Entreprise.class);




        return modelMapper.map(entrepriseRepository.save(entreprise), EntrepriseDto.class);
    }

    @Override
    public EntrepriseDto get() {

        if (entrepriseRepository.findAll().isEmpty()) {
            return null;
        } else {
            return modelMapper.map(entrepriseRepository.findById(1).get(), EntrepriseDto.class);

        }
    }
}

package com.api.academiafinancialservices.services;

import com.api.academiafinancialservices.models.LivroCaixaModel;
import com.api.academiafinancialservices.repositories.LivroCaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LivroCaixaService {

    @Autowired
    LivroCaixaRepository livroCaixaRepository;

    @Transactional
    public LivroCaixaModel save(LivroCaixaModel livroCaixaModel) {
        return livroCaixaRepository.save(livroCaixaModel);
    }

    public List<LivroCaixaModel> findAll() {
        return livroCaixaRepository.findAll();
    }

    public Optional<LivroCaixaModel> findById(Integer id) {
        return livroCaixaRepository.findById(id);
    }

    @Transactional
    public void delete(LivroCaixaModel livroCaixaModel) {
        livroCaixaRepository.delete(livroCaixaModel);
    }
}

package com.restaurant_app.service;

import com.restaurant_app.model.FelPrincipal;
import com.restaurant_app.repository.MeniuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeniuService {

    private final MeniuRepository meniuRepository;

    public MeniuService(MeniuRepository meniuRepository) {
        this.meniuRepository = meniuRepository;
    }

    public List<FelPrincipal> getAll() {
        return meniuRepository.findAll();
    }

    public FelPrincipal add(FelPrincipal fel) {
        return meniuRepository.save(fel);
    }

    public void deleteById(Long id) {
        meniuRepository.deleteById(id);
    }

    public List<FelPrincipal> getFeluriCuPretMaiMareCa(double pretMinim) {
        return meniuRepository.findByPretGreaterThan(pretMinim);
    }
}

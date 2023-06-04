package com.programming.techue.springbootmongodbtutorial.service;

import com.programming.techue.springbootmongodbtutorial.model.Kopi;
import com.programming.techue.springbootmongodbtutorial.repository.KopiRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class KopiService {
    private final KopiRepo kopiRepository;

    public void addKopi(Kopi coffee) {
        kopiRepository.insert(coffee);
    }

    public void updateKopi(Kopi coffee) {
        Kopi savedKopi = kopiRepository.findById(coffee.getId()).orElseThrow(
                () -> new RuntimeException(String.format("Cannot Find coffee by %s", coffee.getId())));
        savedKopi.setKopiName(coffee.getKopiName());
        savedKopi.setKopiCategory(coffee.getKopiCategory());
        savedKopi.setKopiAmount(coffee.getKopiAmount());

        kopiRepository.save(coffee);
    }

    public List<Kopi> getAllKopi() {
        return kopiRepository.findAll();
    }

    public List<Kopi> getKopiByName(String name) {
        return kopiRepository.findByName(name);
    }

    public void deleteKopi(String id) {
        kopiRepository.deleteById(id);
    }
}
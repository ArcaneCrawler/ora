package com.math.epidemic.Services;

import com.math.epidemic.Entities.Virus;
import com.math.epidemic.Repositories.VirusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VirusService {

    private final VirusRepository virusRepository;
    @Autowired
    public VirusService(VirusRepository virusRepository) {
        this.virusRepository = virusRepository;
    }

    public void add(Virus virus) {
        virusRepository.save(virus);
    }

    public List<Virus> findAll() {
        return virusRepository.findAll();
    }
}

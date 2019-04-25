package com.math.epidemic.Services;

import com.math.epidemic.Entities.VirusType;
import com.math.epidemic.Repositories.VirusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VirusTypeService {

    private final VirusTypeRepository virusTypeRepository;

    @Autowired
    public VirusTypeService(VirusTypeRepository virusTypeRepository) {
        this.virusTypeRepository = virusTypeRepository;
    }

    public void add(VirusType virusType) {
        virusTypeRepository.save(virusType);
    }
}

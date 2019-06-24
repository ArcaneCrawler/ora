package com.math.epidemic.Services;

import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Repositories.LocacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacityService {

    private final LocacityRepository locacityRepository;

    @Autowired
    public LocacityService(LocacityRepository locacityRepository) {
        this.locacityRepository = locacityRepository;
    }

    public void add(Locacity locacity) {
        locacityRepository.save(locacity);
    }

    public void delete(Locacity locacity) {
        locacityRepository.delete(locacity);
    }

    public List<Locacity> findAll() {
        return locacityRepository.findAll();
    }
}

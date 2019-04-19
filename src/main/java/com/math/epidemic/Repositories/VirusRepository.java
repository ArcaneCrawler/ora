package com.math.epidemic.Repositories;

import com.math.epidemic.Entities.Virus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirusRepository extends JpaRepository<Virus, Long> {
}

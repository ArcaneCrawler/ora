package com.math.epidemic.Repositories;

import com.math.epidemic.Entities.Journal;
import com.math.epidemic.Entities.Locacity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}

package com.math.epidemic.Repositories;

import com.math.epidemic.Entities.Journal;
import com.math.epidemic.Entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
}

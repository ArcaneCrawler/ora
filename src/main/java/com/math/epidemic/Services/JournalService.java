package com.math.epidemic.Services;

import com.math.epidemic.Entities.Journal;
import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Repositories.JournalRepository;
import com.math.epidemic.Repositories.LocacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    @Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public void add(Journal journal) {
        journalRepository.save(journal);
    }

    public void delete(Journal journal) {
        journalRepository.delete(journal);
    }

    public List<Journal> findAll() {
        return journalRepository.findAll();
    }
}

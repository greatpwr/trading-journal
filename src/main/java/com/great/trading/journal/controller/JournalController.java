package com.great.trading.journal.controller;

import com.great.trading.journal.entity.AddJournalRequest;
import com.great.trading.journal.entity.Journal;
import com.great.trading.journal.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {
    Logger logger = LoggerFactory.getLogger(JournalController.class);

    private JournalRepository journalRepository;

    @Autowired
    public JournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Journal> findAllJournals() {
        logger.info ("in FindAllJournals");

        return journalRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addJournal (@RequestBody AddJournalRequest addJournalRequest) {
        Journal journal = new Journal();

        journal.setTitle(addJournalRequest.getTitle());
        journal.setBody(addJournalRequest.getBody());

        journalRepository.save(journal);
    }
}

package com.kuheli.Journal.App.controller;
import com.kuheli.Journal.App.entity.JournalEntry;
import com.kuheli.Journal.App.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping//("/abc")
    public List<JournalEntry> getAll()
    {
        return null;
    }

    @PostMapping//("/post")
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myID}")
    public JournalEntry getJournalEntryByID(@PathVariable Long myID)
    {
        return null;
    }

    @DeleteMapping("id/{myID}")
    public JournalEntry deleteJournalEntryByID(@PathVariable Long myID)
    {
        return null;
    }

    @PutMapping("id/{myID}")
    public JournalEntry updateJournalEntryByID(@PathVariable Long myID , @RequestBody JournalEntry myEntry)
    {
        return null;
    }
}

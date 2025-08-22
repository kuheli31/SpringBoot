package com.kuheli.Journal.App.controller;
import com.kuheli.Journal.App.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping//("/abc")
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping//("/post")
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myID}")
    public JournalEntry getJournalEntryByID(@PathVariable Long myID)
    {
        return journalEntries.get(myID);
    }

    @DeleteMapping("id/{myID}")
    public JournalEntry deleteJournalEntryByID(@PathVariable Long myID)
    {
        return journalEntries.remove(myID);
    }

    @PutMapping("id/{myID}")
    public JournalEntry updateJournalEntryByID(@PathVariable Long myID , @RequestBody JournalEntry myEntry)
    {
        myEntry.setId(myID);
        return journalEntries.put(myID, myEntry);
    }
}

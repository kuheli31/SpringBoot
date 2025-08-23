package com.kuheli.Journal.App.repository;
import com.kuheli.Journal.App.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry , String> {

}

package com.wet.dictionary.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wet.dictionary.model.Entry;
import com.wet.dictionary.service.EntryService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/fetch")
public class EntryController {

  private final EntryService service;

  public EntryController(EntryService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Entry>> fetchData() {
    List<Entry> data = service.fetchAllData();
    return ResponseEntity.ok(data);
  }

  @GetMapping("/sorted/{language}")
  public ResponseEntity<HashMap<String, List<Entry>>> fetchSortedData(@PathVariable(required = false) String language) {
    HashMap<String, List<Entry>> sortedData = service.fetchSortedData(language);
    System.out.println("OKAY");
    if (!sortedData.isEmpty()) {
      return ResponseEntity.ok(sortedData);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/search/{word}")
  public ResponseEntity<List<Entry>> fetchWord(@PathVariable String word) {
    List<Entry> data = service.fetchByWord(word);
    return ResponseEntity.ok(data);
  }

}

package com.wet.dictionary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wet.dictionary.model.Entry;
import com.wet.dictionary.util.CsvReader;
import com.wet.dictionary.util.WordExtractor;

@Service
public class EntryService {
  private static final String csv_path = EntryService.class.getResource("/data/filtered_words.csv").getFile();

  private List<Entry> dataList;
  // Hashmap should be <String, HashMap<String, String> where HashMap contains the
  // 3 languages waray, english, tagalog and the key should be the waray word

  public EntryService() {
    this.dataList = CsvReader.readCsv(csv_path, Entry.class);
  }

  public List<Entry> fetchAllData() {
    return dataList;
  }

  public HashMap<String, List<Entry>> fetchSortedData(String inputLanguage) {
    final String language = (inputLanguage.isEmpty() || inputLanguage == null) ? "waray" : inputLanguage.toLowerCase();
    HashMap<String, List<Entry>> sortedData = new HashMap<>();
    dataList.forEach((entry) -> {
      String letter = String.valueOf(getWord(entry, language).charAt(0)).toUpperCase();
      if (!sortedData.containsKey(letter)) {
        sortedData.put(letter, new ArrayList<>(){{
          add(entry);
        }});
      } else {
        sortedData.get(letter).add(entry);
      }
    });

    return sortedData;
  }

  public List<Entry> fetchByWord(String word) {
    List<Entry> matchedWords = new ArrayList<>();
    for (Entry entry : dataList) {
      List<String> translatedWords = WordExtractor.extractWords(entry);
      translatedWords.forEach((translatedWord) -> {
        System.out.println(translatedWord);
        if (translatedWord.contains(word)) {
          matchedWords.add(entry);
        }
      });
    }
    return matchedWords;
  }

  private String getWord(Entry entry, String language) {
    switch (language) {
      case "waray":
        return entry.getWaray();
      case "english":
        return entry.getEnglish();
      case "tagalog":
        return entry.getTagalog();
      default:
        return entry.getWaray();
    } 
  }
}

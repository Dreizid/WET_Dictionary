package com.wet.dictionary.util;

import com.wet.dictionary.model.Entry;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.List;

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insertEntries(List<Entry> entries) {
    String regex = "[ ,;/]+";
    Pattern pattern = Pattern.compile(regex);
    for (Entry entry : entries) {
      System.out.println(entry.getWaray());
      String[] translatedWords = {entry.getEnglish(), entry.getTagalog(), entry.getWaray()};
      for (String word : translatedWords) {
          System.out.println("Current word: " + word);
        if (!pattern.matcher(word).find()) {
          System.out.println("Inserting word: " + word);
          insertWord(word, entry);
          continue;
        } 
        String[] splitString = word.split(regex);
        for (String str : splitString) {
          System.out.println("Inserting str: " + str);
          insertWord(str, entry);
        }
        continue;
      } 
    }
  }

  public void insertWord(String word, Entry entry) {
    TrieNode current = root;
    String loweredWord = word.toLowerCase();
    
    for (char character: loweredWord.toCharArray()) {
      if (!current.containsKey(character)) {
        current.put(character, new TrieNode());
      }
      current = current.get(character);
    }

    current.addEntry(entry);
  }

  public List<Entry> query(String query) {
    List<Entry> results = new ArrayList<>();
    TrieNode current = root;
    String loweredQuery = query.toLowerCase();

    for (char character: loweredQuery.toCharArray()) {
      System.out.println(character);
      current = current.get(character);
    }

    collectWords(current, results);
    return results;
  }

  private void collectWords(TrieNode current, List<Entry> results) {
    if(current.hasEntries()) {
      results.addAll(current.getEntries());
    }

    current.children.forEach((key, node) -> {
      collectWords(current.get(key), results);
    });
  }

}

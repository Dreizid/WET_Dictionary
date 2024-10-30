package com.wet.dictionary.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.wet.dictionary.model.Entry;

public class TrieNode {
  public HashMap<Character, TrieNode> children;
  private List<Entry> entries;

  public TrieNode() {
    this.children = new HashMap<>();
    this.entries = new ArrayList<>();
  }

  public boolean containsKey(char key) {
    return children.containsKey(key);
  }

  public TrieNode get(char key) {
    return children.get(key);
  }

  public void put(char key, TrieNode node) {
    children.put(key, node);
  }

  public void addEntry(Entry entry) {
    entries.add(entry);
  }

  public List<Entry> getEntries() {
    return this.entries;
  }

  public boolean hasEntries() {
    return !entries.isEmpty();
  }
}

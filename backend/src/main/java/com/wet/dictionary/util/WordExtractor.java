package com.wet.dictionary.util;

import java.util.List;
import java.util.ArrayList;
import com.wet.dictionary.model.Entry;

public class WordExtractor {

  public static List<String> extractWords(Entry entry) {
    List<String> words = new ArrayList<>();
    words.add(entry.getTagalog());
    words.add(entry.getWaray());
    words.add(entry.getEnglish());
    return words;
  }
}

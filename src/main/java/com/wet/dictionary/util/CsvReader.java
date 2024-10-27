package com.wet.dictionary.util;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class CsvReader {

  public static <T> List<T> readCsv(String csv_path, Class<T> type) {
    try {
      List<T> entries = new CsvToBeanBuilder(new FileReader(csv_path)).withType(type).build().parse();
      return entries;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

}

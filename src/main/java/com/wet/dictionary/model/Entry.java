package com.wet.dictionary.model;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class Entry {

  @CsvBindByName(column = "Waray")
  private String waray;

  @CsvBindByName(column = "English")
  private String english;

  @CsvBindByName(column = "Tagalog")
  private String tagalog;

  public String getWaray() {
    return waray;
  }

  public void setWaray(String waray) {
    this.waray = waray;
  }

  public String getEnglish() {
    return english;
  }

  public void setEnglish(String english) {
    this.english = english;
  }

  public String getTagalog() {
    return tagalog;
  }

  public void setTagalog(String tagalog) {
    this.tagalog = tagalog;
  }
}

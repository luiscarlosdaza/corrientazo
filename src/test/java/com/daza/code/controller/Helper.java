package com.daza.code.controller;

import java.io.File;
import java.util.stream.Stream;

import static com.daza.code.util.Constant.OUTPUT_FOLDER;

public class Helper {

  public File getTestFileFromResources(String filename) {
    ClassLoader classLoader = getClass().getClassLoader();
    return new File(classLoader.getResource(filename).getFile());
  }

  public void createAndCleanOutputFolder() {
    File outputFolder = new File(OUTPUT_FOLDER);
    if (!outputFolder.exists()) {
      outputFolder.mkdir();
    }
    final File[] outputFiles = new File(OUTPUT_FOLDER).listFiles();
    Stream.of(outputFiles).forEach(file -> file.delete());
  }
}

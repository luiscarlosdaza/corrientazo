package com.daza.code.controller;

import java.io.File;

public class Helper {

  public File getTestFileFromResources(String filename) {
    ClassLoader classLoader = getClass().getClassLoader();
    return new File(classLoader.getResource(filename).getFile());
  }
}

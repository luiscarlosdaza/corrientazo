package com.daza.code.model;

public class Path {

  public Path(String path) {
    this.path = path;
  }

  private String path;

  @Override
  public String toString() {
    return "Path{" +
        "path='" + path + '\'' +
        '}';
  }
}

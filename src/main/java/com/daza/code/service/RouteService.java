package com.daza.code.service;

import com.daza.code.model.Path;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RouteService {

  public List<Path> getDronPath(File dronPath) {
    List<Path> paths = new ArrayList<>();
    try (InputStream is = new FileInputStream(dronPath)) {
      paths = getPathsFromInputStream(is);
    } catch (IOException e) {
      System.out.println("There was an error reading file: " + dronPath.getName());
      e.printStackTrace();
    }
    return paths;
  }

  public List<Path> getDronPath(String filename) {
    List<Path> paths = new ArrayList<>();
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    try (InputStream is = classloader.getResourceAsStream(filename)) {
      paths = getPathsFromInputStream(is);
    } catch (IOException e) {
      System.out.println("There was an error reading the file: " + filename);
      e.printStackTrace();
    }

    return paths;
  }

  private List<Path> getPathsFromInputStream(InputStream inputStream) throws IOException {
    List<Path> paths = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        paths.add(new Path(line));
      }
    }
    return paths;
  }
}

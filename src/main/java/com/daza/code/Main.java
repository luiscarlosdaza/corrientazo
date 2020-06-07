package com.daza.code;

import com.daza.code.model.Path;
import com.daza.code.service.RouteService;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

  private static final String INPUT_FOLDER = "in";
  private static final String OUTPUT_FOLDER = "out";
  private static RouteService routeService = new RouteService();

  public static void main(String[] args) {

    //Read files from resources
    File[] inputFiles = getInputFiles(INPUT_FOLDER);

    //Map file info into objects
    Map<File, List<Path>> inputFilesMap = new HashMap<>();
    for (File dronPathFile : inputFiles) {
      List<Path> paths = routeService.getDronPath(dronPathFile);



      inputFilesMap.put(dronPathFile, paths);
    }

    //Process file
    Iterator iterator = inputFilesMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      File dronPathFile = (File) entry.getKey();
      List<Path> paths = (List<Path>) entry.getValue();
      System.out.println(dronPathFile.getName());
      paths.stream().forEach(a -> System.out.printf("%s, ", a));
      System.out.println();

      iterator.remove(); // avoids a ConcurrentModificationException

    }


    //Generate new file
  }

  private static File[] getInputFiles(String folder) {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    URL url = loader.getResource(folder);
    return new File(url.getPath()).listFiles();
  }
}

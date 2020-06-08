package com.daza.code;

import com.daza.code.controller.DroneController;

import java.io.File;
import java.util.stream.Stream;

import static com.daza.code.util.Constant.*;

public class Main {

  public static void main(String[] args) {
    //Add folder or delete output files
    createAndCleanOutputFolder();

    //Read input files
    File[] inputFiles = readInputFiles();
    if (inputFiles == null) return;

    DroneController droneController = new DroneController();
    Stream.of(inputFiles).forEach(file -> droneController.executeDrones(file));
    System.out.printf("Files have been successfully generated! Please, check the %s folder.", OUTPUT_FOLDER);
  }

  private static File[] readInputFiles() {
    File[] inputFiles = new File(INPUT_FOLDER).listFiles(
        (dir, name) -> name.toLowerCase().startsWith(INPUT_FILE) && name.toLowerCase().endsWith(TXT)
    );
    if (inputFiles == null || inputFiles.length == 0) {
      System.out.printf("There are no %s files to process in the %s root folder", TXT, INPUT_FOLDER);
      return null;
    }
    return inputFiles;
  }

  private static void createAndCleanOutputFolder() {
    File outputFolder = new File(OUTPUT_FOLDER);
    if (!outputFolder.exists()) {
      outputFolder.mkdir();
    }
    final File[] outputFiles = new File(OUTPUT_FOLDER).listFiles();
    Stream.of(outputFiles).forEach(file -> file.delete());
  }
}

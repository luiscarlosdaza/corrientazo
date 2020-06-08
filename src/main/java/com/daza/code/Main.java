package com.daza.code;

import com.daza.code.controller.DroneController;

import java.io.File;
import java.util.stream.Stream;

import static com.daza.code.util.Constant.*;

public class Main {

  public static void main(String[] args) {
    //Delete output files
    final File[] outputFiles = new File(OUTPUT_FOLDER).listFiles();
    Stream.of(outputFiles).forEach(file -> file.delete());

    //Read input files
    File[] inputFiles = new File(INPUT_FOLDER).listFiles(
        (dir, name) -> name.toLowerCase().startsWith(INPUT_FILE) && name.toLowerCase().endsWith(TXT)
    );
    DroneController droneController = new DroneController();
    Stream.of(inputFiles).forEach(file -> droneController.executeDrones(file));
    System.out.printf("Files have been successfully generated! Please, check the %s folder.", OUTPUT_FOLDER);
  }
}

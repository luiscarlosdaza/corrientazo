package com.daza.code.service;

import com.daza.code.exception.DroneException;
import com.daza.code.model.Drone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.daza.code.util.Constant.*;

public class ReaderAndWriterService {

  public List<String> getPathsFromInputFile(File dronePath) {
    List<String> paths = new ArrayList<>();
    try (InputStream is = new FileInputStream(dronePath);
         BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
      String line;
      while ((line = br.readLine()) != null) {
        paths.add(line);
      }
    } catch (IOException e) {
      StringBuilder message = new StringBuilder();
      message.append("There was an error reading file: ");
      message.append(dronePath.getName());
      throw new DroneException(message.toString());
    }
    return paths;
  }

  public void generateDroneOutputFile(Drone drone, List<String> outputDroneFile) {
    String outputFileName = getOutputFileName(drone.getName());
    try (FileWriter fw = new FileWriter(outputFileName);
         PrintWriter printWriter = new PrintWriter(fw)) {
      printWriter.printf("== Reporte de entregas == %n%n");
      outputDroneFile.stream().forEach(a -> printWriter.printf("%s %n%n", a));
      printWriter.flush();
    } catch (IOException e) {
      throw new DroneException("There was an error writing file: " + outputFileName);
    }
  }

  private String getOutputFileName(String filename) {
    StringBuilder sb = new StringBuilder();
    sb.append(OUTPUT_FOLDER);
    sb.append("/");
    sb.append(OUTPUT_FILE);
    sb.append(filename.substring(INPUT_FILE.length()));
    return sb.toString();
  }
}

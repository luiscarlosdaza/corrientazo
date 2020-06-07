package com.daza.code;

import com.daza.code.model.Drone;
import com.daza.code.service.DroneService;
import com.daza.code.service.ValidateService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.daza.code.util.Constant.*;

public class Main {

  private DroneService droneService;
  private ValidateService validateService;

  public Main(DroneService droneService, ValidateService validateService) {
    this.droneService = droneService;
    this.validateService = validateService;
  }

  public static void main(String[] args) {
    Main main = new Main(new DroneService(), new ValidateService());
    main.executeDrones();
  }

  private void executeDrones() {
    File[] inputFiles = new File(INPUT_FOLDER).listFiles(
        (dir, name) -> name.toLowerCase().startsWith(INPUT_FILE) && name.toLowerCase().endsWith(TXT)
    );
    for (File inputFile : inputFiles) {
      Drone drone = new Drone(inputFile.getName());
      List<String> paths = droneService.getPathsFromInputFile(inputFile);
      validateService.validateAmountOfLunches(drone, paths);
      //Process file
      List<String> outputPaths = new ArrayList<>();
      for (String path : paths) {
        for (Character droneAction : path.toCharArray()) {
          drone.move(droneAction);
        }
        validateService.validateBlocks(drone);
        outputPaths.add(drone.toString());
      }
      droneService.generateDroneOutputFile(drone, outputPaths);
    }
  }
}

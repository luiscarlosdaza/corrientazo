package com.daza.code.controller;

import com.daza.code.model.Drone;
import com.daza.code.service.DroneService;
import com.daza.code.service.ReaderAndWriterService;

import java.io.File;
import java.util.List;

public class DroneController {

  private DroneService droneService;
  private ReaderAndWriterService readerAndWriterService;

  public DroneController() {
    this.droneService = new DroneService();
    this.readerAndWriterService = new ReaderAndWriterService();
  }

  public void executeDrones(File inputFile) {
    List<String> paths = readerAndWriterService.getPathsFromInputFile(inputFile);
    Drone drone = new Drone(inputFile.getName());
    List<String> outputPaths = droneService.moveDrones(drone, paths);
    readerAndWriterService.generateDroneOutputFile(drone, outputPaths);
  }
}

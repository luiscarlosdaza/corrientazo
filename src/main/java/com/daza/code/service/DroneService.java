package com.daza.code.service;

import com.daza.code.model.Drone;
import com.daza.code.model.DroneAction;

import java.util.ArrayList;
import java.util.List;

public class DroneService {

  private ValidateService validateService;

  public DroneService() {
    validateService = new ValidateService();
  }

  public List<String> moveDrones(Drone drone, List<String> paths) {
    validateService.validateAmountOfLunches(drone, paths);
    List<String> outputPaths = new ArrayList<>();
    for (String path : paths) {
      for (Character droneAction : path.toCharArray()) {
        DroneAction actionEnum = DroneAction.getAction(droneAction);
        validateService.validateAction(actionEnum, drone, droneAction);
        drone.move(actionEnum);
      }
      validateService.isWithinAllowedBlocks(drone);
      outputPaths.add(drone.toString());
    }
    return outputPaths;
  }
}

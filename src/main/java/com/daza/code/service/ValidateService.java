package com.daza.code.service;

import com.daza.code.exception.DroneException;
import com.daza.code.model.Drone;
import com.daza.code.model.DroneAction;

import java.util.List;

import static com.daza.code.util.Constant.MAX_AMOUNT_OF_BLOCKS;
import static com.daza.code.util.Constant.MAX_AMOUNT_OF_LUNCHES;

public class ValidateService {

  public void validateAmountOfLunches(Drone drone, List<String> paths) {
    if (paths.size() > MAX_AMOUNT_OF_LUNCHES) {
      StringBuilder message = new StringBuilder();
      message.append("The drone ");
      message.append(drone.getName());
      message.append(" is carrying more than ");
      message.append(MAX_AMOUNT_OF_LUNCHES);
      message.append(" lunches");
      throw new DroneException(message.toString());
    }
  }

  public void isWithinAllowedBlocks(Drone drone) {
    boolean isWithinAllowedBlocks = drone.getX() >= MAX_AMOUNT_OF_BLOCKS * -1
        && drone.getX() <= MAX_AMOUNT_OF_BLOCKS
        && drone.getY() >= MAX_AMOUNT_OF_BLOCKS * -1
        && drone.getY() <= MAX_AMOUNT_OF_BLOCKS;
    if (!isWithinAllowedBlocks) {
      StringBuilder message = new StringBuilder();
      message.append("The drone ");
      message.append(drone.getName());
      message.append(" is delivering a lunch more than ");
      message.append(MAX_AMOUNT_OF_BLOCKS);
      message.append(" blocks away ");
      message.append(drone.toString());
      throw new DroneException(message.toString());
    }
  }

  public void validateAction(DroneAction actionEnum, Drone drone, Character action) {
    if (actionEnum == null) {
      String message = String.format("The action %s in drone %s is undefined", action, drone.getName());
      throw new DroneException(message);
    }
  }
}

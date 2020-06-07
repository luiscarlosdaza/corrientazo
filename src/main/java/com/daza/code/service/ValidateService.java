package com.daza.code.service;

import com.daza.code.exception.DroneException;
import com.daza.code.model.Drone;

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
      message.append(" lunches.");
      throw new DroneException(message.toString());
    }
  }

  public void validateBlocks(Drone drone) {
    boolean isWithinBlocksAllowed = drone.getX() >= MAX_AMOUNT_OF_BLOCKS * -1
        && drone.getX() <= MAX_AMOUNT_OF_BLOCKS
        && drone.getY() >= MAX_AMOUNT_OF_BLOCKS * -1
        && drone.getY() <= MAX_AMOUNT_OF_BLOCKS;
    if (!isWithinBlocksAllowed) {
      StringBuilder message = new StringBuilder();
      message.append("The drone ");
      message.append(drone.getName());
      message.append(" is delivering a lunch more than ");
      message.append(MAX_AMOUNT_OF_BLOCKS);
      message.append(" blocks away. ");
      message.append(drone.toString());
      throw new DroneException(message.toString());
    }
  }
}

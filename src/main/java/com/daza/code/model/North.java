package com.daza.code.model;

import com.daza.code.exception.DroneException;

public class North implements CardinalDirection {

  @Override
  public void move(Drone drone, Character action) {
    switch (action) {
      case 'A':
        drone.setY(drone.getY() + 1);
        break;
      case 'I':
        drone.setCardinalDirection(new West());
        break;
      case 'D':
        drone.setCardinalDirection(new East());
        break;
      default:
        String message = String.format("Dron %s: the action %s is undefined.", drone.getName(), action);
        throw new DroneException(message);
    }
  }

  @Override
  public Character getLetter() {
    return 'N';
  }
}

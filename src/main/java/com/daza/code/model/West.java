package com.daza.code.model;

public class West implements CardinalDirection {

  @Override
  public void move(Drone drone, DroneAction action) {
    switch (action) {
      case A:
        drone.setX(drone.getX() - 1);
        break;
      case I:
        drone.setCardinalDirection(new South());
        break;
      case D:
        drone.setCardinalDirection(new North());
        break;
    }
  }

  @Override
  public String getLetter() {
    return "Occidente";
  }
}

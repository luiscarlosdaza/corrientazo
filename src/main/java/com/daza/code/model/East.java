package com.daza.code.model;

public class East implements CardinalDirection {

  @Override
  public void move(Drone drone, DroneAction action) {
    switch (action) {
      case A:
        drone.setX(drone.getX() + 1);
        break;
      case I:
        drone.setCardinalDirection(new North());
        break;
      case D:
        drone.setCardinalDirection(new South());
        break;
    }
  }

  @Override
  public String getLetter() {
    return "Oriente";
  }
}

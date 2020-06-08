package com.daza.code.model;

public class South implements CardinalDirection {

  @Override
  public void move(Drone drone, DroneAction action) {
    switch (action) {
      case A:
        drone.setY(drone.getY() - 1);
        break;
      case I:
        drone.setCardinalDirection(new East());
        break;
      case D:
        drone.setCardinalDirection(new West());
        break;
    }
  }

  @Override
  public String getLetter() {
    return "Sur";
  }
}

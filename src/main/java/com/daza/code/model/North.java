package com.daza.code.model;

public class North implements CardinalDirection {

  @Override
  public void move(Drone drone, DroneAction action) {
    switch (action) {
      case A:
        drone.setY(drone.getY() + 1);
        break;
      case I:
        drone.setCardinalDirection(new West());
        break;
      case D:
        drone.setCardinalDirection(new East());
        break;
    }
  }

  @Override
  public String getLetter() {
    return "Norte";
  }
}

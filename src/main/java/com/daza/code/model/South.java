package com.daza.code.model;

public class South implements CardinalDirection {

  @Override
  public void move(Drone drone, Character action) {
    switch (action) {
      case 'A':
        drone.setY(drone.getY() - 1);
        break;
      case 'I':
        drone.setCardinalDirection(new East());
        break;
      case 'D':
        drone.setCardinalDirection(new West());
        break;
      default:
        String message = String.format("Dron: %s: the action %s is undefined.", drone.getName(), action);
        throw new RuntimeException(message);
    }
  }

  @Override
  public Character getLetter() {
    return 'S';
  }
}

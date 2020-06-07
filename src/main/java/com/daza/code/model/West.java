package com.daza.code.model;

public class West implements CardinalDirection {

  @Override
  public void move(Drone drone, Character action) {
    switch (action) {
      case 'A':
        drone.setX(drone.getX() - 1);
        break;
      case 'I':
        drone.setCardinalDirection(new South());
        break;
      case 'D':
        drone.setCardinalDirection(new North());
        break;
      default:
        String message = String.format("Dron: %s: the action %s is undefined.", drone.getName(), action);
        throw new RuntimeException(message);
    }
  }

  @Override
  public Character getLetter() {
    return 'O';
  }
}

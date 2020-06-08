package com.daza.code.model;

public interface CardinalDirection {
  void move(Drone drone, DroneAction action);

  String getLetter();
}

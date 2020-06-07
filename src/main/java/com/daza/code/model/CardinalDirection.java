package com.daza.code.model;

public interface CardinalDirection {
  void move(Drone drone, Character action);

  Character getLetter();
}

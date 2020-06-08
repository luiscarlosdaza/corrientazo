package com.daza.code.model;

public enum DroneAction {
  A('A'), I('I'), D('D');

  public char action() {
    return action;
  }

  private final char action;

  DroneAction(char action) {
    this.action = action;
  }

  public static DroneAction getAction(final char name)
  {
    for (DroneAction type : DroneAction.values())
      if (type.action == name) {
        return type;
      }

    return null;
  }
}

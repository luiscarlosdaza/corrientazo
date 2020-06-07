package com.daza.code.model;

public class Drone {
  private String name;
  private int x;
  private int y;
  private CardinalDirection cardinalDirection;

  public Drone(String name) {
    this.name = name;
    this.cardinalDirection = new North();
  }

  public void move(Character action) {
    cardinalDirection.move(this, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    sb.append(x);
    sb.append(", ");
    sb.append(y);
    sb.append(", ");
    sb.append(cardinalDirection.getLetter());
    sb.append(")");
    return sb.toString();
  }

  public String getName() {
    return name;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setCardinalDirection(CardinalDirection cardinalDirection) {
    this.cardinalDirection = cardinalDirection;
  }
}

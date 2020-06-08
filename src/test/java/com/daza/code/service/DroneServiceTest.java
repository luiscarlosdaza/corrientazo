package com.daza.code.service;

import com.daza.code.exception.DroneException;
import com.daza.code.model.Drone;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DroneServiceTest {

  private Drone drone;
  private DroneService droneService;

  @Before
  public void init() {
    drone = new Drone("test");
    droneService = new DroneService();
  }

  @Test
  public void moveDronesFourLunchesInADrone() {
    //Arrange
    String message = "The drone " + drone.getName() + " is carrying more than 3 lunches";
    List<String> paths = new ArrayList<>();
    paths.add("AAAAIAA");
    paths.add("DDDAIAD");
    paths.add("AAIADAD");
    paths.add("AAIADAD");
    //Act
    try {
      droneService.moveDrones(drone, paths);
      fail();
    } catch (DroneException e) {
      //Assert
      assertEquals(message, e.getMessage());
    }
  }

  @Test
  public void moveDronesUndefinedAction() {
    //Arrange
    String message = "The action H in drone " + drone.getName() + " is undefined";
    List<String> paths = new ArrayList<>();
    paths.add("AAAAIAAH");
    //Act
    try {
      droneService.moveDrones(drone, paths);
      fail();
    } catch (DroneException e) {
      //Assert
      assertEquals(message, e.getMessage());
    }
  }

  @Test
  public void moveDronesMaxAmountOfBlocks() {
    //Arrange
    String message = "The drone " + drone.getName() + " is delivering a lunch more than 10 blocks away (0, 11) dirección Norte";
    List<String> paths = new ArrayList<>();
    paths.add("AAAAAAAAAAA");
    //Act
    try {
      droneService.moveDrones(drone, paths);
      fail();
    } catch (DroneException e) {
      //Assert
      assertEquals(message, e.getMessage());
    }
  }

  @Test
  public void moveDronesSuccess1() {
    //Arrange
    List<String> paths = new ArrayList<>();
    paths.add("AAAAIAA");
    paths.add("DDDAIAD");
    paths.add("AAIADAD");
    //Act
    List<String> result = droneService.moveDrones(drone, paths);
    //Assert
    assertEquals("(-2, 4) dirección Occidente", result.get(0));
    assertEquals("(-1, 3) dirección Sur", result.get(1));
    assertEquals("(0, 0) dirección Occidente", result.get(2));
  }

  @Test
  public void moveDronesSuccess2() {
    //Arrange
    List<String> paths = new ArrayList<>();
    paths.add("DDAAAIAAAA");
    paths.add("IIAAAAAADAAAA");
    paths.add("DAADA");
    //Act
    List<String> result = droneService.moveDrones(drone, paths);
    //Assert
    assertEquals("(4, -3) dirección Oriente", result.get(0));
    assertEquals("(-2, 1) dirección Norte", result.get(1));
    assertEquals("(0, 0) dirección Sur", result.get(2));
  }
}

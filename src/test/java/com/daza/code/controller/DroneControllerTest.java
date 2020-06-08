package com.daza.code.controller;

import com.daza.code.exception.DroneException;
import com.daza.code.service.ReaderAndWriterService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.daza.code.util.Constant.OUTPUT_FOLDER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DroneControllerTest {

  private DroneController droneController;
  private ReaderAndWriterService readerAndWriterService;
  private Helper helper;

  @Before
  public void init() {
    //Delete output files
    helper = new Helper();
    helper.createAndCleanOutputFolder();
    droneController = new DroneController();
    readerAndWriterService = new ReaderAndWriterService();
  }

  @Test
  public void executeDronesFourLunchesError() {
    //Arrange
    String filename = "in01-four-lunches.txt";
    File testFile = helper.getTestFileFromResources(filename);
    String message = "The drone " + filename + " is carrying more than 3 lunches";

    //Act
    try {
      droneController.executeDrones(testFile);
      fail();
    } catch (DroneException e) {
      //Assert
      assertEquals(message, e.getMessage());
    }
  }

  @Test
  public void executeDronesUndefinedAction() {
    //Arrange
    String filename = "in01-undefined-action.txt";
    File testFile = helper.getTestFileFromResources(filename);
    String message = "The action H in drone " + filename + " is undefined";

    //Act
    try {
      droneController.executeDrones(testFile);
      fail();
    } catch (DroneException e) {
      //Assert
      assertEquals(message, e.getMessage());
    }
  }

  @Test
  public void executeDronesMaxAmountOfBlocks() {
    //Arrange
    String filename = "in01-max-amount-blocks.txt";
    File testFile = helper.getTestFileFromResources(filename);
    String message = "The drone " + filename + " is delivering a lunch more than 10 blocks away (0, 11) dirección Norte";

    //Act
    try {
      droneController.executeDrones(testFile);
      fail();
    } catch (DroneException e) {
      //Assert
      assertEquals(message, e.getMessage());
    }
  }

  @Test
  public void executeDronesSuccessNumberOne() {
    //Arrange
    File testFile = helper.getTestFileFromResources("in01-sucess-1.txt");
    List<String> expected = new ArrayList<>();
    expected.add("(-2, 4) dirección Occidente");
    expected.add("(-1, 3) dirección Sur");
    expected.add("(0, 0) dirección Occidente");

    //Act
    droneController.executeDrones(testFile);
    File outputFile = new File(OUTPUT_FOLDER + "/out01-sucess-1.txt");
    List<String> result = readerAndWriterService.getPathsFromInputFile(outputFile);

    assertEquals(expected.get(0), result.get(2).trim());
    assertEquals(expected.get(1), result.get(4).trim());
    assertEquals(expected.get(2), result.get(6).trim());
  }

  @Test
  public void executeDronesSuccessNumberTwo() {
    //Arrange
    File testFile = helper.getTestFileFromResources("in01-sucess-2.txt");
    List<String> expected = new ArrayList<>();
    expected.add("(4, -3) dirección Oriente");
    expected.add("(-2, 1) dirección Norte");
    expected.add("(0, 0) dirección Sur");

    //Act
    droneController.executeDrones(testFile);
    File outputFile = new File(OUTPUT_FOLDER + "/out01-sucess-2.txt");
    List<String> result = readerAndWriterService.getPathsFromInputFile(outputFile);

    assertEquals(expected.get(0), result.get(2).trim());
    assertEquals(expected.get(1), result.get(4).trim());
    assertEquals(expected.get(2), result.get(6).trim());
  }
}

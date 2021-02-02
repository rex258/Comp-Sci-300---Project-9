//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P9 Tests
// Files: Badger.java
//        Sett.java
// Course: Comp Sci 300 (41962), Fall Term, 2018
//
// Author: Amairani Zepeda
// Email: zepeda2@wisc.edu
// Lecturer's Name: Gary Dahl
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class has a series of tests to check that Badger class and Sett class function properly.
 * 
 * @author Amairani
 *
 */
public class P9Tests {

  /**
   * This method is the main method that runs all tests and prints out messages if the tests were
   * passed or failed.
   * 
   * @param args
   */
  public static void main(String[] args) {
    boolean pass = true;
    if (!runAllBadgerTests()) { // checks if all Badger class tests were passed
      System.out.println("test did not pass.");
      pass = false;
    }
    if (!runAllSettTests()) { // checks if all Sett class tests were passed
      System.out.println("test did not pass.");
      pass = false;
    }
    if (pass) { // if all tests were passed
      System.out.println("All tests were passed!");
    }

  }

  /**
   * This method tests that all the Badger tests are passed.
   * 
   * @return true when all Badger tests pass, false otherwise
   */
  public static boolean runAllBadgerTests() {
    boolean pass = true;
    if (!newBadgerTest()) { // checks Badger constructor
      System.out.print("newBadgerTest() ");
      pass = false;
    }
    if (!getBadgerTest1()) { // checks getBadger
      System.out.print("getBadgerTest1() ");
      pass = false;
    }
    if (!getBadgerTest2()) { // checks getBadger
      System.out.print("getBadgerTest2() ");
      pass = false;
    }
    return pass;
  }

  /**
   * This method tests that all the Sett tests are passed.
   * 
   * @return true when all Sett tests pass, false otherwise
   */
  public static boolean runAllSettTests() {
    boolean pass = true;
    if (!settConstructorTest()) { // checks the Sett constructor
      System.out.print("settConstructorTest() ");
      pass = false;
    }
    if (!getTopBadgerTest()) { // checks getTopBadger
      System.out.print("getTopBadgerTest() ");
      pass = false;
    }
    if (!isEmptyTest()) { // checks isEmpty
      System.out.print("isEmptyTest() ");
      pass = false;
    }
    if (!settleBadgerTest()) { // checks settleBadger
      System.out.print("settleBadgerTest() ");
      pass = false;
    }
    if (!findBadgerTest()) { // checks findBadger
      System.out.print("findBadgerTest() ");
      pass = false;
    }
    if (!countBadgerTest()) { // checks countBadger
      System.out.print("countBadgerTest() ");
      pass = false;
    }
    if (!getAllBadgersTest()) { // checks getAllBadgers
      System.out.print("getAllBadgersTest() ");
      pass = false;
    }
    if (!getHeightTest()) { // checks getHeight
      System.out.print("getHeightTest() ");
      pass = false;
    }
    if (!getLargestBadgerTest()) { // checks getLargestBadger
      System.out.print("getLargestBadgerTest() ");
      pass = false;
    }
    if (!clearTest()) { // checks clear
      System.out.print("clearTest() ");
      pass = false;
    }
    return pass;
  }

  /**
   * This method tests that a new Badger with no neighbors is successfully created.
   * 
   * @return return true if a Badger object is created, false otherwise
   */
  public static boolean newBadgerTest() {
    Badger badger = new Badger(10); // Badger of size 10
    if (badger.getSize() == 10 && badger.getLeftLowerNeighbor() == null
        && badger.getRightLowerNeighbor() == null) { // checks that Badger is created with no
                                                     // neighbors
      return true;
    }
    return false;
  }

  /**
   * This method tests that the setter and getter methods work accordingly for a complete BST.
   * 
   * @return true if all methods work, false otherwise
   */
  public static boolean getBadgerTest1() {
    Badger badger1 = new Badger(10); // Badger with size 10
    Badger badger2 = new Badger(5); // Badger with size 5
    Badger badger3 = new Badger(15); // Badger with size 15
    badger1.setLeftLowerNeighbor(badger2); // badger1 is the root, badger2 is the left neighbor
    badger1.setRightLowerNeighbor(badger3); // badger1 is the root, badger3 is the right neighbor

    if (badger1.getLeftLowerNeighbor().getSize() == 5
        && badger1.getRightLowerNeighbor().getSize() == 15) {
      return true;
    }
    return false;
  }

  /**
   * This method tests that the setter and getter methods work accordingly for a non-complete BST.
   * 
   * @return true if all methods work, false otherwise
   */
  public static boolean getBadgerTest2() {
    Badger badger1 = new Badger(10); // Badger with size 10
    Badger badger2 = new Badger(20); // Badger with size 20
    Badger badger3 = new Badger(15); // Badger with size 15
    badger1.setRightLowerNeighbor(badger2); // badger1 is the root, badger2 is the right neighbor
    badger2.setLeftLowerNeighbor(badger3); // badger1 is the root, badger3 is the left neighbor

    if (badger1.getRightLowerNeighbor().getLeftLowerNeighbor().getSize() == 15) {
      return true;
    }
    return false;
  }

  /**
   * This method checks that a new empty Sett is created.
   * 
   * @return true if the Sett is created, false otherwise
   */
  public static boolean settConstructorTest() {
    Sett newSett1 = new Sett(); // creates an empty Sett

    if (newSett1.isEmpty()) {
      return true;
    }
    return false;
  }

  /**
   * This method checks that getTopBadger() gets the first Badger that settled and checks for an
   * empty Sett.
   * 
   * @return true if the correct Badger is returned and null when Sett is empty, false otherwise
   */
  public static boolean getTopBadgerTest() {
    Sett newSett1 = new Sett(); // first Sett
    newSett1.settleBadger(10); // adds a Badger with size 10
    newSett1.settleBadger(5); // adds a Badger with size 5
    newSett1.settleBadger(15); // adds a Badger with size 15

    Sett newSett2 = new Sett(); // second Sett

    if (newSett1.getTopBadger().getSize() == 10 && newSett2.getTopBadger() == null) {
      return true;
    }
    return false;
  }

  /**
   * This method checks if isEmpty() returns false for a non-empty Sett and true for an empty Sett.
   * 
   * @return true if method works accordingly, false otherwise
   */
  public static boolean isEmptyTest() {
    Sett newSett1 = new Sett(); // first Sett
    newSett1.settleBadger(10); // adds a Badger with size 10

    Sett newSett2 = new Sett(); // second Sett

    if (!newSett1.isEmpty() && newSett2.isEmpty()) {
      return true;
    }
    return false;
  }

  /**
   * This method checks that settleBadgerTest() successfully adds a series of Badger objects. It
   * also checks that an exception is thrown when a Badger with a given size already exists.
   * 
   * @return true if Badgers were settled in Sett correctly, false otherwise
   * @throws java.lang.IllegalArgumentException when a Badger with given size already exists
   */
  public static boolean settleBadgerTest() throws java.lang.IllegalArgumentException {
    int count = 0; // pass test count
    Sett newSett = new Sett(); // creates a Sett
    newSett.settleBadger(10); // adds a Badger with size 10
    newSett.settleBadger(20); // adds a Badger with size 20
    newSett.settleBadger(5); // adds a Badger with size 5
    newSett.settleBadger(15); // adds a Badger with size 15
    newSett.settleBadger(25); // adds a Badger with size 25

    Badger badger = newSett.getTopBadger(); // gets the root Badger

    try {
      if (badger.getSize() == 10) { // checks that root Badger was added
        count++;
      }
      if (badger.getLeftLowerNeighbor().getSize() == 5) { // checks the Badger to the left of root
        count++;
      }
      if (badger.getRightLowerNeighbor().getSize() == 20) { // checks the Badger to the right of
                                                            // root
        count++;
      }
      newSett.settleBadger(15); // adds a Badger with size 15 (which already exists)
    } catch (IllegalArgumentException e) {
      if (e.getMessage().equals("WARNING: failed to settle the badger with size " + 15
          + ", as there is already a badger with the same size in this sett")) {
        count++;
      }
    }
    return count == 4;
  }

  /**
   * This method checks that findBadgerTest() successfully finds the Badger object with specified
   * size. It also checks that an exception is thrown when a Badger with a given size does not
   * exist.
   * 
   * @return true if Badger with specified side was found, false otherwise
   * @throws java.util.NoSuchElementException when the Badger with specified size is not found
   */
  public static boolean findBadgerTest() throws java.util.NoSuchElementException {
    int count = 0; // pass test count
    Sett newSett = new Sett(); // creates a Sett
    newSett.settleBadger(10); // adds a Badger with size 10
    newSett.settleBadger(20); // adds a Badger with size 20
    newSett.settleBadger(5); // adds a Badger with size 5
    newSett.settleBadger(15); // adds a Badger with size 15
    newSett.settleBadger(25); // adds a Badger with size 25

    try {
      if (newSett.findBadger(25).getSize() == 25) { // finds Badger with size 25
        count++;
      }
      if (newSett.findBadger(5).getSize() == 5) { // finds Badger with size 5
        count++;
      }
      newSett.findBadger(30); // finds Badger with size 30 (does not exists, should throw error)
    } catch (NoSuchElementException | IllegalArgumentException e) {
      count++;
    }
    return count == 3;
  }

  /**
   * This method tests that countBadgerTest() returns the correct number of Badgers in a Sett.
   * 
   * @return true if the correct count is returned, false otherwise
   */
  public static boolean countBadgerTest() {
    Sett newSett = new Sett(); // creates a Sett
    newSett.settleBadger(10); // adds a Badger with size 10
    newSett.settleBadger(20); // adds a Badger with size 20
    newSett.settleBadger(5); // adds a Badger with size 5
    newSett.settleBadger(15); // adds a Badger with size 15
    newSett.settleBadger(25); // adds a Badger with size 25

    if (newSett.countBadger() == 5) {
      return true;
    }
    return false;
  }

  /**
   * This method checks that getAllBadgersTest() creates a list of the Badgers in ascending order of
   * size.
   * 
   * @return true if the list was created correctly, false otherwise
   */
  public static boolean getAllBadgersTest() {
    int count = 0; // pass test count
    int size = 0; // size to check for
    Sett newSett = new Sett(); // creates a Sett
    newSett.settleBadger(10); // adds a Badger with size 10
    newSett.settleBadger(20); // adds a Badger with size 20
    newSett.settleBadger(5); // adds a Badger with size 5
    newSett.settleBadger(15); // adds a Badger with size 15
    newSett.settleBadger(25); // adds a Badger with size 25

    for (Badger badger : newSett.getAllBadgers()) {
      size += 5;
      if (badger.getSize() == size) {
        count++;
      }
    }
    return count == 5;
  }

  /**
   * This method checks that getHeightTest() returns the correct height of the tree.
   * 
   * @return true of the correct height is given, false otherwise
   */
  public static boolean getHeightTest() {
    Sett newSett = new Sett(); // creates a Sett
    newSett.settleBadger(10); // adds a Badger with size 10
    newSett.settleBadger(5); // adds a Badger with size 5
    newSett.settleBadger(20); // adds a Badger with size 20
    newSett.settleBadger(15); // adds a Badger with size 15
    newSett.settleBadger(25); // adds a Badger with size 25
    newSett.settleBadger(17);

    if (newSett.getHeight() == 4) {
      return true;
    }
    return false;
  }

  /**
   * This method checks that getLargestBadger() returns the Badger object with the largest size.
   * 
   * @return true if the Badger object was found, false otherwise
   */
  public static boolean getLargestBadgerTest() {
    Sett newSett = new Sett(); // creates a Sett
    newSett.settleBadger(10); // adds a Badger with size 10
    newSett.settleBadger(5); // adds a Badger with size 5
    newSett.settleBadger(20); // adds a Badger with size 20
    newSett.settleBadger(15); // adds a Badger with size 15
    newSett.settleBadger(25); // adds a Badger with size 25

    if (newSett.getLargestBadger().getSize() == 25) {
      return true;
    }
    return false;
  }

  /**
   * This method checks that clear() successfully removes all Badger objects in the Sett.
   * 
   * @return true if the Sett is empty, false otherwise
   */
  public static boolean clearTest() {
    Sett newSett = new Sett(); // creates a Sett
    newSett.settleBadger(10); // adds a Badger with size 10
    newSett.settleBadger(20); // adds a Badger with size 20
    newSett.settleBadger(15); // adds a Badger with size 15
    newSett.settleBadger(5); // adds a Badger with size 5

    newSett.clear(); // clears the Sett

    return newSett.isEmpty();
  }
}

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Sett
// Files: Badger.java
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
 * This class represents a Sett, where a group of Badgers live together. Each Sett is organized as a
 * BST of Badger nodes.
 * 
 * @author Amairani
 *
 */
public class Sett {
  private Badger topBadger; // the root of the BST

  /**
   * This constructor constructs an empty Sett.
   */
  public Sett() {
    topBadger = null;
  }

  /**
   * This method retrieves the top Badger within this Sett (the one that was settled first).
   * 
   * @return the Badger living on the top of the current Sett
   */
  public Badger getTopBadger() {
    return topBadger;
  }

  /**
   * This method checks whether this Sett is empty.
   * 
   * @return true if this Sett is empty, false otherwise
   */
  public boolean isEmpty() {
    if (topBadger == null) { // checks if Sett is empty
      return true;
    }
    return false;
  }

  /**
   * This method creates a new Badger object with the specified size, and inserts them into this
   * Sett (BST).
   * 
   * @param size is the size of the new Badger that will be settled
   * @throws java.lang.IllegalArgumentException when a Badger with given size already exists
   */
  public void settleBadger(int size) throws java.lang.IllegalArgumentException {
    Badger badger = new Badger(size);
    if (topBadger == null) {
      topBadger = badger;
    } else {
      settleHelper(topBadger, badger);
    }
  }

  /**
   * This method is a recursive helper method that is used to help settle a new Badger within this
   * Sett.
   * 
   * @param current is the current Badger
   * @param newBadger is the new Badger that needs to be settled within this Sett
   * @throws java.lang.IllegalArgumentException when a Badger with given size already exists
   */
  private void settleHelper(Badger current, Badger newBadger)
      throws java.lang.IllegalArgumentException {
    if (newBadger.getSize() < current.getSize()) { // checks if newBadger is smaller than the
                                                   // current Badger
      if (current.getLeftLowerNeighbor() == null) { // checks if the left side has no neighbor
        current.setLeftLowerNeighbor(newBadger);
      } else {
        settleHelper(current.getLeftLowerNeighbor(), newBadger);
      }
    } else if (newBadger.getSize() > current.getSize()) { // checks if newBadger is bigger than the
                                                          // current Badger
      if (current.getRightLowerNeighbor() == null) { // checks if the right side has no neighbor
        current.setRightLowerNeighbor(newBadger);
      } else {
        settleHelper(current.getRightLowerNeighbor(), newBadger);
      }
    } else if (newBadger.getSize() == current.getSize()) { // checks if newBadger and current Badger
                                                           // are the same size
      throw new IllegalArgumentException("WARNING: failed to settle the badger with size "
          + newBadger.getSize() + ", as there is already a badger with the same size in this sett");
    }
  }

  /**
   * This method finds a Badger of a specified size in this Sett.
   * 
   * @param size is the size of the Badger object to search for and return
   * @return the badger found with the specified size
   * @throws java.util.NoSuchElementException when the Badger with specified size is not found
   */
  public Badger findBadger(int size) throws java.util.NoSuchElementException {
    return findHelper(topBadger, size);
  }

  /**
   * This method is a recursive helper methods that is used to help find a Badger within this Sett.
   * 
   * @param current is the current Badger that is the root of a (sub) tree that we are searching for
   *        a Badger with the specified size within
   * @param size is the size of the Badger object to search for and return
   * @return the Badger found with specified size
   * @throws java.util.NoSuchElementException when the Badger with specified size is not found
   */
  private Badger findHelper(Badger current, int size) throws java.util.NoSuchElementException {
    if (current != null) {
      if (current.getSize() == size) { // checks if Badger object size found
        return current;
      } else if (size < current.getSize()) { // checks left side of (sub) tree
        return findHelper(current.getLeftLowerNeighbor(), size);
      } else if (size > current.getSize()) { // checks right side of (sub) tree
        return findHelper(current.getRightLowerNeighbor(), size);
      }
    } else { // checks if Badger object size is not found
      throw new NoSuchElementException(
          "WARNING: failed to find a badger with size " + size + " in the sett");
    }
    return current;
  }

  /**
   * This method counts how many Badgers live in this Sett.
   * 
   * @return the number of Badgers living in this Sett
   */
  public int countBadger() {
    return countHelper(topBadger) + 1;
  }

  /**
   * This method is a recursive method that is used to help count the number of Badgers in this
   * Sett.
   * 
   * @param current is the current Badger that is the root of a (sub) tree that we are counting the
   *        number of Badgers within
   * @return the number of Badgers living in the Sett rooted at the current Badger
   */
  private int countHelper(Badger current) {
    int count = 0;
    if (current == null) {
      return count;
    }
    if (current.getLeftLowerNeighbor() != null) { // checks the left side of a (sub) tree
      count++;
      count += countHelper(current.getLeftLowerNeighbor());
    }
    if (current.getRightLowerNeighbor() != null) { // checks the right side of a (sub) tree
      count++;
      count += countHelper(current.getRightLowerNeighbor());
    }
    return count;
  }

  /**
   * This method gets all Badgers living in the Sett as a list in ascending order of their size:
   * smallest on in the front (at index zero), through the largest one at the end (at index size-1).
   * 
   * @return a list of all Badgers living in the Sett in ascending order by size
   */
  public java.util.List<Badger> getAllBadgers() {
    java.util.List<Badger> allBadgers = new java.util.ArrayList<Badger>(); // creates array list
    getAllHelper(topBadger, allBadgers);
    return allBadgers;
  }

  /**
   * This method is a recursive helper method that is used to help collect the Badgers within this
   * Sett into a List.
   * 
   * @param current is the current Badger that is the root of a (sub) tree that we are collecting
   *        all contained Badgers within, into the allBadgers List
   * @param allBadgers is the list of all Badgers living in the Sett that is rooted at the current
   *        Badger node
   */
  private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {
    if (current == null) {
      return;
    }
    getAllHelper(current.getLeftLowerNeighbor(), allBadgers); // recursive call for left neighbors
    allBadgers.add(current); // adds Badger to array list
    getAllHelper(current.getRightLowerNeighbor(), allBadgers); // recursive call for right neighbors
  }

  /**
   * This method computes the height of the Sett, as the number of nodes from root to the deepest
   * leaf Badger node.
   * 
   * @return the depth of this Sett
   */
  public int getHeight() {
    if (topBadger == null) { // checks if not Badgers in Sett
      return 0;
    } else {
      return getHeightHelper(topBadger);
    }
  }

  /**
   * This method is a recursive helper method that is used to help compute the height of this Sett.
   * 
   * @param current is the current Badger that is the root of a (sub) tree that we are calculating
   *        the height of
   * @return the height of the (sub) tree that we are calculating
   */
  private int getHeightHelper(Badger current) {
    int left = 0; // left side node counter
    int right = 0; // right side node counter
    if (current.getLeftLowerNeighbor() != null) { // checks that there is a left neighbor
      left = getHeightHelper(current.getLeftLowerNeighbor());
    }
    if (current.getRightLowerNeighbor() != null) { // checks that there is a right neighbor
      right = getHeightHelper(current.getRightLowerNeighbor());
    }
    if (left > right) { // checks which counter is larger, left or right
      return left + 1;
    } else {
      return right + 1;
    }
  }

  /**
   * This method retrieves the largest Badger living in this Sett.
   * 
   * @return the largest Badger living in this Sett
   */
  public Badger getLargestBadger() {
    return getAllBadgers().get(getAllBadgers().size() - 1);
  }

  /**
   * This method empties this Sett, to no longer contain any Badgers.
   */
  public void clear() {
    topBadger = null;
  }
}

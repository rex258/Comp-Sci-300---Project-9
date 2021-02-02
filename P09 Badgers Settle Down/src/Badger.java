//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Badger
// Files: None
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

/**
 * This class represents a Badger which is designed to live in a Sett. Each Badger object represents
 * a single node within a Sett.
 * 
 * @author Amairani
 *
 */
public class Badger {
  private Badger leftLowerNeighbor; // left neighbor of a Badger node
  private Badger rightLowerNeighbor; // right neigbor of a Badger node
  private final int size; // size of Badger

  /**
   * This constructor creates a new Badger with specified size.
   * 
   * @param size is the size of the Badger
   */
  public Badger(int size) {
    this.leftLowerNeighbor = null;
    this.rightLowerNeighbor = null;
    this.size = size; // initiates size to size
  }

  /**
   * This method retrieves the neighboring badger that is smaller than this one.
   * 
   * @return the left lower neighbor of the current badger
   */
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor;
  }

  /**
   * This method changes this badger's lower left neighbor.
   * 
   * @param badger is the new left lower neighbor of the current badger
   */
  public void setLeftLowerNeighbor(Badger badger) {
    leftLowerNeighbor = badger;
  }

  /**
   * This method retrieves the neighboring badger that is larger than this one.
   * 
   * @return the right lower neighbor of the current badger
   */
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor;
  }

  /**
   * This method changes this badger's lower right neighbor.
   * 
   * @param badger is the new right lower neighbor of the current badger
   */
  public void setRightLowerNeighbor(Badger badger) {
    rightLowerNeighbor = badger;
  }

  /**
   * This method retrieves the size of this badger.
   * 
   * @return the size of the current badger
   */
  public int getSize() {
    return size;
  }
}

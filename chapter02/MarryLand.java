package chapter02;

import java.beans.PropertyDescriptor;

public class MarryLand extends State {
  MarryLand() {}
  public void printMe() {
    System.out.println("Read it.");
  }

  public static void main(final String[] args) {
    Region east = new State();
    State md = new MarryLand();
    Object obj = new Place();
    Place usa = new Region();
    md.printMe(); // Read it.
    east.printMe(); // Ship it.
    ((Place) obj).printMe(); // Buy it.
    obj = md;
    ((MarryLand) obj).printMe(); // Read it.
    obj = usa;
    ((Place) obj).printMe(); // Buy it.
    usa = md;
    ((Place) usa).printMe(); // Read it.
  }
}

class State extends Region {
  State(){};

  public void printMe() {
    System.out.println("Ship it.");
  }
}


class Region extends Place {
  Region(){};

  public void printMe() {
    System.out.println("Box it.");
  }
}

class Place extends Object {
  Place(){};

  public void printMe() {
    System.out.println("Buy it.");
  }
}

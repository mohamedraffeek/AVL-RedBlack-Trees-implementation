package Trees;

import java.util.Scanner;

public class Main {

  public static final String ANSI_RESET = "\u001B[0m", BLACK = "\u001B[30m", RED = "\u001B[31m", GREEN = "\u001B[32m",
      YELLOW = "\u001B[33m", BLUE = "\u001B[34m", PURPLE = "\u001B[35m", CYAN = "\u001B[36m";

  public static void main(String[] args) {
    RedBlack<Integer> rb = new RedBlack<Integer>();
    System.out.println(rb.insert(10));
    System.out.println(rb.insert(15));
    System.out.println(rb.insert(20));
    System.out.println(rb.insert(25));
    System.out.println(rb.insert(30));
    System.out.println(rb.insert(35));
    System.out.println(rb.insert(40));
    System.out.println(rb.insert(45));
    System.out.println(rb.insert(37));
    System.out.println(rb.insert(50));
    System.out.println(rb.delete(30));
    System.out.println(rb.insert(28));
    System.out.println(rb.insert(38));
    System.out.println(rb.insert(36));
    System.out.println(rb.insert(29));
    System.out.println(rb.insert(26));

    System.out.println(rb.delete(50));
    System.out.println(rb.delete(45));
    // rb.delete(80);
    // rb.printInorder();
    // rb.printInorder();
    // rb.delete(9);
    // System.out.println(rb.search(4));
    // rb.delete(15);
    // rb.delete(9);
    // System.out.println(rb.size);
    // System.out.println(rb.getSize());
    // rb.delete(11);
    // rb.delete(19);
    // System.out.println(rb.getSize());
    // System.out.println(rb.getHeight());
    // System.out.println(rb.search(200));
    // System.out.println(rb.search(39));
    rb.printInorder();
    // System.out.println(rb.getHeight());
    // System.out.println(rb.search(rb.root, 10));
    // get height
    // get size
    // insert
    // search will return the node
    // delete not complete
  }
}
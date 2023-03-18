package Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    RedBlack<String> rb = new RedBlack<String>();
    // System.out.println(rb.insert(1));
    // System.out.println(rb.insert(2));
    // System.out.println(rb.insert(3));
    // System.out.println(rb.insert(12));
    // System.out.println(rb.insert(19));
    // System.out.println(rb.insert(8));
    // System.out.println(rb.getSize());
    // System.out.println(rb.getHeight());
    // System.out.println(rb.search(200));
    // System.out.println(rb.search(19));
    try {
      File myObj = new File("E:/level2/DS2/test.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        data = data.toLowerCase();
        rb.insert(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println(rb.search("z"));
    System.out.println(rb.search("a"));
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
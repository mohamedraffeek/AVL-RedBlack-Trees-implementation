package Trees;

public class Main {
  public static void main(String[] args) {
    RedBlack<Integer> rb = new RedBlack<Integer>();
    System.out.println(rb.insert(41));
    System.out.println(rb.insert(38));
    System.out.println(rb.insert(31));
    System.out.println(rb.insert(12));
    System.out.println(rb.insert(19));
    System.out.println(rb.insert(8));
    System.out.println(rb.getSize());
    System.out.println(rb.getHeight());
    System.out.println(rb.search(200));
    System.out.println(rb.search(19));
    // System.out.println(rb.getHeight());
    // System.out.println(rb.search(rb.root, 10));
    // get height
    // get size
    // insert
    // search will return the node
    // delete not complete
  }
}

package Trees;

import java.util.Scanner;

public class Main {
  
  public static final String ANSI_RESET = "\u001B[0m", BLACK = "\u001B[30m", RED = "\u001B[31m", GREEN = "\u001B[32m", YELLOW = "\u001B[33m", BLUE = "\u001B[34m", PURPLE = "\u001B[35m", CYAN = "\u001B[36m";
  public static void main(String[] args) {
    util.clearScreen();

    Dictionary d = null;

    System.out.println(GREEN + "Select the tree type:" + ANSI_RESET);
    System.out.println(BLUE + "\t- AVL" + ANSI_RESET + "(Enter 1)");
    System.out.println(RED + "\t- Red" + ANSI_RESET + "-" + BLACK + "Black " + ANSI_RESET + "(Enter 2)");

    Scanner sc = new Scanner(System.in);
    String selection = "0";
    while(!selection.equals("1") && !selection.equals("2")){
      selection = sc.nextLine();
      if(!selection.equals("1") && !selection.equals("2")){}
      else if(selection.equals("1")) d = new Dictionary("avl");
      else d = new Dictionary("red-black");
    }
    
    while(true){
      util.clearScreen();
      System.out.println(PURPLE + "1." + CYAN + " Insert" + ANSI_RESET);
      System.out.println(PURPLE + "2." + CYAN + " Delete" + ANSI_RESET);
      System.out.println(PURPLE + "3." + CYAN + " Search" + ANSI_RESET);
      System.out.println(PURPLE + "4." + CYAN + " Batch Insert" + ANSI_RESET);
      System.out.println(PURPLE + "5." + CYAN + " Batch Delete" + ANSI_RESET);
      System.out.println(PURPLE + "6." + CYAN + " Size" + ANSI_RESET);
      System.out.println(PURPLE + "7." + CYAN + " Height" + ANSI_RESET);
      System.out.println(PURPLE + "8." + CYAN + " Exit" + ANSI_RESET);
      selection = sc.nextLine();
      util.clearScreen();
      switch(selection){
        case "1":
          System.out.print("Enter the key to insert: ");
          Scanner insertScanner = new Scanner(System.in);
          String insertString = insertScanner.nextLine();
          util.doInsert(d, insertString);
          break;
        case "2":
          System.out.print("Enter the key to delete: ");
          Scanner deleteScanner = new Scanner(System.in);
          String deleteString = deleteScanner.nextLine();
          util.doDelete(d, deleteString);
          break;
        case "3":
          System.out.print("Enter the key to search for: ");
          Scanner searchScanner = new Scanner(System.in);
          String searchString = searchScanner.nextLine();
          util.doSearch(d, searchString);
          break;
        case "4":
          System.out.print("Enter the file path: ");
          Scanner batchInsertScanner = new Scanner(System.in);
          String batchInsertFilePath = batchInsertScanner.nextLine();
          util.doBatchInsert(d, batchInsertFilePath);
          break;
        case "5":
          System.out.print("Enter the file path: ");
          Scanner batchDeleteScanner = new Scanner(System.in);
          String batchDeleteFilePath = batchDeleteScanner.nextLine();
          util.doBatchDelete(d, batchDeleteFilePath);
          break;
        case "6":
          util.doSize(d);
          break;
        case "7":
          util.doHeight(d);
          break;
        case "8":
          sc.close();
          System.exit(0);
          break;
        default:
          break;
      }
    }

    // Dictionary d = new Dictionary("avl");
    // System.out.println(d.insert("ahmed"));
    // System.out.println(d.insert("ahmed"));
    // System.out.println(d.insert("abdo"));
    // System.out.println(d.delete("rafeek"));
    // System.out.println(d.insert("rafeek"));
    // System.out.println(d.search("magdy"));
    // System.out.println(d.insert("hassan"));
    // System.out.println(d.getHeight());
    // System.out.println(d.getSize());
    // System.out.println(d.batchInsert("E:/level2/DS2/test.txt"));
    // System.out.println(d.batchDelete("E:/level2/DS2/test.txt"));
    // RedBlack<String> rb = new RedBlack<String>();
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
    // try {
    // File myObj = new File("E:/level2/DS2/test.txt");
    // Scanner myReader = new Scanner(myObj);
    // while (myReader.hasNextLine()) {
    // String data = myReader.nextLine();
    // data = data.toLowerCase();
    // rb.insert(data);
    // }
    // myReader.close();
    // } catch (FileNotFoundException e) {
    // System.out.println("An error occurred.");
    // e.printStackTrace();
    // }
    // System.out.println(rb.search("z"));
    // System.out.println(rb.search("a"));
    // rb.printInorder();
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
    //rb.printInorder();
    //rb.printInorder();
    //rb.delete(9);
    //System.out.println(rb.search(4));
    //rb.delete(15);
    //rb.delete(9);
   // System.out.println(rb.size);
    //System.out.println(rb.getSize());
   // rb.delete(11);
    //rb.delete(19);
    //System.out.println(rb.getSize());
    //System.out.println(rb.getHeight());
    //System.out.println(rb.search(200));
    //System.out.println(rb.search(39));
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
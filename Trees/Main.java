package Trees;

import java.util.Scanner;

public class Main {

  public static final String ANSI_RESET = "\u001B[0m", BLACK = "\u001B[30m", RED = "\u001B[31m", GREEN = "\u001B[32m",
      YELLOW = "\u001B[33m", BLUE = "\u001B[34m", PURPLE = "\u001B[35m", CYAN = "\u001B[36m";

  public static void main(String[] args) {

    util.clearScreen();

    Dictionary d = null;

    System.out.println(GREEN + "Select the tree type:" + ANSI_RESET);
    System.out.println(BLUE + "\t- AVL" + ANSI_RESET + "(Enter 1)");
    System.out.println(RED + "\t- Red" + ANSI_RESET + "-" + BLACK + "Black " + ANSI_RESET + "(Enter 2)");

    Scanner sc = new Scanner(System.in);
    String selection = "0";
    while (!selection.equals("1") && !selection.equals("2")) {
      selection = sc.nextLine();
      if (!selection.equals("1") && !selection.equals("2")) {
      } else if (selection.equals("1"))
        d = new Dictionary("avl");
      else
        d = new Dictionary("red-black");
    }

    while (true) {
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
      switch (selection) {
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

  }
}
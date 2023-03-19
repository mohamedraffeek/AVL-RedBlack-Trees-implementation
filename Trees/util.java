package Trees;


public class util {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void doHeight(Dictionary dict){
        System.out.println(dict.getHeight());
        System.out.println("Press any key to go back");
        try
        {
        System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static void doSize(Dictionary dict) {
        System.out.println(dict.getSize());
        System.out.println("Press any key to go back");
        try
        {
        System.in.read();
        }
        catch(Exception e)
        {}
    }
    public static void doBatchDelete(Dictionary dict, String batchDeleteFilePath) {
        System.out.println(dict.batchDelete(batchDeleteFilePath));
        System.out.println("Press any key to go back");
        try
        {
        System.in.read();
        }
        catch(Exception e)
        {}
    }
    public static void doBatchInsert(Dictionary dict, String batchInsertFilePath) {
        System.out.println(dict.batchInsert(batchInsertFilePath));
        System.out.println("Press any key to go back");
        try
        {
        System.in.read();
        }
        catch(Exception e)
        {}
    }
    public static void doSearch(Dictionary dict, String searchString) {
        System.out.println(dict.search(searchString));
        System.out.println("Press any key to go back");
        try
        {
        System.in.read();
        }
        catch(Exception e)
        {}
    }
    public static void doDelete(Dictionary dict, String deleteString) {
        System.out.println(dict.delete(deleteString));
        System.out.println("Press any key to go back");
        try
        {
        System.in.read();
        }
        catch(Exception e)
        {}
    }
    public static void doInsert(Dictionary dict, String inputString) {
        System.out.println(dict.insert(inputString));
        System.out.println("Press any key to go back");
        try
        {
        System.in.read();
        }
        catch(Exception e)
        {}
    }

}

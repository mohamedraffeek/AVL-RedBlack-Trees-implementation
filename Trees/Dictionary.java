package Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
    private ITree<String> dicRoot = null;

    public Dictionary(String type) {
        if (type.equals("avl"))
            dicRoot = new AVLTree<String>();
        else if (type.equals("red-black"))
            dicRoot = new RedBlack<String>();
    }

    public String search(String key) {
        return dicRoot.search(key);
    }

    public String insert(String key) {
        return dicRoot.insert(key);
    }

    public String delete(String key) {
        return dicRoot.delete(key);
    }

    public String getHeight() {
        return "Dictionary height is " + dicRoot.getHeight();
    }

    public String getSize() {
        return "Dictionary size is " + dicRoot.getSize();
    }

    public String batchInsert(String path) {
        int added = 0, exist = 0;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.toLowerCase();
                if (dicRoot.insert(data).equals(data + " already exits"))
                    exist++;
                else
                    added++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "An error occurred.";
        }
        return exist + " words already exists and " + added + " have been added successfully";
    }

    public String batchDelete(String path) {
        int notFound = 0, deleted = 0;
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data = data.toLowerCase();
                if (dicRoot.delete(data).equals(data + " not found"))
                    notFound++;
                else
                    deleted++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "An error occurred.";
        }
        return notFound + " words do not exist and " + deleted + " have been deleted successfully";
    }

}

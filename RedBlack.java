public class RedBlack implements IRedBlack {

    int size = 0;

    @Override
    public void insert() {



        /*
        * increment size by one after each SUCCESSFUL insertion
        * */
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public INode search(INode root, Comparable key) {
        if(root==null || root.getKey().compareTo(key) == 0){
            return root;
        }  if (root.getKey().compareTo(key) > 0) {
            return search(root.getLeft(),key);

        } if (root.getKey().compareTo(key) < 0) {
            return search(root.getRight(),key);
        }
        return null;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}

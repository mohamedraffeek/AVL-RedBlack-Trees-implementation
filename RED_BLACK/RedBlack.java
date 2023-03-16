package RED_BLACK;

public class RedBlack implements IRedBlack {

    IRBNode root;
    public RedBlack(){
        this.root = new RBNode(null, IRBNode.black);
    }

    int size = 0;

    @Override
    public void insert(Comparable key) {

        RBNode node = new RBNode(key,IRBNode.black );

        if(key == null){
            throw new RuntimeException("No key");
        }


        /* Insert to empty tree*/
        if(size == 0){
            this.root = node;
            this.root.setColor(IRBNode.black);
        }

        /*
        * increment size by one after each SUCCESSFUL insertion
        * */
    }



    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public IRBNode search(IRBNode root, Comparable key) {
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

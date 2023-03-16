package Trees;

public class RedBlack implements ITree {

    RBNode root;

    /*
    root is black by default
     */
    public RedBlack(){
        this.root = new RBNode(null, 'B');
    }

    int size = 0;

    @Override
    public void insert(Comparable key) {

        RBNode node = new RBNode(key,'B' );

        if(key == null){
            throw new RuntimeException("No key");
        }

        /* Insert to empty tree*/
        if(size == 0){
            this.root = node;
            this.root.setColor('B');
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

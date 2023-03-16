package RED_BLACK;

public class RBNode<K extends Comparable<K>, V> implements IRBNode {
    K key;
    int color;
    IRBNode parent;
    IRBNode right;
    IRBNode left;


    public RBNode(K key, int color){
     this.key = key;
     this.color = color;
    }

    @Override
    public Comparable getKey() {
        return null;
    }

    @Override
    public void setKey(Comparable key) {

    }


    @Override
    public void setRight(IRBNode right) {

    }

    @Override
    public IRBNode getRight() {
        return null;
    }

    @Override
    public void setLeft(IRBNode left) {

    }

    @Override
    public IRBNode getLeft() {
        return null;
    }

    @Override
    public void setParent(IRBNode parent) {

    }

    @Override
    public IRBNode getParent() {
        return null;
    }

    @Override
    public int getColor() {
        return 0;
    }

    @Override
    public void setColor(int color) {

    }

}

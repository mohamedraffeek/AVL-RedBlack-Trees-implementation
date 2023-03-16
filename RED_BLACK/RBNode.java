package RED_BLACK;

public class RBNode<K extends Comparable<K>, V> implements IRBNode {
    K key;
    V value;
    int color;
    IRBNode parent;
    IRBNode right;
    IRBNode left;


    public RBNode(K key, V value , int color, IRBNode parent, IRBNode right, IRBNode left, int size){
     this.key = key;
     this.value = value;
     this.color = color;
     this.parent = parent;
     this.right = right;
     this.left = left;

    }

    @Override
    public Comparable getKey() {
        return null;
    }

    @Override
    public void setKey(Comparable key) {

    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

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

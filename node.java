public class node <K extends Comparable<K>, V> implements INode {
    K key;
    V value;
    int color;
    INode parent;
    INode right;
    INode left;


    public node(K key, V value , int color, INode parent, INode right, INode left, int size){
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
    public void setRight(INode right) {

    }

    @Override
    public INode getRight() {
        return null;
    }

    @Override
    public void setLeft(INode left) {

    }

    @Override
    public INode getLeft() {
        return null;
    }

    @Override
    public void setParent(INode parent) {

    }

    @Override
    public INode getParent() {
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

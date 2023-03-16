package RED_BLACK;

public class RBNode<K extends Comparable<K>, V> implements INode {
    K key;
    char color;
    INode parent;
    INode right;
    INode left;


    public RBNode(K key, char color){
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


    public int getColor() {
        return 0;
    }


    public void setColor(int color) {

    }

}

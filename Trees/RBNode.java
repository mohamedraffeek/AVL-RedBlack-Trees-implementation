package Trees;

public class RBNode<K extends Comparable<K>>{
    K key;
    char color;
    RBNode<K> parent;
    RBNode<K> right;
    RBNode<K> left;


    public RBNode(K key, char color, RBNode<K> right, RBNode<K> left, RBNode<K> parent){
     this.key = key;
     this.color = color;
     this.parent = parent;
     this.right = right;
     this.left = left;
    }


    public Comparable<K> getKey() {
        return null;
    }


    public void setKey(K key) {

    }



    public void setRight(RBNode<K> right) {

    }


    public RBNode<K> getRight() {
        return null;
    }


    public void setLeft(RBNode<K> left) {

    }


    public RBNode<K> getLeft() {
        return null;
    }


    public void setParent(RBNode<K> parent) {

    }


    public RBNode<K> getParent() {
        return null;
    }


    public char getColor() {
        return 0;
    }


    public void setColor(int color) {

    }

    public boolean isNull(){
        return this.key == null;
    }

}

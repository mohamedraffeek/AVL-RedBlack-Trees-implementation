package Trees;

public class RBNode<K extends Comparable<K>> {
    K key;
    char color;
    RBNode<K> parent;
    RBNode<K> right;
    RBNode<K> left;

    public RBNode(K key, char color, RBNode<K> right, RBNode<K> left, RBNode<K> parent) {
        this.key = key;
        this.color = color;
        this.parent = parent;
        this.right = right;
        this.left = left;
    }

    public Comparable<K> getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setRight(RBNode<K> right) {
        this.right = right;
    }

    public RBNode<K> getRight() {
        return this.right;
    }

    public void setLeft(RBNode<K> left) {
        this.left = left;
    }

    public RBNode<K> getLeft() {
        return this.left;
    }

    public void setParent(RBNode<K> parent) {
        this.parent = parent;
    }

    public RBNode<K> getParent() {
        return this.parent;
    }

    public char getColor() {
        return this.color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public boolean isNull() {
        return this.key == null;
    }

}

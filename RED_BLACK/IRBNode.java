package RED_BLACK;

public interface IRBNode<K extends Comparable<K>>{

    static final int black = 0;
    static final int red  = 1;

    K getKey();
    void setKey(K key);

    void setRight(IRBNode<K> right);
    IRBNode<K> getRight();

    void setLeft(IRBNode<K> left);
    IRBNode<K> getLeft();

    void setParent(IRBNode<K> parent);
    IRBNode<K> getParent();

    int getColor();
    void setColor(int color);

}

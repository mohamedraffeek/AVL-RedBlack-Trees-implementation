package RED_BLACK;

public interface IRBNode<K extends Comparable<K>, V>{

    static final int black = 0;
    static final int red  = 1;

    K getKey();
    void setKey(K key);

    V getValue();
    void setValue(V value);

    void setRight(IRBNode<K, V> right);
    IRBNode<K, V> getRight();

    void setLeft(IRBNode<K, V> left);
    IRBNode<K, V> getLeft();

    void setParent(IRBNode<K, V> parent);
    IRBNode<K, V> getParent();

    int getColor();
    void setColor(int color);

}

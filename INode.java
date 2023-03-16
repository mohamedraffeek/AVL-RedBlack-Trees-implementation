public interface INode <K extends Comparable<K>, V>{

    static final int black = 0;
    static final int red  = 1;

    K getKey();
    void setKey(K key);

    V getValue();
    void setValue(V value);

    void setRight(INode<K, V> right);
    INode<K, V> getRight();

    void setLeft(INode<K, V> left);
    INode<K, V> getLeft();

    void setParent(INode<K, V> parent);
    INode<K, V> getParent();

    int getColor();
    void setColor(int color);


}

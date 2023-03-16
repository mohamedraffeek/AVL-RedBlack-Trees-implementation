package RED_BLACK;

public interface INode<K extends Comparable<K>>{


    K getKey();
    void setKey(K key);

    void setRight(INode<K> right);
    INode<K> getRight();

    void setLeft(INode<K> left);
    INode<K> getLeft();

    void setParent(INode<K> parent);
    INode<K> getParent();


}

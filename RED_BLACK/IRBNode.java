package RED_BLACK;

public interface IRBNode<K extends Comparable<K>>{


    K getKey();
    void setKey(K key);

    void setRight(IRBNode<K> right);
    IRBNode<K> getRight();

    void setLeft(IRBNode<K> left);
    IRBNode<K> getLeft();

    void setParent(IRBNode<K> parent);
    IRBNode<K> getParent();


}

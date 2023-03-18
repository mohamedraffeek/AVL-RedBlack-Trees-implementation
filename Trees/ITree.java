package Trees;

/*generic interface*/
public interface ITree<K extends Comparable<K>> {

    String insert(K key);

    String delete(K key);

    // public RBNode<K> search(RBNode<K> root, K key);

    int getSize();

    int getHeight();
}

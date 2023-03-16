package Trees;

/*generic interface*/
public interface ITree<K extends Comparable<K>, V> {


    void insert(Comparable key);

    boolean delete();

    public INode search(INode root, K key);

    int getSize();

    int getHeight();
}

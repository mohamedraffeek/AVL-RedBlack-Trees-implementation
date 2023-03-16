package RED_BLACK;

/*generic interface*/
public interface IRedBlack<K extends Comparable<K>, V> {


    void insert(Comparable key);

    boolean delete();

    public IRBNode search(IRBNode root, K key);

    int getSize();

    int getHeight();
}

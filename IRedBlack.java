/*generic interface*/
public interface IRedBlack<K extends Comparable<K>, V> {

    void insert();

    boolean delete();

    public INode search(INode root,K key);

    int getSize();

    int getHeight();
}

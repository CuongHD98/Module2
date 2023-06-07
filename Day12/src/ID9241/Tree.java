package ID9241;

public interface Tree<E> {
    public boolean insert(E e);
    public void postorder();
    public int getSize();
}

import java.util.PriorityQueue;
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> extends PriorityQueue<E> {
    protected Vector<E> data; // orden según heap

    public VectorHeap() {
        data = new Vector<E>();
    }

    public VectorHeap(Vector<E> v) {
        int i;
        data = new Vector<E>(v.size());
        for (i = 0; i < v.size(); i++) { // agregar elementos a heap
            add(v.get(i));
        }
    }

    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    protected static int left(int i) {
        return 2 * i + 1;
    }

    protected static int right(int i) {
        return 2 * (i + 1);
    }

    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    protected void percolateDown(int root) {
        E value = data.get(root);
        while (root < data.size() / 2) { // para si la raíz es una hpja
            int child = left(root);
            if ((child < data.size() - 1)
                    && (data.get(child).compareTo(data.get(child + 1)) > 0)) {
                child++; // hijo derecho menor
            }
            if (value.compareTo(data.get(child)) <= 0) {
                break; // ubicacion encontrada
            }
            data.set(root, data.get(child));
            root = child; // continua hacia abajo
        }
        data.set(root, value);
    }

    @Override
    public boolean add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
        return false;
    }

    @Override
    public E remove() {
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        percolateDown(0);
        return minVal;
    }

    @Override
    public E peek() {
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }
}

package uvg.edu.gt;

import java.util.Comparator;

// Clase VectorHeap que implementa PriorityQueue para manejar una cola con prioridad basada en un Heap.
class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private java.util.Vector<E> data;
    private Comparator<E> comparator;

    public VectorHeap() {
        data = new java.util.Vector<>();
    }

    public VectorHeap(Comparator<E> comparator) {
        this();
        this.comparator = comparator;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (comparator != null ? comparator.compare(value, data.get(parent)) < 0 : value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    private void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                        (comparator != null ? comparator.compare(data.get(childpos + 1), data.get(childpos)) < 0 : data.get(childpos + 1).compareTo(data.get(childpos)) < 0))
                    childpos++;
                if (comparator != null ? comparator.compare(data.get(childpos), value) < 0 : data.get(childpos).compareTo(value) < 0)
                    data.set(root, data.get(childpos));
                else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
            root = childpos;
        }
    }

    @Override
    public boolean add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
        return false;
    }

    @Override
    public boolean offer(E value) {
        add(value);
        return true;
    }

    @Override
    public E remove() {
        E maxVal = getMax();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return maxVal;
    }

    @Override
    public E poll() {
        if (data.isEmpty()) return null;
        return remove();
    }

    @Override
    public E element() {
        return getMax();
    }

    @Override
    public E peek() {
        if (data.isEmpty()) return null;
        return getMax();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void clear() {
        data.clear();
    }

    private E getMax() {
        if (data.isEmpty()) return null;
        return data.get(0);
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }
}

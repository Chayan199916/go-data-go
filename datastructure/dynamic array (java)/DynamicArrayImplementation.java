import java.util.Iterator;

public class DynamicArrayImplementation<T> implements Iterable {

    private T array[];
    private int count;
    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArrayImplementation() {

        array = (T[]) new Object[1];
        count = 0;
        size = 1;

    }

    public void add(T element) {

        if (count == size) {

            growSize();

        }

        array[count++] = element;

    }

    @SuppressWarnings("unchecked")
    public void growSize() {

        T temp[] = null;
        temp = (T[]) new Object[2 * size];

        for (int i = 0; i < count; i++)
            temp[i] = array[i];

        array = temp;
        size *= 2;

    }

    @SuppressWarnings("unchecked")
    public void shrinkSize() {

        T temp[] = null;
        temp = (T[]) new Object[count];

        for (int i = 0; i < count; i++)
            temp[i] = array[i];

        array = temp;
        size = count;

    }

    public void addAt(int index, T element) {

        if (count == size) {

            growSize();

        }

        for (int i = count - 1; i >= index; i--) {

            array[i + 1] = array[i];

        }

        array[index] = element;
        count++;

    }

    public boolean remove(Integer element) {

        for (int i = 0; i < count; i++) {

            if (array[i].equals(element)) {

                removeAt(i);
                return true;

            }

        }

        return false;

    }

    public T removeAt(int index) {

        T data = null;

        if (index > 0 && index < count) {

            data = array[index];

            for (int i = index; i < count - 1; i++) {

                array[i] = array[i + 1];

            }

            array[--count] = null;

        }
        return data;

    }

    public int size() {

        return count;

    }

    public boolean isEmpty() {

        return size() == 0;

    }

    public int indexOf(T element) {

        for (int i = 0; i < count; i++) {

            if (array[i].equals(element)) {

                return i;

            }

        }

        return -1;

    }

    public boolean contains(T element) {

        return indexOf(element) != -1;

    }

    public static void main(String[] args) {

        DynamicArrayImplementation<Integer> myArray = new DynamicArrayImplementation<Integer>();

        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);

        myArray.remove(3);
        myArray.removeAt(1);
        myArray.addAt(1, 6);

        for (Object object : myArray) {
            
            System.out.println(object);

        }

    }

    @Override
    public Iterator<T> iterator() {
        
        return new java.util.Iterator<T>(){

            int index = 0;

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return index < size();
            }
            @Override
            public T next() {
                // TODO Auto-generated method stub
                return array[index++];
            }

        };
        
    }

}
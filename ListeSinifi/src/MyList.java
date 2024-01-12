import java.util.Arrays;

public class MyList<T> {

    private int capacity;
    public T[] liste;
    public int currentAmount;

    public MyList() {

        liste = (T[]) new Object[10];
        capacity = 10;

    }

    public MyList(int capacity) {
        this.capacity = capacity;
        setCapacity(capacity);
        liste = (T[]) new Object[setCapacity(capacity)];
    }

    public int size() {
        int amount = 0;
        for (int i = 0; i < getCapacity(); i++) {
            if (this.liste[i] == null) {
                break;
            }
            amount++;
        }
        return amount;
    }

    public void add(T data) {
        if (size() == capacity) {
            T[] tempList = (T[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                tempList[i] = liste[i];
            }
            liste = (T[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                liste[i] = tempList[i];
            }

            this.capacity = this.capacity * 2;
        }
        for (int i = size(); i < getCapacity(); i++) {
            if (this.liste[i] == null) {
                this.liste[i] = data;
                break;
            }
        }
    }

    public int getCurrentAmount() {
        int amount = 0;
        for (int i = 0; i < getCapacity(); i++) {
            if (this.liste[i] == null) {
                break;
            }
            amount++;
        }
        return amount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getCapacity() {
        return capacity;
    }

    public int setCapacity(int capacity) {

        return this.capacity;
    }

    public T[] getListe() {
        return liste;
    }

    public void setListe(T[] liste) {
        this.liste = liste;
    }

    public void remove(int index) {
        if (liste[index] != null) {
            for (int i = index; i < liste.length - 1; i++) {
                liste[i] = liste[i + 1];
            }
        } else if (index < liste.length || index >= liste.length) {
            liste[index] = null;
        }
    }

    public int get(int index) {
        return (int) liste[index];
    }

    public int set(int index, T data) {
        liste[index] = data;
        return (int) liste[index];
    }

    @Override
    public String toString() {

        return Arrays.toString(liste);
    }

    public int indexOf(T data) {
        for (int i = 0; i < liste.length; i++) {
            if (data.equals(liste[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        for (int i = 0; i < liste.length; i++) {
            if (liste[i] != null) {
                return false;
            }
        }
        return true;
    }

    public int lastIndexOf(T data) {
        for (int i = liste.length - 1; i > 0; i++) {
            if (data == liste[i]) {

                return i;
            }
            break;
        }
        return -1;
    }

    public Object[] toArray() {

        return liste.clone();
    }

    public MyList<T> subList(int start, int finish) {

        MyList<T> altListe = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            altListe.add(liste[i]);
        }
        return altListe;
    }

    public boolean contains(T data) {
        for (int i = 0; i < liste.length; i++) {
            if (liste[i] == data) {
                return true;
            }
        }
        return false;
    }

    public void clear() {

        liste = (T[]) new Object[0];
    }
}
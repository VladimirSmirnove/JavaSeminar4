import java.util.*;

public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;
        
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
        }
        
    public BinaryHeap(int capacity) {
        this.currentSize = 0;
        array = (T[]) new Comparable[capacity ++];
        }
        
    public BinaryHeap(T[] array) {
        currentSize = array.length;
        this.array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (T arr : array) {
        array[i++] = arr;
        }
        buildHead();
        }
        
    private void buildHead() {
        for (int i = currentSize/2; i >0 ; i--) {
        percolateDown(i);
            }
        }
        
    private void enlargeArray(int newSize) {
        T[] old = array;
        array = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
            }
        }
        
    public void insert(T x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
            }
            int hole=++currentSize;
            array[0]=x;  
               percolateUp(hole,array[0]);
            }
        
        
    private void percolateUp(int hole,T x){
        for ( ;  x.compareTo(array[hole/2])<0 ;hole /= 2) {
            array[hole]=array[hole/2];
            }
            array[hole]=x;
            }
        
    public T deleteMin(){
        if (isEmpty()){
            System.out.println("Куча пуста");
        }
            T min = findMin();
            array[1]=array[currentSize--];
            percolateDown(1);
            return min;
        }
    private void percolateDown(int hole) {
        int child;
        T temp = array[hole];
        for ( ; hole*2<=currentSize ;hole=child ) {
                child=hole*2;
            if (child!=currentSize && array[child+1].compareTo(array[child])<0){
                child++;
            }
                if (array[child].compareTo(temp)<0){
                    array[hole]=array[child];
                } else
                    break;
                }
                array[hole]=temp;
            }
    public T findMin(){
        if (isEmpty()){
        System.out.println("Куча пуста");
        }
        return array[1];
        }
    public void print(){
        for (int i = 1; i <currentSize ; i++) {
            System.out.println(array[i]);
            }
        }
    private boolean isEmpty() {
        return currentSize==0;
        }
    public static void main( String [ ] args )
    {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
            heap.insert(-2);
            heap.insert(14);
            heap.insert(16);
            heap.insert(19);
            heap.insert(21);
            heap.insert(19);
            heap.insert(68);
            heap.insert(65);
            heap.insert(26);
            heap.insert(-10);
            heap.insert(31);
            System.out.println("-----");
            while (!heap.isEmpty()){
                System.out.print(heap.deleteMin() + " ");
            }
        
        }
    }
        

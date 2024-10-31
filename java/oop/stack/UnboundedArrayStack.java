package oop.stack;

public class UnboundedArrayStack<E> implements Stack<E> {
    private  Object[] data;
    private int topIndex;
    public static final int MIN_CAP=10;


    public UnboundedArrayStack(final int initCapacity){
        data=new Object[Math.max(MIN_CAP,initCapacity)];
        topIndex=0;
    }
    @Override
    public void push(E item) {

        if(topIndex== data.length)
            reallocate();
        data[topIndex] = item;
        topIndex++;
    }

    private void reallocate() {
        Object[] newData = new Object[data.length * 2];
        // copia gli elementi nel nuovo array
        System.arraycopy(data, 0, newData, 0, data.length);
        data=newData;
    }



    @Override
    public E pop() {

        if (isEmpty()) throw new EmptyStackException();
        topIndex--;
        return (E) data[topIndex];
    }

    @Override
    public E top() {
        if (isEmpty()) throw new EmptyStackException();
        return (E) data[topIndex - 1];
    }

    @Override
    public boolean isEmpty() {
        return topIndex==0;
    }

    @Override
    public boolean isFull() {
        return topIndex==Integer.MAX_VALUE;
    }

    @Override
    public int size() {
        return topIndex;
    }

}

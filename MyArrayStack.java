/**
 * 功能概要：数组实现栈 
 *
 * @author linbingwen
 * @since  2015年8月29日
 */
public class MyArrayStack<T> implements MyStack<T> {

    private Object[] objs = new Object[2];

    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < objs.length; i++) {
            objs[i] = null;
            size--;
        }
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean push(T data) {
        if(size == (objs.length-1)){                   //没懂 扩容的
            Object[] temp = new Object[objs.length*2];
            for (int i = 0; i < objs.length; i++) {
                temp[i]=objs[i];
            }
            objs= temp;
            System.out.println("now the length is "+objs.length);
        }
        objs[size++]=data;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        return size == 0?null:(T) objs[(size--)-1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        return size == 0?null:(T) objs[size];
    }

}  
/**
 *@author Matthew Scaccia
 *course CIS303
 *@since 3/29/2020
 *@assignment 4b
 *description: AStack data structure adapted from Clifford Shaffers Data Structures and Algorithim Analysis, Chapter 4.2.1
 */
package ArrayStack;
 public class AStack<E> implements StackADT<E>{

    private static final int defaultSize = 10;

    private int maxSize;
    private int top;
    private E [] listArray;

    /**
     * Constructor with default size
     */
    public AStack(){
        this(defaultSize);
    }

    /**
     * Constructor that takes a size parameter.
     * @param size the size of the stack to be created
     */
    @SuppressWarnings("unchecked")
    public AStack(int size){
        maxSize = size;
        top = 0;
        listArray = (E[]) new Object[size];
    }

    /**
     * Method clears the stack
     */
    public void clear(){
        top = 0;
    }

    /**
     * Method pushes element onto the stack
     * @param element element to be pushed onto the stack
     */
    public void push(E element){
        assert top != maxSize : "Stack is full";
        listArray[top++] = element;
    }

    /**
     * Method pop's the top element off the stack, provided it is not empty
     * @return the top element from the stack
     */
    public E pop(){
        assert top != 0 : "Stack is empty";
        return listArray[--top];
    }

    /**
     * Method 'peeks' and returns the top element on the stack without pop'ing
     * @return the top element on the stack, without pop'ing it
     */
    public E topValue(){
        assert top != 0 : "Stack is empty";
        return listArray[top-1];
    }

    /**
     * Method returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    public int length(){
        return top;
    }
 }

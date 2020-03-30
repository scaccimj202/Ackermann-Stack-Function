/**
 *@author Matthew Scaccia
 *course CIS303
 *@since 3/29/2020
 *@assignment 4b
 *description: Stack interface adapted from Clifford Shaffers Data Structures and Algorithim Analysis, Chapter 4.2.1
 */

 public interface StackADT<E>{

    /**
     * Method that reinitializes the stack. User is responsible for reclaiming
     * the storage used by the stack elements.
     */
    public void clear();

    /**
     * Method pushes an element onto the top of the stack
     * @param element the element to be pushed onto the stack
     */
    public void push(E element);

    /**
     * Method removes and returns the element at the top of the stack
     * @return the element at the top of the stack
     */
    public E pop();

    /**
     * Method retruns a copy of the top element or "peek" 
     * @return a copy of the top element on the stack
     */
    public E topValue();

    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    public int length();
 }



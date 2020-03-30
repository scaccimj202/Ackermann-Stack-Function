/**
 *@author Matthew Scaccia
 *course CIS303
 *@since 3/29/2020
 *@assignment 4b
 *description: LStack data structure adapted from Clifford Shaffers Data Structures and Algorithim Analysis, Chapter 4.2.2
 */

 public class LStack<E> implements StackADT<E>{
     private Node<E> top;
     private int size;

     /**
      * Constructors, for the LStack both ignore the size input and 
      *default to zero
      */
     public LStack(){
         top = null;
         size = 0;
     }

     public LStack(int size_){
         top = null;
         size = 0;
     }

     /**
      * Method clears the stack
      */
     public void clear(){
         top = null; 
         size = 0;
     }

     /**
      * Method pushes element onto the stack
      *@param element element to be pushed onto the stack
      */
     public void push(E element){
         top = new Node<E>(element, top);
         size++;
     }

     /**
      * Method pop's the top element of the stack and returns it
      *@return element at the top of the stack
      */
     public E pop(){
         assert top != null : "Stack is empty";
         E element = top.getElement();
         top = top.getNext();
         size--;
         return element;
     }

     /**
      * Method 'peeks' the top of the stack and returns the element 
      *without pop'ing
      *@return the top element on the stack without pop'ing
      */
     public E topValue(){
        assert top != null : "Stack is empty";
        return top.getElement();
     }

     /**
      * Method returns the size of the stack
      *@return the size of the stack
      */
     public int length(){
         return size;
     }
 }
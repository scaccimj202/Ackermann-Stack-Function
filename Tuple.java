/**
 *description: 3-Tuple class used to track Ackermann values
 * m, n, and p or the trailing operation bit.
 * See: https://en.wikipedia.org/wiki/Ackermann_function
 * 
 *@author Matthew Scaccia
 *course CIS303
 *@since 3/29/2020
 *@assignment 4b
 */

public class Tuple{

    private long m;
    private long n;
    /**
     * operation is either a 1 or a 0. The goal being to simulate calls.
     * If 1 we will assume we're resuming from a call and creating
     * a new tuple(coming down from an Ackermann stack)
     * If 0 we will simply be computing up the Ackermann stack
     */
    private int operation; 

    /**
     * Constructor for Tuple takes m and n values and operation
     * @param m_ m value to be passed in
     * @param n_ n value to be passed in
     * @param op_ operation 'bit' to be passed in
     */
    public Tuple(long m_, long n_, int op_){
        setM(m_);
        setN(n_);
        setOp(op_);
    }

    /**
     * Method sets the m value in the tuple
     * @param m_ value of m to be set
     */
    private void setM(long m_){
        m = m_;
    }

    /**
     * Method sets the n value in the tuple
     * @param n_ value of n to be set
     */
    public void setN(long n_){
        n = n_;
    }

    /**
     * Method sets the operation bit in the tuple
     * @param op_ a 1 indicating we are coming down the stack or a 
     * 0 indicating we are adding to the stack
     */
    private void setOp(int op_){
        operation = op_;
    }

    /**
     * Method returns the value of m
     * @return the value of m
     */
    public long getM(){
        return m;
    }

    /**
     * Method returns the value of n
     * @return the value of n
     */
    public long getN(){
        return n;
    }

    /**
     * Method returns the value of operation
     * @return the value of the operation, 1 meaning resume, 0 meaning call
     */
    public int getOp(){
        return operation;
    }
}
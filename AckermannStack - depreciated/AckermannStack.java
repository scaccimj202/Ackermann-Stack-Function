/**
 *@author Matthew Scaccia
 *course CIS303
 *@since 3/29/2020
 *assignment 4b
 *description: Ackermann function, remade with a stack to simulate recursion.
 *This program was written as test code before integration with Ackermann.java
 *@deprecated 3/31/2022
 */


public class AckermannStack{
    public static void main(String[] args){
        long m = 3;
        long n = 8;
        long startTime = System.currentTimeMillis();
        long ack = computeAckermann(m, n);
        long endTime = System.currentTimeMillis();
        System.out.println("Ackermann (" + m + ", " + n +") results in: "+
        ack + ". Computed in " + (endTime - startTime) + " milliseconds.");
    }

    public static long computeAckermann(long m, long n){
        LStack<Tuple> stack = new LStack<Tuple>();
        long result = 0;
        stack.push(new Tuple(m,n,0));
        while(stack.length() > 0){
            Tuple temp = stack.pop();
            if(temp.getOp() == 1)
                stack.push(new Tuple(temp.getM(), result, 0));
            if(temp.getM() == 0)
                result = temp.getN() + 1;
            else if(temp.getN() == 0)
                stack.push(new Tuple(temp.getM()-1, 1, 0));
            else{
                stack.push(new Tuple(temp.getM()-1, 0, 1));
                stack.push(new Tuple(temp.getM(), temp.getN()-1, 0));
            }
        }
        return result;
    }
}

/**
 *@author Matthew Scaccia
 *course CIS303
 *@since 3/29/2020
 *@assignment 4b
 *description: Ackermann function, remade with a stack to simulate recursion.
 */

import java.util.concurrent.TimeUnit;

public class AckermannStack{
    public static void main(String[] args)throws InterruptedException{
        System.out.println(computeAckermann(0, 0));
    }

    public static int computeAckermann(int m, int n) throws InterruptedException {
        LStack<Tuple> stack = new LStack<Tuple>();
        int result = 0;
        stack.push(new Tuple(m,n,0));
        while(stack.length() > 0){
            Tuple temp = stack.pop();
            if(temp.getP() == 1)
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

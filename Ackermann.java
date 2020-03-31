
/**
 *  Calculate the Ackermann function A(M, N) using a straightforward
 *  recursive program.
 *
 * Compilation:  javac Ackermann.java
 *  Execution:    java Ackermann M N
 *
 *  % java Ackermann 3 8
 *  2045
 *
 *  % java Ackermann 3 9
 *  StackOverflowError
 *
 * Updated 06 March 2020 by  L. Grabowski
 * Downloaded from:
 *    https://introcs.cs.princeton.edu/java/53universality/Ackermann.java
 *
 * @author L. Grabowski
 * @email grabowlm@potsdam.edu
 * @course CIS 303 Algorithm Analysis and Design
 * Assignment 4b
*/
import java.io.File;
import java.io.PrintStream;
import LinkedStack.LStack;

public class Ackermann {

    private static boolean output = false;
    private static boolean toFile = true;

    public static void main(String[] args) throws Exception {


        PrintStream iterative = new PrintStream(makeFile("Iterative.txt"));
        iterative.println("Time \t Data Set");
        PrintStream recursive = new PrintStream(makeFile("Recursive.txt"));
        recursive.println("Time \t Data Set");

        runExperiment(iterative, recursive);


    }
    
    /**
     * Method computes the Ackermann function recursively. 
     * Source:https://introcs.cs.princeton.edu/java/53universality/Ackermann.java
     * Be careful with large values!
     * See: https://en.wikipedia.org/wiki/Ackermann_function.
     * @param m long value of m
     * @param n long value of n
     * @return Ackermann(m, n)
     */
    public static long ackermann(long m, long n) {
        if (m == 0) return n + 1;
        if (n == 0) return ackermann(m - 1, 1);
        return ackermann(m - 1, ackermann(m, n - 1));
    }

    /**
     * @author Matthew Scaccia
     * @since 3/31/2020
     *Method computes the Ackermann function 
     *iterativly with a stack simulating recursion.
     *Be careful with large values!
     *See: https://en.wikipedia.org/wiki/Ackermann_function.
     * @param m long value of m
     * @param n long value of n
     * @return Ackermann(m, n)
     */
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

    /**
     * Method times the recursive implementation of Ackermann 
     * @param m m value
     * @param n n value
     */
    public static void timeAckRecur(long m, long n, 
        PrintStream name_, int setNum){
        long startTime = System.currentTimeMillis();
        long ack = ackermann(m, n);
        long endTime = System.currentTimeMillis();
        long totalTime = (endTime = startTime);
        if(output == true){
            System.out.println("Recursive version of Ackermann ("
             + m + ", " + n +") results in: "+ ack + 
            ". Computed in " + (endTime - startTime) + " milliseconds.");
        }
        if(toFile == true){
            name_.println(endTime + "\t" + setNum);
        }
    }

    /**
     * Method times the iterative implementation of Ackermann
     * @param m m value
     * @param n n value
     */
    public static void timeAckIter(long m, long n,
     PrintStream name_, int setNum){
        long startTime = System.currentTimeMillis();
        long ack = computeAckermann(m, n);
        long endTime = System.currentTimeMillis();
        long totalTime = (endTime = startTime);

        if(output == true){
            System.out.println("Iterative version of Ackermann ("
            + m + ", " + n +") results in: "+
            ack + ". Computed in " + (endTime - startTime) + " milliseconds.");
        }
        if(toFile == true){
            name_.println(endTime + "\t" + setNum);
        }
    }

    /**
     * Method makes a new file in the 'Experiment Data' sub directory
     * @param fileName_ name of the file
     * @return file to be written to
     */
    private static File makeFile(String fileName_){
        File dir = new File("/Experiment Data");
        return new File(dir, fileName_);
    }

    private static void runExperiment(PrintStream iterative,
     PrintStream recursive){

        timeAckRecur(m, n, recursive, setNum);
        timeAckIter(m, n, iterative, setNum);
    }

    private static void makeData(){
        
    }
}

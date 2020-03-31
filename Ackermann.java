
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
import ArrayStack.AStack;

public class Ackermann {

    private static boolean output = false;
    private static boolean toFile = true;
    private static boolean assignmentTest = false;

    public static void main(String[] args) throws Exception {

        
        PrintStream iterative = new PrintStream(makeFile("Iterative.txt"));
        iterative.println("Time \t Set Number");
        PrintStream recursive = new PrintStream(makeFile("Recursive.txt"));
        recursive.println("Time \t Set Number");

        if(assignmentTest == true) runExperiment(iterative, recursive);
        
        else{    
            long M = Long.parseLong(args[0]);
            long N = Long.parseLong(args[1]);
            
            output = true;

            timeAckRecur(M, N, recursive, 1);
            timeAckIter(M, N, iterative, 1);
        }
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
     * and then writes its time in milliseconds to a file
     * @param m m value
     * @param n n value
     * @param name_ name of the printstream we're writing to
     * @param setNum the set number of the data being calculated
     */
    public static void timeAckRecur(long m, long n, 
        PrintStream name_, int setNum){
        long startTime = System.currentTimeMillis();
        long ack = ackermann(m, n);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if(output == true){
            System.out.println("Recursive version of Ackermann ("
             + m + ", " + n +") results in: "+ ack + 
            ". Computed in " + totalTime + " milliseconds.");
        }
        if(toFile == true){
            name_.println(totalTime + "\t" + setNum);
        }
    }

    /**
     * Method times the iterative implementation of Ackermann
     * and then writes its time in milliseconds to a file
     * @param m m value
     * @param n n value
     * @param name_ name of the printstream we're writing to
     * @param setNum the set number of the data being calculated
     */
    public static void timeAckIter(long m, long n,
     PrintStream name_, int setNum){
        long startTime = System.currentTimeMillis();
        long ack = computeAckermann(m, n);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        if(output == true){
            System.out.println("Iterative version of Ackermann ("
            + m + ", " + n +") results in: "+
            ack + ". Computed in " + totalTime + " milliseconds.");
        }
        if(toFile == true){
            name_.println(totalTime + "\t" + setNum);
        }
    }

    /**
     * Method makes a new file in the 'Experiment Data' sub directory
     * @param fileName_ name of the file
     * @return file to be written to
     */
    private static File makeFile(String fileName_){
        File dir = new File("Experiment Data");
        return new File(dir, fileName_);
    }

    /**
     * Method runs the experiment by creating an ArrayList Stack of 15 values
     * representing the 15 data sets we're using. Then it pops each value
     * into a temporary Tuple object that is fed into the testing methods.
     * Each testing method simply times it's version of the algo and writes
     * to a file the time in milliseconds and the set number.
     * @param iterative PrintStream to file
     * @param recursive PrintStream to file
     */
    private static void runExperiment(PrintStream iterative,
     PrintStream recursive){
        AStack<Tuple> expStack = makeData(new AStack<Tuple>(15));
        if(output == true) testMakeData(expStack);
        while(expStack.length() > 0){
            Tuple exp = expStack.pop();
            timeAckRecur(exp.getM(), exp.getN(), recursive, exp.getOp());
            timeAckIter(exp.getM(), exp.getN(), iterative, exp.getOp());
        }
    }

    /**
     * Method loads the pre determined set values into an ArrayList Stack
     * of Tuples(m, n, set#[replacing operation])
     * @param expStack the experiment stack we're using to load Tuples into
     */
    private static AStack<Tuple> makeData(AStack<Tuple> expStack){
        int i = 0;
        int setNum = 15;
        while(i < 4){
            if(i == 0){
                for(int j = 8; j > 0; j--){
                    expStack.push(new Tuple(3, j, setNum));
                    setNum --;
                }
            }
            if(i == 1){
                for(int j = 20; j >= 0; j-=10){
                    expStack.push(new Tuple(2, j, setNum));
                    setNum --;
                }
            }
            if(i == 2){
                for(int j = 20; j >= 0; j-=10){
                    expStack.push(new Tuple(1, j, setNum));
                    setNum --;
                }
            }
            if(i == 3){
                expStack.push(new Tuple(0, 0, setNum));
                setNum ++;

            }
            i++;
        }
        return expStack;
    }
    
    /**
     * Method simply pop's values off the stack and reads them. 
     * Was used to validate the data going into the stack.
     * @param expStack experiment stack
     */
    private static void testMakeData(AStack<Tuple> expStack){
        while(expStack.length()>0){
            Tuple exp = expStack.pop();
            System.out.println(
                "Set number: " + exp.getOp() + 
                " (" + exp.getM() + ", " + 
                exp.getN() + ")"
            );
        }
    }
}

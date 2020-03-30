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

public class Ackermann {
    public static void main(String[] args) {
        long M = Long.parseLong(args[0]);
        long N = Long.parseLong(args[1]);
        System.out.println(ackermann(M, N));
    }
    
    public static long ackermann(long m, long n) {
        if (m == 0) return n + 1;
        if (n == 0) return ackermann(m - 1, 1);
        return ackermann(m - 1, ackermann(m, n - 1));
    }
}

/**
 * I'm back fellas.
 *
 * This here is an extremely stupid algorithm that takes user input,
 * determines the series based off the a coefficient, x coefficient,
 * and the power of the binomial
 *
 * I'd probably have the expression formatted like so: (x+a)^n
 * I'll have the user fill out x's coefficient and a, hopefully leaving this algorithm to do the magic.
 *
 * I'm so cooked.
 */

package pascal;

import java.util.Scanner;

public class pascal {
    /**
     * Some solution I found online instead of using an extreme amount of arrays;
     * This finds a factorial, whatever that means.
     * @param n Integer to use
     * @return The factorial found
     */
    public static int factorial(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }

        return f;
    }

    /**
     * Prints a binomial series
     * @param A Coefficient of a
     * @param X Coefficient of x
     * @param n Power of expression
     * @return Array of coefficients for expanded terms
     */
    public static int[] series(int A, int X, int n) {
        int[] coefficient = new int[n+1];

        // calculates the value of n
        int nFact = factorial(n);

        for (int i = 0; i < n + 1; i++) {
            // calculates the value of nCr
            int niFact = factorial(n - i);
            int iFact = factorial(i);

            // calculates the powers
            int aPow = (int)Math.pow(A, n - i);
            int xPow = (int)Math.pow(X, i);

            // puts series into an integer array
            coefficient[i] = ((nFact * aPow * xPow) / (niFact * iFact));
        }

        return coefficient;
    }

    /**
     * Gets input; Prints expanded binomial expression.
     * @param args Java stuff
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // print formulas
        System.out.println("Formula: (x+a)^n ");

        // get x
        System.out.println("x coefficient: ");
        int x = scanner.nextInt();

        // get a
        System.out.println("a: ");
        int a = scanner.nextInt();

        // get n
        System.out.println("n: ");
        int n = scanner.nextInt();

        // get the series and put it into an array
        int[] ans = series(a, x, n);

        // print the expanded form
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            // determine the sign (plus or minus)
            String operation = (ans[i] >= 0 && i != 0) ? " + " : " - ";
            int absCoefficient = Math.abs(ans[i]);

            // create the term
            String term = absCoefficient + "x^" + (n - i);

            // append term
            if (i == 0) {
                result.append(absCoefficient).append("x^").append(n - i);
            } else {
                result.append(operation).append(term);
            }
        }

        // show the result
        System.out.println("Expanded form: " + result);
    }
}
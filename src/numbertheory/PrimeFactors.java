package numbertheory;

/*
* Based on the fundamental theorem of arithmetic:
* any intiger number can be represented by a combination of primes:
* n = p1^a1 * p2^a2 * ... * pn^an
* where p is prime and aj are integers. Example:
* 84 = 2^2*3^1*7^1
* the numer of prime factors of any given integer is:
* T(n) = MULT(ai + 1) from 1 to k,
* aqui MULT es el operador de producto generalizado.
* */
public class PrimeFactors {
    public static void main(String... args) {
        int n = 315;
        primeFactors(n);
        primeFactorsImproved(n);
    }
/*
* Time Complexity: This Approach is best for all
* composite numbers and achieves O(log n) but is O(n) otherwise.
Auxiliary Space: O(1)
*
* */
    static void primeFactorsImproved(int n) {
        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                System.out.println(c + " ");
                n /= c;
            } else {
                c++;
            }
        }
    }

    /*
    For the below algorithm
    * Time Complexity: O(n^(1/2) log n)
* Since outer loop runs for sqrt(n) times and for every loop
* we are dividing n by i which gives us logarithmic time complexity.
Auxiliary Space: O(1)
    * */
    static void primeFactors(int n) {
        //prints the number of 2s that divide n
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n/=2;
        }
        //n must be odd at this point. So we can skip
        //one element (Note that i = i + 2) - that is
        //the counter increases by 2...
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            //while i  divides n, print i and divide n.
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
        //This condition handles cases when n
        //is a prime greater than 2..
        if (n > 2) {
            System.out.println(n);
        }
    }
}

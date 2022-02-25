package numbertheory;

/*
* Primality test based on the Fermat's Little Theorem
* Let n be prime then any a such that 1 < a < n - 1 is that
* a^(n-1)%n = 1
*
* based on above we have the following algorithm
*
* // Higher value of k indicates probability of correct
// results for composite inputs become higher. For prime
// inputs, result is always correct
1)  Repeat following k times:
      a) Pick a randomly in the range [2, n - 2]
      b) If gcd(a, n) ≠ 1, then return false
      c) If an-1 &nequiv; 1 (mod n), then return false
2) Return true [probably prime].
* */
public class PrimalityTest2 {
    /* Iterative Function to calculate
   // (a^n)%p in O(logy) */
    static int power(int a,int n, int p)
    {
        // Initialize result
        int res = 1;

        // Update 'a' if 'a' >= p
        a = a % p;

        while (n > 0)
        {
            // If n is odd, multiply 'a' with result
            if ((n & 1) == 1)
                res = (res * a) % p;

            // n must be even now
            n = n >> 1; // n = n/2
            a = (a * a) % p;
        }
        return res;
    }

    // If n is prime, then always returns true,
    // If n is composite than returns false with
    // high probability Higher value of k increases
    //  probability of correct result.
    static boolean isPrime(int n, int k)
    {
        // Corner cases
        if (n <= 1 || n == 4) return false;
        if (n <= 3) return true;

        // Try k times
        while (k > 0)
        {
            // Pick a random number in [2..n-2]
            // Above corner cases make sure that n > 4
            int a = 2 + (int)(Math.random() % (n - 4));

            // Fermat's little theorem
            if (power(a, n - 1, n) != 1)
                return false;

            k--;
        }

        return true;
    }

    // Driver Program
    public static void main(String args[])
    {
        int k = 3;
        if(isPrime(11, k))
            System.out.println(" true");
        else
            System.out.println(" false");
        if(isPrime(15, k))
            System.out.println(" true");
        else
            System.out.println(" false");
    }
}

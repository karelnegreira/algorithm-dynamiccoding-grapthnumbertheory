package numbertheory;
/*
* Simply method for obtaining the primality of a given integer number
*
* EL metodo podria mejorar si en lugar de evaluar hasta n, evaluasemos su raiz cuadrada (sqrt(n))
*
* Puede observarse ademas que los numberos primos son de la forma 6k + 1 con la excepcion de 2 y 3.
*
* OUTPUT:
* true
  false
  true
  *
  * O(n)
  *
* */
public class PrimalityTest1 {

    public static void main(String... main) {
        System.out.println(isPrime(11));
        System.out.println(isPrime(4));
        System.out.println(isPrime(17));
    }

    /*Basic primality test for a number - brute force method*/
    static boolean isPrime(int n) {
        //corner case
        if (n <= 1) {
            return false;
        }
        //check from 2 .. n - 1
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

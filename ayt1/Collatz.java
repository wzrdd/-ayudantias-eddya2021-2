import java.util.*;

// Solución a https://www.hackerrank.com/contests/tarea-0-1628654405/challenges/conjetura-de-collatz-4-1
public class Collatz {
    // Solución recursiva
    static void collatz_rec(long n) {
        System.out.print(n + " ");
        if(n == 1) return;
        else if(n % 2 == 0) collatz_rec(n/2);
        else collatz_rec(n*3 + 1);
    }

    // Solución iterativa
    static void collatz_it(long n){
        long aux = n;
        while(aux != 1){
            System.out.print(aux + " ");
            if((aux % 2 == 0)){
                aux /= 2;
            } else{
                aux = aux * 3 + 1;
            }
        }
        System.out.println("1");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        collatz_it(n);
        collatz_rec(n);
    }
}

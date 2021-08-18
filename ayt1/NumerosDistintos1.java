import java.util.*;

// Solución a https://www.hackerrank.com/contests/tarea-0-1628654405/challenges/numeros-distintos
// usando set.
public class NumerosDistintos2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(sc.nextInt());
        }

        System.out.println(set.size());
    }
}

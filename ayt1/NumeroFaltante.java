import java.util.*;

// Solución a https://www.hackerrank.com/contests/tarea-0-1628654405/challenges/numero-faltante
public class NumeroFaltante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Suma total se puede calcular por fórmula o si no se conoce la fórmula
        // se puede calcular dentro del for usando los índices.
        // int suma_total = n*(n+1)/2
        int suma_total = 0;

        // suma_input es la suma de los números que me entregan
        int suma_input = 0;

        for(int i = 0; i < n - 1; i++){
            suma_total += i+1; // Si se calcula por fórmula, esta línea no es necesaria.
            suma_input += sc.nextInt();
        }

        suma_total += n; // Si se calcula por fórmula, esta línea no es necesaria.

        System.out.println(suma_total - suma_input);
    }
}

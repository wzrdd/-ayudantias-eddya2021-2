import java.util.*;

// Solución a https://www.hackerrank.com/contests/tarea-0-1628654405/challenges/numeros-distintos
// usando una ArrayList.
public class NumerosDistintos2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> lista = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            boolean flag = true;
            for(int j = 0; j < lista.size(); j++){
                if(lista.get(j) == tmp){
                    flag = false;
                }
            }

            if(flag == true){
                lista.add(tmp);
            }
        }

        System.out.println(lista.size());
    }
}

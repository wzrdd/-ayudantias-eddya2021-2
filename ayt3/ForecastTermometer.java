import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    // Solución a https://www.hackerrank.com/contests/stacks-1630511468/challenges/forecasttermometer
    public static List<Integer> ForecastTermometer(List<Integer> T) {
        Stack<Integer> temperaturas = new Stack<>();
        Stack<Integer> dias = new Stack<>();

        int[] ans = new int[T.size()];
        for(int i = 0; i < T.size(); i++){

            while(!temperaturas.isEmpty() && T.get(i) > temperaturas.peek()){
                int tmp_temperatura = temperaturas.pop();
                int tmp_dia = dias.pop();

                ans[tmp_dia] = i - tmp_dia;
            }

            temperaturas.add(T.get(i));
            dias.add(i);
        }

        List<Integer> respuesta = new ArrayList<>();
        for(int i : ans) respuesta.add(i);
        return respuesta;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> T = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.ForecastTermometer(T);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

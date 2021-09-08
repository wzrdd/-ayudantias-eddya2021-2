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

class MirrorNumber {
    public static List<String> findAllMirrorNumbers(int n) {
        return mirror_number(n, n);
    }

    static List<String> mirror_number(int n, int length){
        if(n == 0) return Arrays.asList("");
        if(n == 1) return Arrays.asList("0", "1", "8");

        List<String> mid = mirror_number(n - 2, length);
        List<String> answer = new ArrayList<>();
        for(String s : mid){
            if(n != length) answer.add("0" + s + "0");

            answer.add("8" + s + "8");
            answer.add("1" + s + "1");
            answer.add("9" + s + "6");
            answer.add("6" + s + "9");
        }
        return answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> res = Result.findAllMirrorNumbers(n);

		Collections.sort(res);


        bufferedWriter.write(
            res.stream()
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

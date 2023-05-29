import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// author : DDing77
// solution : Greedy
// tip : long 타입 사용

public class Main {
    static int N;
    static long tipSum = 0;
    static Integer[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new Integer[N];
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(people, Collections.reverseOrder());

        for (int i = 1; i <= N; i++) {
            if (people[i - 1] - (i - 1) > 0) tipSum += people[i - 1] - (i - 1);
            else if( people[i-1] - (i-1) <= 0) break;
        }
        System.out.println(tipSum);
    }
}

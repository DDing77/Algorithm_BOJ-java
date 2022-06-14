import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] setA;
    static int[] setB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        setA = new int[4];
        setB = new int[2];

        for (int i = 0; i < 6; i++) {
            int score = Integer.parseInt(br.readLine());
            if (i < 4) setA[i] = score;
            else setB[i - 4] = score;
        }

        Arrays.sort(setA);
        Arrays.sort(setB);

        int sum = 0;

        for (int i = 3; i > 0; i--) sum += setA[i];
        sum += setB[1];

        System.out.println(sum);
    }
}

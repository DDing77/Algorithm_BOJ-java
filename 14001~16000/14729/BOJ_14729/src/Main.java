import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static double[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        score = new double[N];
        for (int i = 0; i < N; i++) {
            score[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(score);

        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f", score[i])).append('\n');
        }

        System.out.print(sb);
    }
}

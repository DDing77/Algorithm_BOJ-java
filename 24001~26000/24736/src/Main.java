import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] score;
    static int[] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        score = new int[2];
        info = new int[5];

        for (int k = 0; k < 2; k++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                info[i] = Integer.parseInt(st.nextToken());
            }
            score[k] = info[0] * 6 + info[1] * 3 + info[2] * 2 + info[3] + info[4] * 2;
        }
        System.out.println(score[0] + " " + score[1]);

    }
}

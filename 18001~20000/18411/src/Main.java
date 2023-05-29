import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        score = new int[3];
        for (int i = 0; i < 3; i++) score[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(score);

        int res = score[1] + score[2];

        System.out.println(res);
    }
}
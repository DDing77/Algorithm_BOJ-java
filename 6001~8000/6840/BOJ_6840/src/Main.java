import java.io.*;
import java.util.*;

public class Main {

    final int SIZE = 3;
    int[] bowls;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        bowls = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            bowls[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bowls);

        System.out.println(bowls[1]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
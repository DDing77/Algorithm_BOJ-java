import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int max;
    private int[] numbers;
    private HashSet<Integer> crossNumbers;

    private void createCrossNumber() {

        crossNumbers = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        int cur = i * 1000 + j * 100 + k * 10 + l;
                        crossNumbers.add(getMin(i , j, k, l));
                    }
                }
            }
        }
    }

    private int getMin(int a, int b, int c, int d) {

        int min = Integer.MAX_VALUE;
        min = Math.min(min, a * 1000 + b * 100 + c * 10 + d);
        min = Math.min(min, b * 1000 + c * 100 + d * 10 + a);
        min = Math.min(min, c * 1000 + d * 100 + a * 10 + b);
        min = Math.min(min, d * 1000 + a * 100 + b * 10 + c);

        return min;
    }

    private void solution() throws IOException {

        numbers = new int[4];
        st = new StringTokenizer(br.readLine());
        max = getMin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        createCrossNumber();

        int res = 0;
        for (int crossNumber : crossNumbers) {
            if (crossNumber <= max) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

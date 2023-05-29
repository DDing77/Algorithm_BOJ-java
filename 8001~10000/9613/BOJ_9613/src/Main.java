import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> gcds;

    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        list = new ArrayList[T];

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            list[t] = new ArrayList<>();
            for (int i = 0; i < size; i++) list[t].add(Integer.parseInt(st.nextToken()));

            long sum = 0;
            gcds = new ArrayList<>();
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    int getGCD = gcd(list[t].get(i), list[t].get(j));
                    sum += getGCD;
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}

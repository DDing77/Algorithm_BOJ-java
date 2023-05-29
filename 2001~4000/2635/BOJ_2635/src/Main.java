import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer> list;
    static ArrayList<Integer> temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        temp = new ArrayList<>();

        int max = 0;
        for (int i = N; i >= 1; i--) {
            list.add(N);
            list.add(i);

            while (true) {
                int n = list.get(list.size() - 2) - list.get(list.size() - 1);
                if (n < 0) break;
                else list.add(n);
            }

            if (max < list.size()) {
                max = list.size();
                temp.clear();
                temp.addAll(list);
            }

            list.clear();
            }
        sb.append(max).append('\n');

        for (Integer i : temp) sb.append(i).append(" ");

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static int N;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list, Comparator.reverseOrder());

        for (int i = 0; i < N; i++) sb.append(list.get(i)).append('\n');

        System.out.print(sb);
    }
}

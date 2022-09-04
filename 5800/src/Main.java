import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        room = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            room[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) room[i].add(Integer.parseInt(st.nextToken()));

            Collections.sort(room[i], Comparator.reverseOrder());

            int diff = room[i].get(0) - room[i].get(1);
            for (int k = 1; k < size; k++) diff = Math.max(diff, room[i].get(k - 1) - room[i].get(k));

            sb.append("Class ").append(i + 1).append('\n');
            sb.append("Max ").append(room[i].get(0)).append(", ")
                    .append("Min ").append(room[i].get(size - 1)).append(", ")
                    .append("Largest gap ").append(diff).append('\n');
        }

        System.out.print(sb);
    }
}
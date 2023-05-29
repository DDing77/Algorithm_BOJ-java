import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static class Info implements Comparable<Info> {
        int val;
        int idx;

        public Info(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info o) {
            return o.val - val;
        }
    }

    static Info[] infos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        infos = new Info[8];
        for (int i = 0; i < 8; i++) {
            int val = Integer.parseInt(br.readLine());
            infos[i] = new Info(val, i + 1);
        }

        Arrays.sort(infos);
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            sum += infos[i].val;
            res.add(infos[i].idx);
        }

        Collections.sort(res);

        sb.append(sum).append('\n');
        for (int idx : res) sb.append(idx).append(" ");
        System.out.println(sb);
    }
}

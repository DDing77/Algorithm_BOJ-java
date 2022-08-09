import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Info implements Comparable<Info> {
        int x;
        // 0 : 파이프
        // 1 : 소방차
        int type;

        public Info(int x, int type) {
            this.x = x;
            this.type = type;
        }

        @Override
        public int compareTo(Info o) {
            return x - o.x;
        }
    }

    static int P, F;
    static long res;
    static Info[] infos;
    static ArrayList<Info>[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        int N = P + F;
        infos = new Info[N];

        int x;
        // 파이프
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            x = Integer.parseInt(st.nextToken());
            infos[i] = new Info(x, 0);
        }
        // 소방차
        st = new StringTokenizer(br.readLine());
        for (int i = P; i < N; i++) {
            x = Integer.parseInt(st.nextToken());
            infos[i] = new Info(x, 1);
        }

        Arrays.sort(infos);

        int pos = N;
        level = new ArrayList[pos * 2];
        for (int i = 0; i <pos * 2; i++) level[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (infos[i].type == 1) {
                level[--pos].add(infos[i]);
            } else {
                level[pos++].add(infos[i]);
            }
        }

        for (int i = 0; i < N * 2; i++) {
            int sum = 0;
            int min;
            for (int j = 1; j < level[i].size(); j += 2) {
                sum += level[i].get(j).x - level[i].get(j - 1).x;
            }

            min = sum;
            if ((level[i].size() & 1) > 0) {
                for (int j = level[i].size() - 1; j > 1; j -= 2) {
                    min = Math.min(min, sum += level[i].get(j).x - level[i].get(j - 1).x * 2 + level[i].get(j - 2).x);
                }
            }
            res += min;
        }

        System.out.println(res);
    }
}


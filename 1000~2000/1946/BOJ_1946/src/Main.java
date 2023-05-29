import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T, N;

    static class Info implements Comparable<Info> {
        int a;
        int b;

        public Info(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Info o) {
            if (this.a == o.a) return this.b - o.b;
            return this.a - o.a;
        }
    }

    static Info[] infos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            infos = new Info[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                infos[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(infos);

            int res = 1;
            int pre = infos[0].b;
            for (int i = 1; i < N; i++) {
                if (infos[i].b < pre) {
                    pre = infos[i].b;
                    res++;
                }
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
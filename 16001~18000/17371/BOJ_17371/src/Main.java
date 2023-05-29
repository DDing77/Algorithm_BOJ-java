import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int x;
        int y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Info> infos;
    static int N;
    static int res;

    static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        infos = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            infos.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        res = -1;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            double max = 0;
            Info a = infos.get(i);
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                Info b = infos.get(j);
                max = Math.max(max, getDistance(a.x, a.y, b.x, b.y));
            }
            if (max < min) {
                min = max;
                res = i;
            }
        }
        System.out.println(infos.get(res).x + " " + infos.get(res).y);
    }
}

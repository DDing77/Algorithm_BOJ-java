import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N;
    int res;
    Cow[] cows;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cows);

        res = 0;
        for (Cow cow : cows) {
            if (res <= cow.arrivedTime) {
                res = cow.arrivedTime;
            }
            res += cow.checkTime;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public static class Cow implements Comparable<Cow> {
        int arrivedTime;
        int checkTime;

        public Cow(int arrivedTime, int checkTime) {
            this.arrivedTime = arrivedTime;
            this.checkTime = checkTime;
        }

        @Override
        public int compareTo(Cow o) {
            return this.arrivedTime - o.arrivedTime;
        }
    }
}

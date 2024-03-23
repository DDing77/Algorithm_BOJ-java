import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;
    int[] bubbleArr;
    Info[] infos;
    int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        bubbleArr = new int[N];
        infos = new Info[N];
        for (int i = 0; i < N; i++) {
            bubbleArr[i] = Integer.parseInt(br.readLine());
            infos[i] = new Info(i, bubbleArr[i]);
        }

        Arrays.sort(infos);

        int res = 0;
        for (int i = 0; i < N; i++) {
            int diff = infos[i].idx - i;
            res = Math.max(res, diff);
        }

        System.out.println(res + 1);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Info implements Comparable<Info> {

        int idx;
        int number;

        public Info(int idx, int number) {
            this.idx = idx;
            this.number = number;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.number, o.number);
        }
    }
}
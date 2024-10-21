import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private PriorityQueue<Info> A;
    private Set<Integer> aSet;
    private PriorityQueue<Info> B;
    private Set<Integer> bSet;

    private ArrayList<Info> aOrders;
    private ArrayList<Info> bOrders;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new PriorityQueue<>();
        aSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            A.add(new Info(value, i));
            aSet.add(value);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        B = new PriorityQueue<>();
        bSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            B.add(new Info(value, i));
            bSet.add(value);
        }

        aOrders = new ArrayList<>();
        aOrders.add(new Info(-1, -1));
        bOrders = new ArrayList<>();
        bOrders.add(new Info(-1, -1));

        while (!A.isEmpty() && !B.isEmpty()) {
            if (aOrders.get(aOrders.size() -1).idx > A.peek().idx) {
                A.poll();
            } else if (bOrders.get(bOrders.size() - 1).idx > B.peek().idx) {
                B.poll();
            } else if (A.peek().value == B.peek().value) {
                Info a = A.poll();
                Info b = B.poll();
                if (aOrders.get(aOrders.size() - 1).idx < a.idx && bOrders.get(bOrders.size() - 1).idx < b.idx) {
                    aOrders.add(a);
                    bOrders.add(b);
                }
            } else if (A.peek().value > B.peek().value) {
                A.poll();
            } else {
                B.poll();
            }
        }

        aOrders.remove(0);
        sb.append(aOrders.size()).append('\n');

        for (Info info : aOrders) {
            sb.append(info.value).append(" ");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Info implements Comparable<Info> {

        int value;
        int idx;

        public Info(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Info o) {

            if (this.value == o.value) {
                return this.idx - o.idx;
            }
            return o.value - this.value;
        }
    }
}

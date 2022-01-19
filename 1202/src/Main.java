import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class GEM implements Comparable<GEM> {
        int weight;
        int value;

        public GEM(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(GEM o) {
            if (weight == o.weight) {
                return o.value - value;
            }
            return weight - o.weight;
        }
    }

    static int N, K;
    static int[] bag;
    static ArrayList<GEM> list;
    static long ans = 0;

    static void solution() {
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        int listIdx = 0;
        for (int i = 0; i < K; i++) {
            while (listIdx < N && list.get(listIdx).weight <= bag[i]) {
                que.add(list.get(listIdx).value);
                listIdx++;
            }
            if( !que.isEmpty()) ans += que.poll();
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag = new int[K];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new GEM(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        solution();
    }
}

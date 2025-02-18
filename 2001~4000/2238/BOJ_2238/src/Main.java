import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int U;
    private int N;
    private HashMap<Integer, Cost> map;
    private List<Cost> costs;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        U = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        costs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int cost = Integer.parseInt(st.nextToken());

            if (map.containsKey(cost)) {
                map.get(cost).addName(name);
            } else {
                Cost newCost = new Cost(cost);
                newCost.addName(name);
                map.put(cost, newCost);
                costs.add(newCost);
            }
        }

        Collections.sort(costs);

        Cost res = costs.get(0);
        sb.append(res.names.get(0)).append(" ").append(res.cost);
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Cost implements Comparable<Cost> {
        private int cost;
        private List<String> names = new ArrayList<>();

        public Cost(int cost) {
            this.cost = cost;
        }

        public void addName(String name) {
            names.add(name);
        }

        @Override
        public int compareTo(Cost o) {
            if (this.names.size() == o.names.size()) {
                return Integer.compare(cost, o.cost);
            }
            return Integer.compare(this.names.size(), o.names.size());
        }
    }
}

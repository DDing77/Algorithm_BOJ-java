import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static class Rain {
        int idx;
        int year;
        int value;

        public Rain(int idx, int year, int value) {
            this.idx = idx;
            this.year = year;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Rain{" +
                    "idx=" + idx +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }

    static ArrayList<Rain> rainList;
    static int[] tree;
    static HashMap<Integer, Rain> map;
    static int N, M;

    static int initTD(int start, int end, int nodeNum) {
        if (start == end) {
            tree[nodeNum] = rainList.get(start).value;
            return tree[nodeNum];
        }
        int mid = (start + end) >> 1;

        tree[nodeNum] = Math.max(initTD(start, mid, nodeNum * 2),
                initTD(mid + 1, end, nodeNum * 2 + 1));
        return tree[nodeNum];
    }

    static int biSearch(int year) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (rainList.get(mid).year < year) {
                left = mid + 1;
            } else right = mid;
        }
        return right;
    }

    static int queryTD(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (queryRight < start || queryLeft > end) return 0;
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum];

        int mid = (start + end) >> 1;
        return Math.max(queryTD(start, mid, queryLeft, queryRight, nodeNum * 2),
                queryTD(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        rainList = new ArrayList<>();
        rainList.add(new Rain(0, 0, 0));
        map = new HashMap<>();

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new int[length + 1];
//        for (int i = 0; i < tree.length; i++) tree[i] = new Rain(0, 0, 0);
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int year = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            rainList.add(new Rain(i, year, value));
            map.put(year, new Rain(i, year, value));
        }

        initTD(1, N, 1);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            if (!map.containsKey(Y) && !map.containsKey(X)) sb.append("maybe");
            else if (map.containsKey(Y) && map.containsKey(X)) {
                int queryLeft = map.get(Y).idx + 1;
                int queryRight = map.get(X).idx - 1;
                int maxValue = queryTD(1, N, queryLeft, queryRight, 1);
                // System.out.println("test");
//                    System.out.println(queryLeft);
//                    System.out.println(queryRight);
//                    System.out.println(maxValue);
                if (maxValue >= map.get(X).value || map.get(Y).value < map.get(X).value) sb.append("false");
                else if (queryRight - queryLeft == X - Y - 2) sb.append("true");
                else sb.append("maybe");

            } else if (map.containsKey(Y) && !map.containsKey(X)) {
                int queryLeft = map.get(Y).idx + 1;
                int queryRight = biSearch(X) - 1;
                int maxValue = queryTD(1, N, queryLeft, queryRight, 1);

                if (maxValue < map.get(Y).value) sb.append("maybe");
                else sb.append("false");
            } else if (!map.containsKey(Y) && map.containsKey(X)) {
                int queryLeft = biSearch(Y);
                int queryRight = map.get(X).idx - 1;
                int maxValue = queryTD(1, N, queryLeft, queryRight, 1);

                if (maxValue >= map.get(X).value) sb.append("false");
                else sb.append("maybe");
            }

            sb.append('\n');
        }
        System.out.print(sb);
//        System.out.println(Arrays.toString(tree));
    }
}

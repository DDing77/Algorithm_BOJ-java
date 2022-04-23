import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Query implements Comparable<Query> {
        int k;
        int start;
        int end;
        int idx;

        public Query(int k, int start, int end, int cnt) {
            this.k = k;
            this.start = start;
            this.end = end;
            this.idx = cnt;
        }

        @Override
        public int compareTo(Query o) {
            if (k == o.k) return idx - o.idx;
            return k - o.k;
        }
    }

    static long initTD(int start, int end, int nodeNum) {
        if (start == end) return tree[nodeNum] = arr[start];
        else {
            int mid = (start + end) >> 1;
            return tree[nodeNum] = initTD(start, mid, nodeNum * 2) +
                    initTD(mid + 1, end, nodeNum * 2 + 1);
        }
    }

    static long updateBU(int start, int end, int nodeNum, int target, int value) {
        if (target < start || end < target) return tree[nodeNum];
        if (start == end && start == target) return tree[nodeNum] = value;

        int mid = (start + end) >> 1;

        return tree[nodeNum] = updateBU(start, mid, nodeNum * 2, target, value) +
                updateBU(mid + 1, end, nodeNum * 2 + 1, target, value);

    }

    static long query(int start, int end, int queryLeft, int queryRight, int nodeNum) {
        if (end < queryLeft || start > queryRight) return 0;
        if (queryLeft <= start && end <= queryRight) return tree[nodeNum];

        int mid = (start + end) >> 1;
        return query(start, mid, queryLeft, queryRight, nodeNum * 2) +
                query(mid + 1, end, queryLeft, queryRight, nodeNum * 2 + 1);
    }


    static int N, M;
    static int[] arr;
    static long[] tree;
    static long[] res;
    static ArrayList<int[]> query1 = new ArrayList<>();
    static ArrayList<Query> query2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf * 2;

        tree = new long[length + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        initTD(1, N, 1);

        M = Integer.parseInt(br.readLine());
        res = new long[M];

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int target = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                query1.add(new int[]{target, value});
            } else {
                int k = Integer.parseInt(st.nextToken());
                int queryLeft = Integer.parseInt(st.nextToken());
                int queryRight = Integer.parseInt(st.nextToken());
                query2.add(new Query(k, queryLeft, queryRight, cnt++));
            }
        }

        Collections.sort(query2);

        int K = 0;
        for (int i = 0; i < query2.size(); i++) {
            while (query2.get(i).k > K) {
                updateBU(1, N, 1, query1.get(K)[0], query1.get(K)[1]);
                K++;
            }
            res[query2.get(i).idx] = query(1, N, query2.get(i).start, query2.get(i).end, 1);
        }

        for (int i = 0; i < query2.size(); i++) sb.append(res[i]).append('\n');
        System.out.print(sb);
//        System.out.println(query2.get(1).k);
//        System.out.println(query2.get(1).start);
//        System.out.println(query2.get(1).end);
//        System.out.println(query2.get(1).idx);

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(tree));

    }
}

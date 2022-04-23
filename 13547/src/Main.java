import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int sqrt;
    static int now;
    static int[] arr;
    static int[] cnt;
    static int[] res;

    static class Query implements Comparable<Query> {
        int idx;
        int start;
        int end;

        public Query(int idx, int start, int end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Query o) {
            if (start / sqrt != o.start / sqrt) return start / sqrt - o.start / sqrt;
            return end - o.end;
        }
    }

    static Query[] queries;

    static void minus(int start, int end) {

        for (int i = start; i <= end; i++) {
            cnt[arr[i]]--;
            if (cnt[arr[i]] == 0) now--;
        }
    }

    static void plus(int start, int end) {

        for (int i = start; i <= end; i++) {
            if (cnt[arr[i]] == 0) now++;
            cnt[arr[i]]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sqrt = (int) Math.sqrt(N);

        arr = new int[N + 1];
        cnt = new int[1000001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        queries = new Query[M];
        res = new int[M + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queries[i] = new Query(i, start, end);
        }
        Arrays.sort(queries);

        for (int i = queries[0].start; i <= queries[0].end; i++) {
            if (cnt[arr[i]] == 0) now++;
            cnt[arr[i]]++;
        }

        res[queries[0].idx] = now;
        int left = queries[0].start;
        int right = queries[0].end;

        for (int i = 1; i < M; i++) {
            if (queries[i].start < left) plus(queries[i].start, left - 1);
            if (queries[i].end > right) plus(right + 1, queries[i].end);
            if (queries[i].start > left) minus(left, queries[i].start - 1);
            if (queries[i].end < right) minus(queries[i].end + 1, right);

            left = queries[i].start;
            right = queries[i].end;
            res[queries[i].idx] = now;
        }

        for (int i = 0; i < M; i++) sb.append(res[i]).append('\n');
        System.out.print(sb);
    }
}

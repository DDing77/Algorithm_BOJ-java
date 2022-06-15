import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Query {
        int idx;
        int s;
        int e;

        public Query() {
            this.idx = 0;
            this.s = 0;
            this.e = 0;
        }

        public Query(int s, int e) {
            this.s = s;
            this.e = e;
        }

//        @Override
//        public int compare(Query a, Query b) {
//            if(a.s / sqr != b.s/sqr) return (int) (a.s < b.s ? a.s : b.s);
//            return (int) (a.e < b.e ? a.e : b.e);
//        }
//        public boolean compare(Query a, Query b) {
//            if(a.s / sqr != b.s/sqr) return a.s < b.s;
//            return a.e < b.e;
//        }

    }


    static int n, m, Q;
    static int now;
    static int sqr;
    static int lf, rf;

    static Query[] query;
    static int[] arr;
    static int[] ans;
    static ArrayList<Integer>[] cnt;
    static int[] dcnt;
    static int[] sqcnt;

    static void mib(int s, int e) {
        for (int i = e; i >= s; i--) {
            int j = arr[(int) i];
            if (cnt[j].size() >= 2) {
                int dis = cnt[j].get(cnt[j].size() - 1) - cnt[j].get(0);
                dcnt[dis]--;
                sqcnt[dis/400]--;
            }
            cnt[j].remove(cnt[j].size() - 1);
            if (cnt[j].size() >= 2) {
                int dis = cnt[j].get(cnt[j].size() - 1) - cnt[j].get(0);
                dcnt[dis]++;
                sqcnt[dis/400]++;
            }
        }
    }

    static void mif(int s, int e) {
        for (int i = s; i <= e; i++) {
            int j = arr[i];
            if (cnt[j].size() >= 2) {
                int dis = cnt[j].get(cnt[j].size() - 1) - cnt[j].get(0);
                dcnt[dis]--;
                sqcnt[dis/400]--;
            }
            cnt[j].remove(0);
            if (cnt[j].size() >= 2) {
                int dis = cnt[j].get(cnt[j].size() - 1) - cnt[j].get(0);
                dcnt[dis]++;
                sqcnt[dis/400]++;
            }
        }
    }

    static void plf(int s, int e) {
        for (int i = e; i >= s; i--) {
            int j = arr[i];
            if (cnt[j].size() >= 2) {
                int dis = cnt[j].get(cnt[j].size() - 1) - cnt[j].get(0);
                dcnt[dis]--;
                sqcnt[dis/400]--;
            }
            cnt[j].add(0, i);
            int dis = cnt[j].get(cnt[j].size() - 1) - cnt[j].get(0);
            dcnt[dis]++;
            sqcnt[dis/400]++;
        }
    }

    static void plb(int s, int e) {
        for (int i = s; i <= e; i++) {
            int j = arr[i];
            if (cnt[j].size() >= 2) {
                int dis = cnt[j].get(cnt[j].size() - 1) - cnt[j].get(0);
                dcnt[dis]--;
                sqcnt[dis/400]--;
            }
            cnt[j].add(i);
            int dis = cnt[j].get(cnt[j].size() - 1) - cnt[j].get(0);
            dcnt[dis]++;
            sqcnt[dis/400]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sqr = (int) Math.sqrt(n);

        arr = new int[n+1];
        cnt = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) cnt[i] = new ArrayList<>();

        dcnt = new int[101010];
        sqcnt = new int[101010];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Q = Integer.parseInt(br.readLine());
        query = new Query[Q + 1];
        query[0] = new Query();
        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            query[i] = new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            query[i].idx = i;
        }

        Arrays.sort(query, (a, b) -> {
            if (a.s / sqr != b.s / sqr) return a.s < b.s ? a.s : b.s;
            return a.e < b.e ? a.e : b.e;
        });

        plf(query[1].s, query[1].e);
        for (int i = 260; i >= 0; i--) {
            if (sqcnt[i] != 0) {
                for (int j = 399; j >= 0; j--) {
                    if (dcnt[i * 400 + j] != 0) {
                        now = i * 400 + j;
                        break;
                    }
                }
                break;
            }
        }
        ans = new int[Q + 1];
        ans[query[1].idx] = now;

        lf = query[1].s;
        rf = query[1].e;

        for (int i = 2; i <= Q; i++) {
            if (query[i].s < lf) plf(query[i].s, lf - 1);
            if (query[i].e > rf) plb(rf + 1, query[i].e);
            if (query[i].s > lf) mif(lf, query[i].s - 1);
            if (query[i].e < rf) mib(query[i].e + 1, rf);

            lf = query[i].s;
            rf = query[i].e;

            for (int k = 260; k >= 0; k--) {
                if (sqcnt[k] != 0) {
                    for (int j = 399; j >= 0; j--) {
                        if (dcnt[k * 400 + j] != 0) {
                            now = k * 400 + j;
                            break;
                        }
                    }
                    break;
                }
            }
            ans[query[i].idx] = now;
        }

        for (int i = 1; i <= Q; i++) sb.append(ans[i]).append('\n');
        System.out.print(sb);
    }
}

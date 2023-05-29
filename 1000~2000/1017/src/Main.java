import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer> odd;
    static ArrayList<Integer> even;
    static ArrayList<Integer> left, right;
    static ArrayList<Integer>[] edge;
    static ArrayList<Integer> ans;
    static boolean[] isVisited;
    static int[] match;
    static boolean[] isPrime = new boolean[2000 + 1];

    static void getPrime() {
        for (int i = 3; i <= Math.sqrt(2000); i += 2) {
            if (isPrime[i]) continue;
            int tmp = i + i;
            while (tmp <= 2000) {
                isPrime[tmp] = true;
                tmp += i;
            }
        }
    }

    static void findEdge() {
        edge = new ArrayList[left.size()];
        for (int i = 0; i < left.size(); i++) edge[i] = new ArrayList<>();

        for (int i = 0; i < left.size(); i++) {
            int from = left.get(i);

            for (int j = 0; j < right.size(); j++) {
                int to = right.get(j);
                if (!isPrime[from + to]) edge[i].add(j);
            }
        }
    }

    static boolean DFS(int now) {
        for (int next : edge[now]) {
            if (isVisited[next]) continue;
            isVisited[next] = true;
            if (match[next] == -1 || DFS(match[next])) {
                match[next] = now;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        odd = new ArrayList<>();
        even = new ArrayList<>();

        int first = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if ((input & 1) == 1) odd.add(input);
            else even.add(input);
            if (first == -1) first = input;
        }

        if (even.size() != odd.size()) {
            System.out.println(-1);
            return;
        }


        if ((first & 1) == 1) {
            left = odd;
            right = even;
        } else {
            left = even;
            right = odd;
        }

        getPrime();

        findEdge();

        for(int i=0; i<edge.length; i++) {
            if(edge[i].size() ==0) {
                System.out.println(-1);
                return;
            }
        }

        match = new int[right.size()];
        Arrays.fill(match, -1);
        isVisited = new boolean[right.size()];
        for (int i = 1; i < left.size(); i++) {

            if (!DFS(i)) {
                System.out.println(-1);
                return;
            }
            isVisited = new boolean[right.size()];
        }

        ans = new ArrayList<>();
        for (int next : edge[0]) {
            if (match[next] == -1 || DFS(match[next])) {
                match[next] = -1;
                ans.add(right.get(next));
            }
            isVisited = new boolean[right.size()];
        }

        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) sb.append(ans.get(i)).append(" ");

        System.out.println(ans.size() == 0 ? -1 : sb);
    }
}

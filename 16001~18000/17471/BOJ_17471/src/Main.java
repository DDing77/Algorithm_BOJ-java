import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    Node[] nodes;
    ArrayList<Integer>[] edges;
    int allBit;
    HashSet<Integer> set;
    int res;

    public void comb(int bit, int idx, int sum, int depth) {
        if (depth == 0) {
            if (!set.contains(bit)) {
                set.add(bit);
                getResult(bit);
            }
        }

        for (int i = idx; i < N; i++) {
            bit |= 1 << (i + 1);
            comb(bit, i + 1, sum + nodes[i + 1].value, depth - 1);
            bit ^= 1 << (i + 1);
        }
    }

    public void getResult(int bit) {
        int aBit = bit;
        int bBit = allBit ^ aBit;

        int aTotal = execBFS(aBit);
        if (aTotal == -1) {
            return;
        }

        int bTotal = execBFS(bBit);
        if (bTotal == -1) {
            return;
        }

        res = Math.min(res, Math.abs(aTotal - bTotal));
    }

    public int execBFS(int bit) {
        boolean[] isVisited = new boolean[N + 1];
        ArrayList<Integer> bitList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if ((bit & (1 << i)) == 1 << i) {
                bitList.add(i);
                break;
            }
        }

        isVisited[bitList.get(0)] = true;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(bitList.get(0));

        int total = nodes[bitList.get(0)].value;
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : edges[cur]) {
                if (!isVisited[next] && (bit & (1 << next)) > 0) {
                    total += nodes[next].value;
                    isVisited[next] = true;
                    que.add(next);
                }
//                if(!isVisited[next] && bitList.contains(next)) {
//                    total += nodes[next].value;
//                    isVisited[next] = true;
//                    que.add(next);
//                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if ((bit & (1 << i)) > 0) {
                if (!isVisited[i]) {
                    return -1;
                }
            }
        }
//        for(int i : bitList) {
//            if(!isVisited[i]) return -1;
//        }

        return total;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; j++) {
                edges[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        res = Integer.MAX_VALUE;
        allBit = (1 << (N + 1)) - 1;
        set = new HashSet<>();
        for (int i = 0; i < N - 1; i++) {
            comb(1 << 1, 1, nodes[1].value, i);
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Node {
        int number;
        int value;

        public Node(int number, int value) {
            this.number = number;
            this.value = value;
        }
    }
}

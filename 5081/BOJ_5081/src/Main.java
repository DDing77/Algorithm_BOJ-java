import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int n;
    private int tc;
    private Node[] nodes;
    private ArrayList<Integer> minDistanceEdge;
    private int res;

    private class Node {
        int number;
        int x;
        int y;
        int rank;

        public Node(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.rank = -1;
        }
    }

    public int getDistance(Node a, Node b) {
        return Math.abs(a.x - b.x) * Math.abs(a.x - b.x) + Math.abs(a.y - b.y) * Math.abs(a.y - b.y);
    }

    public int find(int x) {
        if (nodes[x].rank < 0) {
            return x;
        }

        return nodes[x].rank = find(nodes[x].rank);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a == b) {
            return;
        }

        if (nodes[a].rank <= nodes[b].rank) {
            nodes[a].rank += nodes[b].rank;
            nodes[b].rank = a;
        } else {
            nodes[b].rank += nodes[a].rank;
            nodes[a].rank = b;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            nodes = new Node[n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                nodes[i] = new Node(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= n; i++) {
                minDistanceEdge = new ArrayList<>();
                int minDistance = Integer.MAX_VALUE;

                // Get closest Nodes
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;

                    int distance = getDistance(nodes[i], nodes[j]);

                    if (minDistance == distance) {
                        minDistanceEdge.add(j);
                    } else if (minDistance > distance) {
                        minDistance = distance;
                        minDistanceEdge.clear();
                        minDistanceEdge.add(j);
                    }

                }

                for (int node : minDistanceEdge) {
                    union(i, node);
                }

                res = 0;
                for (int k = 1; k <= n; k++) {
                    if (nodes[k].rank < 0) {
                        res++;
                    }
                }
            }
            sb.append("Sky " + tc++ + " contains " + res + " constellations.\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
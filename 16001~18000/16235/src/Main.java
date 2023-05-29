import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Tree {
        int row;
        int col;
        int age;
        boolean dead;

        public Tree(String[] tree) {
            this.row = Integer.parseInt(tree[0]);
            this.col = Integer.parseInt(tree[1]);
            this.age = Integer.parseInt(tree[2]);
        }

        public Tree(int row, int col, int age) {
            this.row = row;
            this.col = col;
            this.age = age;
        }
    }

    static int N, M, K;
    static int[][] map;
    static int[][] A;
    static ArrayList<Tree> treeList;
    static Deque<Integer> deadTree;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상 우 하 좌
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static void spring() {
        for (int i = 0; i < treeList.size(); i++) {
            Tree curTree = treeList.get(i);

            if (map[curTree.row][curTree.col] < curTree.age) {
                deadTree.add(i);
                continue;
            }
            map[curTree.row][curTree.col] -= curTree.age;
            curTree.age++;
        }
    }

    static void summer() {
        while (!deadTree.isEmpty()) {
            int deadTreeIdx = deadTree.pollLast();
            Tree deadTree = treeList.get(deadTreeIdx);
            int nutrients = deadTree.age / 2;
            map[deadTree.row][deadTree.col] += nutrients;
            deadTree.dead = true;
        }
    }

    static void fall() {
        ArrayList<Tree> newTree = new ArrayList<>();
        for (int i = 0; i < treeList.size(); i++) {
            Tree tree = treeList.get(i);

            if (tree.dead) continue;

            if (tree.age % 5 == 0) {
                for (int k = 0; k < 8; k++) {
                    int newR = tree.row + dx[k];
                    int newC = tree.col + dy[k];
                    if (newR < 1 || newC < 1 || newR > N || newC > N) continue;
                    newTree.add(new Tree(newR, newC, 1));
                }
            }
        }

        for (Tree tree : treeList) {
            if (!tree.dead) newTree.add(tree);
        }

        treeList = newTree;
    }


    static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];
        treeList = new ArrayList<>();
        deadTree = new LinkedList<>();

        // 초기 영양분 배열
        for (int i = 1; i <= N; i++) Arrays.fill(map[i], 5);

        // 겨울에 심는 영양분 A배열
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            String[] tree = br.readLine().split(" ");
            treeList.add(new Tree(tree));
        }

        Collections.sort(treeList, (tree1, tree2) -> tree1.age - tree2.age);

        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(treeList.size());
    }
}
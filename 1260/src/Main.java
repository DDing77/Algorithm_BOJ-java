import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// // 인접행렬
//public class Main {
//    static int N, M, start;
//    static int[][] matrix;
//    static boolean[] check;
//    static StringBuilder sb = new StringBuilder();
//
//    static void dfs(int start) {
//        check[start] = true;
//        sb.append(start).append(' ');
//        for(int i=1; i<=N;i++) {
//            if(matrix[start][i] == 0) continue;
//            if(check[i] == true) continue;
//            dfs(i);
//        }
//    }
//
//    static void bfs(int start) {
//        Queue<Integer> que = new LinkedList<>();
//        que.add(start);
//        check[start] = true;
//        while(!que.isEmpty()){
//            start = que.poll();
//            sb.append(start).append(' ');
//            for(int i =1; i<=N; i++) {
//                if(matrix[start][i] == 0) continue;
//                if(check[i]== true)continue;
//                que.add(i);
//                check[i]=true;
//            }
//        }
//    }
//
//    static void getAns() {
//        check = new boolean[N + 1];
//        dfs(start);
//        sb.append("\n");
//        for (int i = 1; i <= N; i++) check[i] = false;
//        bfs(start);
//        System.out.println(sb);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        start = Integer.parseInt(st.nextToken());
//        matrix = new int[N + 1][N + 1];
//        for (int i = 1; i <= M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
//            matrix[x][y] = 1;
//            matrix[y][x] = 1;
//        }
//        getAns();
//    }
//}

//// 인접리스트
//public class Main{
//    static int N, M, start;
//    static ArrayList<Integer>[] matrix;
//    static boolean[] check;
//    static StringBuilder sb = new StringBuilder();
//
//    static void dfs(int start) {
//        check[start] = true;
//        sb.append(start).append(' ');
//        for(int i: matrix[start]) {
//          if(check[i] == true) continue;
//          dfs(i);
//        }
//    }
//
//    static void bfs(int start) {
//        Queue<Integer> que = new LinkedList<>();
//        que.add(start);
//        check[start] = true;
//        while(!que.isEmpty()){
//            start = que.poll();
//            sb.append(start).append(' ');
//            for(int i : matrix[start]) {
//                if(check[i]== true)continue;
//                que.add(i);
//                check[i]=true;
//            }
//        }
//    }
//
//    static void getAns() {
//        check = new boolean[N + 1];
//        dfs(start);
//        sb.append("\n");
//        for (int i = 1; i <= N; i++) check[i] = false;
//        bfs(start);
//        System.out.println(sb);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        start = Integer.parseInt(st.nextToken());
//        matrix = new ArrayList[N+1];
//
//        for(int i=1; i<=N; i++) {
//            matrix[i] = new ArrayList<>();
//        }
//
//        for (int i = 1; i <= M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
//            matrix[x].add(y);
//            matrix[y].add(x);
//        }
//        for(int i=1; i<=N; i++) {
//            Collections.sort(matrix[i]);
//        }
//
//        getAns();
//    }
//}

// 인접 행렬
public class Main {
    static int N, M, V;
    static int[][] map;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    static void DFS(int start) {
        isVisited[start] = true;
        sb.append(start).append(" ");
        for (int i = 1; i <= N; i++) {
            if (map[start][i] != 1) continue;
            if (isVisited[i]) continue;
            DFS(i);
        }
    }

    static void BFS(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        isVisited[start] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            sb.append(now).append(" ");
            for (int i = 1; i <= N; i++) {
                if (map[now][i] != 1) continue;
                if (isVisited[i]) continue;
                que.add(i);
                isVisited[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }
        DFS(V);
        sb.append('\n');
        isVisited = new boolean[N + 1];
        BFS(V);
        System.out.println(sb);
    }
}
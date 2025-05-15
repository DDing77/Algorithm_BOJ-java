import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int passengerSeq = 2;

    private int N;
    private int M;
    private int capacity;
    private int[][] board;
    private Taxi taxi;
    private List<Passenger> passengers = new ArrayList<Passenger>();
    private int count = 0;
    private int res;

    private QueryResult queryShortestPaasenger() {
        int maxDistance = taxi.capacity;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{taxi.x, taxi.y, 0});
        boolean[][] isVisited = new boolean[N][N];

        QueryResult queryResult = new QueryResult();
        if (board[taxi.x][taxi.y] > 1) {
            queryResult.distanceTaxiWithPassenger = 0;
            queryResult.passengers.add(passengers.get(board[taxi.x][taxi.y] - 2));
            return queryResult;
        }

        int minDistance = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[2] >= maxDistance) {
                continue;
            }

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board[nX][nY] == 1) {
                    continue;
                }

                if (board[nX][nY] == 0) {
                    que.add(new int[]{nX, nY, cur[2] + 1});
                } else if (board[nX][nY] > 1) {
                    if (cur[2] + 1 <= minDistance) {
                        queryResult.passengers.add(passengers.get(board[nX][nY] - 2));
                        minDistance = Math.min(minDistance, cur[2] + 1);
                    }
                }
                isVisited[nX][nY] = true;
            }
        }
        queryResult.distanceTaxiWithPassenger = minDistance;
        return queryResult;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        capacity = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi = new Taxi(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, capacity);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            Passenger passenger = new Passenger(passengerSeq, startX, startY, endX, endY);
            passenger.setDistance(N, board);
            if (passenger.distance == -1) {
                System.out.println(-1);
                return;
            }
            passengers.add(passenger);

            board[startX][startY] = passengerSeq++;
        }

        while (count < M) {
            // 거리가 제일 짧은 승객 후보 리스트
            QueryResult queryResult = queryShortestPaasenger();
            // 만약 후보 리스트 사이즈가 0일때
            if (queryResult.passengers.size() == 0) {
                res = -1;
                break;
            }

            // 정렬 후 최종 후보 선정
            Collections.sort(queryResult.passengers);
            Passenger passenger = queryResult.passengers.get(0);
            board[passenger.startX][passenger.startY] = 0;
            taxi.capacity -= queryResult.distanceTaxiWithPassenger;
            if (taxi.capacity < passenger.distance) {
                res = -1;
                break;
            }
            taxi.capacity += passenger.distance;
            taxi.x = passenger.endX;
            taxi.y = passenger.endY;
            count++;
        }

        if (res == -1 || count != M) {
            System.out.println(-1);
        } else {
            System.out.println(taxi.capacity);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class QueryResult {

        List<Passenger> passengers = new ArrayList<>();
        int distanceTaxiWithPassenger;
    }

    static class Taxi {

        int x;
        int y;
        int capacity;

        public Taxi(int x, int y, int capacity) {
            this.x = x;
            this.y = y;
            this.capacity = capacity;
        }
    }

    static class Passenger implements Comparable<Passenger> {

        int passengerSeq;
        int startX;
        int startY;
        int endX;
        int endY;
        int distance;

        public Passenger(int passengerSeq, int startX, int startY, int endX, int endY) {
            this.passengerSeq = passengerSeq;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        private void setDistance(int N, int[][] board) {
            Queue<int[]> que = new ArrayDeque<>();
            que.add(new int[]{startX, startY, 0});
            boolean[][] isVisited = new boolean[N][N];
            isVisited[startX][startY] = true;

            while (!que.isEmpty()) {
                int[] cur = que.poll();

                if (cur[0] == endX && cur[1] == endY) {
                    this.distance = cur[2];
                    return;
                }

                for (int[] dir : dirs) {
                    int nX = cur[0] + dir[0];
                    int nY = cur[1] + dir[1];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                        continue;
                    }

                    if (isVisited[nX][nY]) {
                        continue;
                    }

                    if (board[nX][nY] == 1) {
                        continue;
                    }

                    isVisited[nX][nY] = true;
                    que.add(new int[]{nX, nY, cur[2] + 1});
                }
            }

            if (!isVisited[endX][endY]) {
                distance = -1;
            }
        }

        @Override
        public int compareTo(Passenger o) {
            if (this.startX == o.startX) {
                return this.startY - o.startY;
            }
            return this.startX - o.startX;
        }
    }
}

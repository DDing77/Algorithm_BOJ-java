import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private Room[] rooms;
    private boolean[] isVisited;
    private boolean res;

    private void execDFS(int curRoomNum, int remain) {
        if (curRoomNum == N) {
            res = true;
            return;
        }

        for (int nextRoomNum : rooms[curRoomNum].next) {
            if (!isVisited[nextRoomNum]) {
                if (rooms[nextRoomNum].type == 'T' && remain >= rooms[nextRoomNum].cost) {
                    isVisited[nextRoomNum] = true;
                    execDFS(nextRoomNum, remain - rooms[nextRoomNum].cost);
                    isVisited[nextRoomNum] = false;
                } else if (rooms[nextRoomNum].type == 'L') {
                    isVisited[nextRoomNum] = true;
                    execDFS(nextRoomNum, Math.max(remain, rooms[nextRoomNum].cost));
                    isVisited[nextRoomNum] = false;
                } else if (rooms[nextRoomNum].type == 'E') {
                    isVisited[nextRoomNum] = true;
                    execDFS(nextRoomNum, remain);
                    isVisited[nextRoomNum] = false;
                }
            }
        }
    }

    private void solution() throws IOException {
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            rooms = new Room[N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                rooms[i] = new Room(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
                while (st.hasMoreTokens()) {
                    int nextRoomNumber = Integer.parseInt(st.nextToken());
                    if (nextRoomNumber == 0) {
                        break;
                    }
                    rooms[i].next.add(nextRoomNumber);
                }
            }

            isVisited = new boolean[N + 1];
            isVisited[1] = true;
            res = false;
            execDFS(1, 0);

            if (res) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Room {

        char type;
        int cost;
        List<Integer> next = new ArrayList<>();

        public Room(char type, int cost) {
            this.type = type;
            this.cost = cost;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int T;
    private int N;
    private int M;
    private char[][] board;
    private boolean[][] isVisited;
    private List<int[]> entrances;
    private String initKeys;
    private int keyBit;
    private Queue<int[]> mainQue;
    private Map<Character, Queue<int[]>> waitingQue;
    private int res;

    private boolean isKey(int x, int y) {
        return 'a' <= board[x][y] && board[x][y] <= 'z';
    }

    private boolean isDocument(int x, int y) {
        return board[x][y] == '$';
    }

    private boolean isOutline(int x, int y) {
        return x == 0 || x == N - 1 || y == 0 || y == M - 1;
    }

    private boolean isDoor(int x, int y) {
        return 'A' <= board[x][y] && board[x][y] <= 'Z';
    }

    private boolean openDoor(int x, int y) {
        int doorInt = 1 << board[x][y] - 'A';
        return (doorInt & keyBit) == doorInt;
    }

    private void addDoorToWaitingQue(int x, int y) {
        waitingQue.computeIfAbsent(board[x][y], k -> new ArrayDeque<>()).add(new int[]{x, y});
    }

    private void loadDoorFromWaitingQue(char door) {
        Queue<int[]> waitedDoors = waitingQue.get(door);
        while (!waitedDoors.isEmpty()) {
            mainQue.add(waitedDoors.poll());
        }
    }

    private void execBFS() {
        for (int[] entrance : entrances) {
            int x = entrance[0];
            int y = entrance[1];

            if (isDoor(x, y)) {
                if (!openDoor(x, y)) {
                    addDoorToWaitingQue(x, y);
                    continue;
                }
            }
            mainQue.add(new int[]{x, y});
            isVisited[x][y] = true;
        }

        while (!mainQue.isEmpty()) {
            int[] cur = mainQue.poll();

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board[nX][nY] == '*') {
                    continue;
                }

                if (isDocument(nX, nY)) {
                    res++;
                    board[nX][nY] = '.';
                } else if (isKey(nX, nY)) {
                    int keyMask = 1 << (board[nX][nY] - 'a');
                    if ((keyBit & keyMask) == 0) {
                        keyBit |= keyMask;
                        for (Character c : waitingQue.keySet()) {
                            int doorMask = 1 << (c - 'A');
                            if ((keyBit & doorMask) != 0) {
                                loadDoorFromWaitingQue(c);
                            }
                        }
                    }
                } else if (isDoor(nX, nY)) {
                    if (!openDoor(nX, nY)) {
                        addDoorToWaitingQue(nX, nY);
                        continue;
                    }
                }

                isVisited[nX][nY] = true;
                mainQue.add(new int[]{nX, nY});
            }
        }
    }

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new char[N][M];
            entrances = new ArrayList<>();
            isVisited = new boolean[N][M];
            mainQue = new ArrayDeque<>();
            waitingQue = new HashMap<>();
            keyBit = 0;
            res = 0;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = input.charAt(j);
                    if (board[i][j] != '*' && isOutline(i, j)) {
                        if (isKey(i, j)) {
                            keyBit |= 1 << (board[i][j] - 'a');
                        } else if (isDocument(i, j)) {
                            board[i][j] = '.';
                            res++;
                        }
                        entrances.add(new int[]{i, j});
                    }
                }
            }

            initKeys = br.readLine();
            for (char c : initKeys.toCharArray()) {
                if (c == '0') {
                    break;
                }
                keyBit |= 1 << (c - 'a');
            }

            execBFS();

            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}

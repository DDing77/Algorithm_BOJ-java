import java.awt.image.VolatileImage;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static int[][] cnt;
    static int[][] visit; // 0 : 방문 안함 , 1 : 방문함 ,  2 : 방문 후 물찼음

    static void solution(int startX, int startY) {
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> water = new LinkedList<>();
        // 물 위치 확인 하고 큐에 넣기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    water.add(i);
                    water.add(j);
                }
            }
        }
        que.add(startX);
        que.add(startY);
        visit[startX][startY] = 1;
        while (true) {
            if (que.size() == 0) {
                System.out.println("KAKTUS");
                System.exit(0);
            }
            // 고슴도치 이동
            int qSize = que.size() / 2;
            for (int i = 0; i < qSize; i++) {
                int x = que.poll();
                int y = que.poll();
                if (visit[x][y] == 2) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0];
                    int ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (visit[nx][ny] >= 1) continue;
                    if (map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
                    if (map[nx][ny] == 'D') {
                        cnt[nx][ny] = cnt[x][y] + 1;
                        return;
                    }
                    que.add(nx);
                    que.add(ny);
                    map[nx][ny] = 'S';
                    visit[nx][ny] = 1;
                    cnt[nx][ny] = cnt[x][y] + 1;
                }
            }
            //  물 번짐
            int wSize = water.size() / 2;
            for (int i = 0; i < wSize; i++) {
                int x = water.poll();
                int y = water.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0];
                    int ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (map[nx][ny] == 'X' || map[nx][ny] == 'D' || map[nx][ny] == '*') continue;
                    if (map[nx][ny] == 'S') {
                        visit[nx][ny] = 2;
                        cnt[nx][ny] = 0;
                        map[nx][ny] = '*';
                    }
                    water.add(nx);
                    water.add(ny);
                    map[nx][ny] = '*';
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        cnt = new int[R][C];
        visit = new int[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }
        solution(startX, startY);
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
//                System.out.print(cnt[i][j]);
                if (map[i][j] == 'D') {
                    System.out.println(cnt[i][j] != 0 ? cnt[i][j] : "KAKATUS");
                }
            }
//            System.out.println(" ");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] score;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void solution() {
        int RX = 0;
        int RY = 0;
        int BX = 0;
        int BY = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 'R'){
                    RX = i;
                    RY = j;
                }
                if(map[i][j] == 'B'){
                    BX = i;
                    BY = j;
                }
            }
        }
//        System.out.println(RX +" "+ RY);
//        System.out.println(BX+ " " + BY);
        Queue<Integer> red = new LinkedList<>();
        Queue<Integer> blue = new LinkedList<>();
        red.add(RX);
        red.add(RY);
        score[RX][RY] = 1;
        blue.add(BX);
        blue.add(BY);
        while(!red.isEmpty()) {
            int x = red.poll();
            int y = red.poll();
            boolean flag = false;
            for(int k=0; k<4; k++) {
                int nx = x;
                int ny = y;
                while(true) {
                    nx += dir[k][0];
                    ny += dir[k][1];
                }

                if(map[nx][ny] == '#' || map[nx][ny] == 'B') continue;
                if(map[nx][ny] == 'O' ) {
                    System.out.println(score[x][y]);
                    break;
                }
                score[nx][ny] = score[x][y];
                while(true){
                    nx += dir[k][0];
                    ny += dir[k][0];
                    if(nx == '#' || ny == 'B') break;
                    if(map[nx][ny] == 'O' ) {
                        System.out.println(score[x][y]);
                        break;
                    }
                    score[nx][ny] = score[x][y];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        score = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }
//        for(int i=0; i<N; i++) System.out.println(Arrays.toString(map[i]));

        solution();
    }
}

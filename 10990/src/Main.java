import java.util.*;
import java.io.*;

class Main { // BOJ_10990
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        map = new char[N][2*N-1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        dc(N,N-1,0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2*N-1; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dc(int size,int row, int col) {
        if(size == 1) {
            map[row][col]='*';
            return;
        }
        int len = 2*size-1;
        map[row][col]='*';
        map[row][col+len-1]='*';
        dc(size-1,row-1,col+1);
    }
}

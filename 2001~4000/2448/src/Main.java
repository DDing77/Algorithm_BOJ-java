import java.io.*;
import java.util.*;

public class Main { // BOJ_2448
    static char triangle[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        triangle = new char[N][2 * N - 1];

        for(int i=0;i<N;i++) {
            Arrays.fill(triangle[i],' ');
        }

        dc(N, 0, N - 1);

        for(int i=0; i<N;i++){
            for(int j = 0; j<2*N -1;j++){
                sb.append(triangle[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dc(int size, int row, int col) {
        if (size == 3) {
            triangle[row][col] = '*';
            triangle[row + 1][col - 1] = '*';
            triangle[row + 1][col + 1] = '*';
            triangle[row + 2][col - 2] = '*';
            triangle[row + 2][col - 1] = '*';
            triangle[row + 2][col] = '*';
            triangle[row + 2][col + 1] = '*';
            triangle[row + 2][col + 2] = '*';
            return;
        }
        int newSize = size /2;
        dc(newSize,row,col);
        dc(newSize,row+newSize,col-newSize);
        dc(newSize,row+newSize,col+newSize);
    }
}

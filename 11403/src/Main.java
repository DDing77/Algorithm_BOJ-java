import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    map[i][j] = 1;
                }
            }
        }

        for(int i=0; i<N; i++) {;
            for(int j=0; j< N; j++) {
                if(map[i][j] == 1) continue;
                else if(i == j) map[i][j] = 0;
                else map[i][j] = 101;
            }
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = Math.min(map[i][j] , map[i][k] + map[k][j]);
                }
            }
        }

        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}

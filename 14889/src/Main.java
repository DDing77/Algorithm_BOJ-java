import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visitor;
    static int min = Integer.MAX_VALUE;
    static int[][] map;

    static void getDiff() {
        int A = 0, B = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i +1 ; j<N; j++) {
                if( visitor[i] == true && visitor[j] == true) {
                    A += map[i][j];
                    A += map[j][i];
                }
                else if (visitor[i] == false && visitor[j] == false ) {
                    B += map[i][j];
                    B += map[j][i];
                }
            }
        }
        int val = Math.abs(A - B);
        if( val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }

    static void combi(int idx, int count){
        if(count == N/2) {
            getDiff();
            return;
        }
        for(int i= idx; i< N; i++) {
            if(!visitor[i]) {
                visitor[i] = true;
                combi(i+1, count +1);
                visitor[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visitor = new boolean[N];
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0,0);
        System.out.println(min);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static final int SIZE = 360_000;
    static int[] clock1;
    static int[] clock2;
    static int[] pi;
    static StringBuilder sb = new StringBuilder();

    static void failureFunction(){
        pi = new int[SIZE];
        int j = 0;
        for( int i=1; i<SIZE; i++) {
            while( j > 0 && clock2[i] != clock2[j]) {
                j = pi[j-1];
            }
            if( clock2[i] == clock2[j]) {
                pi[i] = ++j;
            }
        }
    }

    static void KMP() {
        failureFunction();
        int j = 0;
        for(int i=0; i<SIZE*2; i++) {
            while(j > 0 && clock1[i] != clock2[j]) {
                j = pi[j-1];
            }
            if( clock1[i] == clock2[j]) {
                if( j == SIZE-1) {
                    sb.append("possible");
                    return;
                }
                else j++;
            }
        }
        sb.append("impossible");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        clock1 = new int[SIZE*2];
        clock2 = new int[SIZE];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(st.nextToken());
            clock1[input] = 1;
            clock1[SIZE+input] = 1;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(st.nextToken());
            clock2[input] = 1;
        }

        KMP();
        System.out.println(sb);
    }
}

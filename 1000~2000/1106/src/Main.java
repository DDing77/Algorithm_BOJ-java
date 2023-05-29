import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int C, N;
    static int res = Integer.MAX_VALUE;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        values = new int[C+ 101];
        Arrays.fill(values, Integer.MAX_VALUE);

        values[0] = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for(int j=people; j<C+101; j++) {
                if(values[j-people] != Integer.MAX_VALUE){
                    values[j] = Math.min(values[j], cost + values[j-people]);
                }
            }
        }
        for(int i=C; i<C+101; i++) res = Math.min(res, values[i]);
        System.out.println(res);
    }
}

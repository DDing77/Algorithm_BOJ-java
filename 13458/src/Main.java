import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] Class;
    static int N, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Class = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            Class[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long cnt = 0;
        for(int i=0; i<N; i++) {
            int cur = Class[i];
            cur  = cur - B;
            cnt++;
            if(cur >0) {
                if(cur%C == 0) cnt += cur/C;
                else {
                    cnt += (cur/C) + 1;
                }
            }
        }
        System.out.println(cnt);
    }
}

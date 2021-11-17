import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] house;
    static int N, wifi;
    static boolean determine(int d){
        int cnt=1;
        int last = house[0];
        for( int i=1; i<N; i++) {
            if(house[i] - last >= d){
                cnt++;
                last= house[i];
            }
        }
        return cnt >= wifi;
    }

    static void param_search() {
        int ans=0;
        int L=0, R = 1000000000;
        while(L<=R) {
            int mid= (L+R)/2;
            if(determine(mid)) {
                ans= mid;
                L = mid +1;
            } else {
                R = mid -1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        wifi = Integer.parseInt(st.nextToken());

        house  = new int[N];
        for(int i=0; i<N;i ++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        param_search();
    }
}

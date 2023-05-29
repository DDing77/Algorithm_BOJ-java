import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long[] card;

    static void getMode() {
        Arrays.sort(card,1, N+1);
        long mode = card[1];
        int modeCnt = 1, curCnt = 1;

        for(int i = 2; i<=N; i++) {
            if(card[i] == card[i-1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }
            if( modeCnt < curCnt) {
                modeCnt = curCnt;
                mode= card[i];
            }
        }
        System.out.println(mode);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        card = new long[N+1];


        for(int i=1; i<=N; i++) {
            card[i]= Long.parseLong(br.readLine());
        }

        getMode();
    }
}

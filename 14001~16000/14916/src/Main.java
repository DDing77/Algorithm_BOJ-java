import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int solution(){
        int cnt = 0;
        if(N <= 1 || N == 3 ) return -1;
        if(N % 5 == 0) return cnt = N/5;
        if(((N % 5) %2) == 1){
            int Q = (N / 5) -1;
            cnt = Q + (N - (Q * 5)) / 2;
        }
        else {
            int Q = N/5;
            cnt =Q + (N - (Q * 5)) / 2;
            return cnt;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(solution());
    }
}

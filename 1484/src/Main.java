import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int G;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        G = Integer.parseInt(br.readLine());

        boolean isPossible = false;
        long L = 1;
        long R = 2;
        while(R < 100_000){
            long leftValue = L * L ;
            long rightValue = R * R ;
            long diff = rightValue - leftValue;
            if(diff == G) {
                isPossible = true;
                sb.append(R).append('\n');
            }
            if(diff > G) L++;
            else {
                R++;
            }
        }

        if(isPossible) System.out.print(sb);
        else System.out.println(-1);

    }
}

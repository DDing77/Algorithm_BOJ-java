import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] numCount = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        long sum =0;
        for(int i=0; i<str.length(); i++) {
            int subNum = Integer.parseInt(str.substring(i, i+1));
            numCount[subNum] += 1;
            sum += subNum;
        }

        if(numCount[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        for(int i=10; i>=0; i--) {
            while(numCount[i] >0) {
                sb.append(i);
                numCount[i]--;
            }
        }
        System.out.println(sb);
    }
}

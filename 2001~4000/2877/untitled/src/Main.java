import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int start = 1;
        String temp = "";
        int res = 0;

        N++;

        while (N != 0) {
            res = N % 2;
            temp += res;
            N /= 2;
        }
        for(int i = temp.length()-2; i>=0; i--) {
            if(temp.charAt(i) == '0') sb.append(4);
            else sb.append(7);
        }
        System.out.println(sb);
    }
}

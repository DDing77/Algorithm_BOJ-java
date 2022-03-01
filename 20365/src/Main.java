import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();
        int blueSub = 0;
        int redSub = 0;
        if(input.charAt(0) == 'B') blueSub++;
        else redSub++;

        for(int i=1; i<N; i++) {
            if(input.charAt(i-1) != input.charAt(i)) {
                if(input.charAt(i) == 'R') {
                    redSub++;
                } else blueSub++;
            }
        }

        if( redSub >= blueSub) {
            System.out.println(blueSub+1);
        } else {
            System.out.println(redSub+1);
        }

    }
}

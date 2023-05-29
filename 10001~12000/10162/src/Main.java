import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;
        int c = 0;

        int t = Integer.parseInt(br.readLine());
        while(t >= 10) {
            if(t >= 300) {
                t -= 300;
                a++;
            } else if(t >= 60) {
                t -= 60;
                b++;
            } else if(t >= 10) {
                t -= 10;
                c++;
            }
        }
        System.out.println(t == 0 ? a + " " + b + " " + c : -1);
    }
}
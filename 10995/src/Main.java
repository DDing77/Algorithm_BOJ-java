import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i< N; i++) {
            for(int j=0; j< 2 *N; j++) {
                if( (i + j) % 2 == 0) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
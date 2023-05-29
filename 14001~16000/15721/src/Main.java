import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int A, T, ZorO;
    static int round= 0;
    static int BBUN =0;
    static int DEGI = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        ZorO = Integer.parseInt(br.readLine());
        while(true) {
            round++;
            for(int i=0; i<4; i++) {
                if(i %2 ==0) BBUN++;
                else DEGI++;
                if(BBUN == T && ZorO == 0) {
                    System.out.println((BBUN + DEGI - 1) % A);
                    return;
                }
                if(DEGI == T && ZorO == 1) {
                    System.out.println((BBUN + DEGI - 1) % A);
                    return;
                }
            }

            for(int i=0; i<round+1; i++) {
                BBUN++;
                if(BBUN == T && ZorO == 0) {
                    System.out.println((BBUN + DEGI - 1) % A);
                    return;
                }
            }
            for(int i=0; i<round+1; i++) {
                DEGI++;
                if(DEGI == T && ZorO == 1) {
                    System.out.println((BBUN + DEGI - 1) % A);
                    return;
                }
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 1000000000;
    static long X , Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        long Z = (Y*100)/X ;

        if( Z >= 99) {
            System.out.println(-1);
            return;
        }
        long L =0, R = MAX;
        long index =0;
        while(L <=R) {
            long mid = (L+ R) / 2;
            long newZ = (((Y+mid)* 100) / (X+mid));
            if( newZ <= Z) {
                index = mid+1;
                L = mid +1;
            }
            else {
                R = mid -1;
            }
        }
        System.out.println(index);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int n;

    static long f(int k) {
        int ans = 0;
        for(int i =1; i * i <=k; i++) ans += (arr[i]*(k/(i*i)));
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n  = Integer.parseInt(br.readLine());

        arr = new int[1010100];

        Arrays.fill(arr , 1);
        for(int i = 2; i*i<=1000000; i++) {
            if(arr[i] == 1) {
                for(int j = i; j<= 1000000; j += i) arr[j] *= -i;
                for(int j= i * i; j<= 1000000; j += i *i ) arr[j] = 0;
            }
        }
        for(int i = 2; i<=1000000; i++) {
            if(arr[i] == i) arr[i] = 1;
            else if ( arr[i] == -i) arr[i] = -1;
            else if ( arr[i] < 0) arr[i] = 1;
            else if ( arr[i] > 0) arr[i] = -1;
        }

        int l = 0;
        int r = (int) 1e12;

        while(l +1 < r) {
            int mid = (l + r) / 2;
            if(f(mid)< n) l = mid;
            else r = mid;
        }

        System.out.println(r);


    }
}

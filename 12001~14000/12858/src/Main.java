import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, Q;
    static long[] arr;
    static long[] tree;
    static long[] lazy;
    static long[]
    static long gcd(long a, long b) {
        if( b ==0) return a;
        return gcd(b, a%b);
    }

    static long initTD(int left, int right, int nodeNum) {
        if( left == right) return tree[nodeNum] = arr[left];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N + 1];
        int startLeaf = 1;
        while (startLeaf < N) startLeaf *= 2;
        int length = startLeaf *2;

        tree = new long[length+1];
        lazy = new long[length+1];


    }
}

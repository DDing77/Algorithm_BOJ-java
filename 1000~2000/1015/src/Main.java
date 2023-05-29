import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class B implements Comparable<B> {
        public int value;
        public int index;

        @Override
        public int compareTo(B o) {
            if(value != o.value) return value - o.value;
            return index - o.index;
        }

    }
    static void getP() {
        for(int b_index =0; b_index<N; b_index++) {
            p[b[b_index].index] = b_index;
        }
    }
    static int N;
    static B[] b;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        b= new B[N];
        p = new int[N];
        st = new StringTokenizer(br.readLine());
        for( int i=0; i<N; i++) {
            b[i] =new B();
            b[i].value = Integer.parseInt(st.nextToken());
            b[i].index = i;
        }

        Arrays.sort(b);
        getP();
        for(int i=0; i<N; i++){
            sb.append(p[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}

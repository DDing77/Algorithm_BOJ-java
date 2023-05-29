import java.io.*;
import java.util.StringTokenizer;

public class Main { // BOJ_21918
//    static class Light{
//
//    }

    static void oneFunc(int i, int x) {
        Light[i-1] = x;
    }

    static void twoFunc(int l, int r) {
        for (int i = l-1; i < r; i++) {
            if (Light[i] == 1) Light[i] = 0;
            else Light[i] = 1;
        }
    }

    static void threeFunc(int l, int r) {
        for (int i = l-1; i < r; i++) {
            Light[i] = 0;
        }
    }

    static void fourFunc(int l, int r) {
        for (int i = l-1; i < r; i++) {
            Light[i] = 1;
        }
    }

    static int[] Light;
    static int N, M, a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Light = new int[N];
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Light[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            switch (a){
                case 1:
                    oneFunc(b, c);
                    break;
                case 2:
                    twoFunc(b, c);
                    break;
                case 3:
                    threeFunc(b,c);
                    break;
                case 4:
                    fourFunc(b,c);
                    break;
                default:
                    break;
            }
        }

        for(int i=0; i<N; i++) {
            System.out.print(Light[i] + " ");
        }
    }
}

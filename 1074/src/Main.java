import java.util.*;
import java.io.*;
public class Main { // BOJ_1074
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        dc(size, r, c);
        System.out.println(count);
    }
    static void dc(int size, int r, int c) {
        if(size == 1) return;
        if(r < size/2 && c < size/2) dc(size/2,r,c);
        else if(r < size/2 && c >= size/2) {
            count += size * size /4;
            dc(size/2, r , c- size/2);
        } else if(r >= size/2 && c < size/2) {
            count += (size * size /4) * 2;
            dc(size/2, r-size/2, c);
        } else {
            count += (size *size/4)*3;
            dc(size/2, r-size/2, c-size/2);
        }
    }
}

import java.io.*;
import java.util.StringTokenizer;
public class _1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a > b) {
            bw.write(">" + "\n");
        } else if ( a < b) {
            bw.write("<" + "\n");
        } else {
            bw.write("==" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

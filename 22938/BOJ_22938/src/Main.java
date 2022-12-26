import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int X;
        int Y;
        int R;

        public Info(int X, int Y, int R) {
            this.X = X;
            this.Y = Y;
            this.R = R;
        }
    }

    static Info[] infos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        infos = new Info[2];
        st = new StringTokenizer(br.readLine());
        infos[0] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        infos[1] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        double distance = Math.pow(Math.abs(infos[0].X - infos[1].X), 2) + Math.pow(Math.abs(infos[0].Y - infos[1].Y), 2);
        if (Math.pow(infos[0].R + infos[1].R, 2) > distance) System.out.println("YES");
        else System.out.println("NO");
    }
}

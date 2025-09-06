import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private void solution() throws IOException {

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            Pos a = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            Pos b = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            Pos c = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            Pos d = new Pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

            double resX = .0;
            double resY = .0;

            if (a.equals(c)) {
                resX = b.x + d.x - a.x;
                resY = b.y + d.y - a.y;
            } else if (a.equals(d)) {
                resX = b.x + c.x - a.x;
                resY = b.y + c.y - a.y;
            } else if (b.equals(c)) {
                resX = a.x + d.x - b.x;
                resY = a.y + d.y - b.y;
            } else if (b.equals(d)) {
                resX = a.x + c.x - b.x;
                resY = a.y + c.y - b.y;
            }

            sb.append(String.format("%.3f", resX)).append(" ").append(String.format("%.3f", resY)).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Pos {
        double x;
        double y;

        public Pos(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return Double.compare(x, pos.x) == 0 && Double.compare(y, pos.y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

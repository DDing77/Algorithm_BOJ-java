import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final double PI = 3.1415927;

    private void solution() throws IOException {

        int tc = 1;
        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            double radius = Double.parseDouble(st.nextToken());
            double rotate = Double.parseDouble(st.nextToken());
            double time = Double.parseDouble(st.nextToken());

            if (rotate == 0.0) {
                continue;
            }

            double totalDistance = (((PI * radius) * rotate) / 12) / 5280.0;
            double mph = (totalDistance / time) * 3600.0;
            sb.append("Trip #").append(tc++).append(": ").append(String.format("%.2f", totalDistance))
                    .append(" ").append(String.format("%.2f", mph)).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

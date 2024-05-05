import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private double height;
    private double weight;
    private double BMI;

    private double getBMI(double height, double weight) {

        height /= 100;
        height = Math.pow(height, 2);
        return weight / height;
    }


    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            height = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            BMI = getBMI(height, weight);

            if (height < 140.1) {
                sb.append(6);
            } else if (height < 146.0) {
                sb.append(5);
            } else if (height < 159.0) {
                sb.append(4);
            } else if (height < 161.0) {
                if (16.0 <= BMI && BMI < 35.0) {
                    sb.append(3);
                } else {
                    sb.append(4);
                }
            } else if (height < 204.0) {
                if (20.0 <= BMI && BMI < 25.0) {
                    sb.append(1);
                } else if ((18.5 <= BMI && BMI < 20.0) || (25.0 <= BMI && BMI < 30.0)) {
                    sb.append(2);
                } else if ((16.0 <= BMI && BMI < 18.5) || (30.0 <= BMI && BMI < 35.0)) {
                    sb.append(3);
                } else {
                    sb.append(4);
                }
            } else {
                sb.append(4);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

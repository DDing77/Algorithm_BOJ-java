import java.io.IOException;

public class Main {

    public static void solution() {
        StringBuilder sb = new StringBuilder();

        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= a; b++) {
                for (int c = b; c <= a; c++) {
                    for (int d = c; d <= a; d++) {
                        if (a * a * a == (b * b * b) + (c * c * c) + (d * d * d)) {
                            sb.append("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")").append('\n');
                        }
                    }
                }
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}

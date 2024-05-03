import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int size;

    private void printType1(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append("@");
            }
            for (int j = 0; j < size * 3; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < size; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }

    private void printType2(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append("@");
            }
            for (int j = 0; j < size * 2; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < size; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }

    private void printType3(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size * 3; j++) {
                sb.append("@");
            }
            sb.append("\n");
        }
    }

    private void solution() throws IOException {

        size = Integer.parseInt(br.readLine());

        printType1(size);
        printType2(size);
        printType3(size);
        printType2(size);
        printType1(size);

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

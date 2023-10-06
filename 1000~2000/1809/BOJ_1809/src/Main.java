import java.io.IOException;

public class Main {

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("(___)").append('\n');
        sb.append("(o o)____/").append('\n');
        sb.append(" @@      \\").append('\n');
        sb.append("  \\ ____,/").append('\n');
        sb.append("  //   //").append('\n');
        sb.append(" ^^   ^^");

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

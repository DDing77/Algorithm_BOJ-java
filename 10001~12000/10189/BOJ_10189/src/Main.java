import java.io.*;

public class Main {

    public void solution() {
        StringBuilder sb = new StringBuilder();

        sb.append("#  # #### #### #  #").append('\n');
        sb.append("#### #  # #  # # #").append('\n');
        sb.append("#### #  # #  # # #").append('\n');
        sb.append("#  # #### #### #  #");

        System.out.println(sb);
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}
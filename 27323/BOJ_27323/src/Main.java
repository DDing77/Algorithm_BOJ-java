public class Main {

    public static int read() throws Exception {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void solution() throws Exception {
        System.out.println(read() * read());
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}

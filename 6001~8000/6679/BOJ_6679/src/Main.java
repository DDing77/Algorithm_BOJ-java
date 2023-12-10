public class Main {

    final int MIN = 1_000;
    final int MAX = 9_999;

    public int decimalToBaseType(int decimal, int type) {
        int result = 0;

        while (decimal > 0) {
            result += decimal % type;
            decimal /= type;
        }
        return result;
    }

    public void solution() {
        StringBuilder sb = new StringBuilder();

        for (int i = MIN; i <= MAX; i++) {
            int decimal10 = decimalToBaseType(i, 10);
            int decimal12 = decimalToBaseType(i, 12);
            int decimal16 = decimalToBaseType(i, 16);
            if (decimal10 == decimal12 && decimal10 == decimal16) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}

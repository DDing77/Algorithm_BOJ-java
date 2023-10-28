public class Main {

    public void solution() {
        StringBuilder sb = new StringBuilder();

        sb.append(" _________").append('\n');
        sb.append(" \\_     _/").append('\n');
        sb.append("   \\   /").append('\n');
        sb.append("    | |").append('\n');
        sb.append("   /   \\").append('\n');
        sb.append("  /     \\").append('\n');
        sb.append(" |       |").append('\n');
        sb.append("/---------\\").append('\n');
        sb.append("| \\-/ \\-/ |").append('\n');
        sb.append("\\---------/").append('\n');
        sb.append(" \\_______/").append('\n');

        System.out.print(sb);
    }

    public static void main(String[] args) {
        new Main().solution();
    }
}

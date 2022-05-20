import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        date.minusHours(9);
        System.out.println(date.getYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());
    }
}

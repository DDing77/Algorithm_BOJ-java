import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    static SimpleDateFormat format;
    static Date date;
    public static void main(String[] args) {
        format = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date();
        System.out.println(format.format(date));
    }
}

package kryo;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int startDate = scanner.nextInt();
        Vacation vacation = new Vacation(LocalDate.of(year, month, startDate),
                new City(), new Ticket());
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        kryoObjectSerializer.serializeObject(vacation);
    }
}
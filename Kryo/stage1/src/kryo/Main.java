package kryo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        scanner.nextLine();
        boolean darkWizard = Boolean.parseBoolean(scanner.nextLine());
        Wizard wizard = new Wizard(name, age, darkWizard);
        KryoObjectSerializer kryoObjectSerializer = new KryoObjectSerializer();
        kryoObjectSerializer.doSerialization(wizard);
    }
}
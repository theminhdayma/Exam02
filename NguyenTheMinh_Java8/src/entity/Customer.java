package entity;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp {
    private static int count = 1;
    private int id;
    private String name;
    private Optional<String> email;

    public Customer() {
        this.id = count++;
    }

    public Customer(int id, String name, String email) {
        this.id = count ++;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên khách hàng: ");
        this.name = scanner.nextLine();

        System.out.print("Nhập email: ");
        String emailInput = scanner.nextLine().trim();
        this.email = emailInput.isEmpty() ? Optional.empty() : Optional.of(emailInput);
    }


    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + name + ", Email: " + email.orElse("Không có");
    }
}

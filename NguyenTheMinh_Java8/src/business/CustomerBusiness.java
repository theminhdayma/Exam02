package business;

import entity.Customer;
import presentation.ShopManagement;
import java.util.Scanner;

public class CustomerBusiness {

    public static void addCustomer(Scanner scanner) {
        Customer customer = new Customer();
        System.out.println("Nhập thông tin khách hàng:");
        customer.inputData(scanner);
        ShopManagement.ListCustomer.add(customer);
        System.out.println("Khách hàng đã được thêm thành công!");
    }

    public static void displayCustomers() {
        if (ShopManagement.ListCustomer.isEmpty()) {
            System.out.println("Không có khách hàng nào trong danh sách.");
        } else {
            System.out.println("Danh sách khách hàng:");
            ShopManagement.ListCustomer.forEach(System.out::println);
        }
    }
}

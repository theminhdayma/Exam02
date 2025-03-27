package entity;

import presentation.ShopManagement;
import java.time.LocalDate;
import java.util.Scanner;

public class Order implements IApp {
    private static int count = 1;
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Order() {
        this.id = count++;
        this.orderDate = LocalDate.now();
        this.status = false;
    }

    public Order(int id, Customer customer, LocalDate orderDate, double totalAmount, boolean status) {
        this.id = count ++;
        this.customer = customer;
        this.orderDate = LocalDate.now();
        this.totalAmount = totalAmount;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập thông tin đơn hàng:");

        Customer foundCustomer = null;
        while (true) {
            System.out.print("Nhập ID khách hàng: ");
            int customerId = scanner.nextInt();

            for (Customer c : ShopManagement.ListCustomer) {
                if (c.getId() == customerId) {
                    foundCustomer = c;
                    break;
                }
            }

            if (foundCustomer != null) {
                break;
            }

            System.out.println("Khách hàng không tồn tại! Vui lòng nhập lại.");
        }

        this.customer = foundCustomer;

        System.out.print("Nhập tổng tiền đơn hàng: ");
        this.totalAmount = scanner.nextDouble();
    }


    @Override
    public String toString() {
        return "id= " + id + ", Tên khách hàng = " + customer.getName() + "Ngày đặt hàng = " + orderDate + ", Tổng tiền= " + totalAmount + ", status= " + (status? "Đã giao": "Chưa giao");
    }
}

package business;

import entity.Customer;
import entity.Order;
import presentation.ShopManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderBusiness implements IOrderBusiness {

    @Override
    public void addOrder(Scanner scanner) {
        System.out.println("Thêm đơn hàng mới:");
        Order order = new Order();
        order.inputData(scanner);
        ShopManagement.ListOrder.add(order);
        System.out.println("Đơn hàng đã được thêm thành công!");
    }

    @Override
    public void displayOrders() {
        if (ShopManagement.ListOrder.isEmpty()) {
            System.out.println("Không có đơn hàng nào.");
            return;
        }
        ShopManagement.ListOrder.forEach(System.out::println);
    }

    @Override
    public void updateOrderStatus(Scanner scanner) {
        System.out.print("Nhập ID đơn hàng cần cập nhật trạng thái: ");
        int orderId = scanner.nextInt();
        for (Order order : ShopManagement.ListOrder) {
            if (order.getId() == orderId) {
                order.setStatus(true);
                System.out.println("Trạng thái đơn hàng đã được cập nhật thành 'Đã giao'.");
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng có ID: " + orderId);
    }

    @Override
    public List<Order> getOrderOverdue() {
        return ShopManagement.ListOrder.stream()
                .filter(order -> order.getOrderDate().isBefore(LocalDate.now().minusDays(30)) && !order.isStatus())
                .toList();
    }
}

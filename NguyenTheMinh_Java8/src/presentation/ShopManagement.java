package presentation;

import business.CustomerBusiness;
import business.OrderBusiness;
import entity.Customer;
import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static final List<Customer> ListCustomer = new ArrayList<Customer>();
    public static final List<Order> ListOrder = new ArrayList<Order>();
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("-------------MENU SHOP-------------");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            System.out.printf("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showMenuCustomer();
                    break;
                case 2:
                    showMenuOrder();
                    break;
                case 3:
                    System.out.println("Thoát...!!!");
                    break;
                default:
                    System.out.println("Không hợp lệ, chọn từ 1 đến 3");
            }
        }while (choice != 3);
    }

    public static void showMenuCustomer() {
        CustomerBusiness customerBusiness = new CustomerBusiness();
        int choice;
        do {
            System.out.println("---------------MENU CUSTOMER--------------");
            System.out.println("1. Danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Quay lại Menu chính");
            System.out.printf("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customerBusiness.displayCustomers();
                    break;
                case 2:
                    customerBusiness.addCustomer(scanner);
                    break;
                case 3:
                    System.out.println("Thoát...!!!");
                    break;
                default:
                    System.out.println("Không hợp lệ, chọn từ 1 đến 3");
            }
        }while (choice != 3);
    }

    public static void showMenuOrder() {
        OrderBusiness orderBusiness = new OrderBusiness();
        int choice;
        do {
            System.out.println("---------------MENU ORDER--------------");
            System.out.println("1. Danh sách đơn hàng");
            System.out.println("2. Thêm mới đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng");
            System.out.println("4. Danh sách đơn hàng quá hạn");
            System.out.println("5. Thống kê số lượng đơn hàng đã giao");
            System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao");
            System.out.println("7. Quay lại Menu chính");
            System.out.printf("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    orderBusiness.displayOrders();
                    break;
                case 2:
                    orderBusiness.addOrder(scanner);
                    break;
                case 3:
                    orderBusiness.updateOrderStatus(scanner);
                    break;
                case 4:
                    List<Order> overdueOrders = orderBusiness.getOrderOverdue();
                    if (overdueOrders.isEmpty()) {
                        System.out.println("Không có đơn hàng quá hạn.");
                    } else {
                        System.out.println("Danh sách đơn hàng quá hạn:");
                        overdueOrders.forEach(System.out::println);
                    }
                    break;
                case 5:
                    long deliveredOrders = ListOrder.stream().filter(Order::isStatus).count();
                    System.out.println("Số lượng đơn hàng đã giao: " + deliveredOrders);
                    break;
                case 6:
                    double totalRevenue = orderBusiness.getTotalRevenue(ListOrder);
                    System.out.println("Tổng doanh thu từ đơn hàng đã giao: " + totalRevenue);
                    break;
                case 7:
                    System.out.println("Quay lại Menu chính...");
                    break;
                default:
                    System.out.println("Không hợp lệ, chọn từ 1 đến 7");
            }
        } while (choice != 7);
    }
}

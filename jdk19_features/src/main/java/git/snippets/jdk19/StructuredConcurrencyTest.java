//package git.snippets.jdk19;
//
//import jdk.incubator.concurrent.StructuredTaskScope;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
///**
// * 预览功能
// * 控制台运行
// * 1. 配置Java运行环境是JDK 19
// * 2. 注释掉 package 路径
// * 3. 在本代码的目录下执行
// * 编译：javac --enable-preview -source 19 --add-modules jdk.incubator.concurrent StructuredConcurrencyTest.java
// *运行：java --enable-preview --add-modules jdk.incubator.concurrent StructuredConcurrencyTest
// * @author <a href="mailto:410486047@qq.com">Grey</a>
// * @date 2022/9/22
// * @since 19
// */
//public class StructuredConcurrencyTest {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new StructuredConcurrencyTest().createInvoiceSinceJava19(1, 2, "ZH");
//    }
//
//    private final ExecutorService executor = Executors.newCachedThreadPool();
//
//    // jdk 19 之前
//    public Invoice createInvoice(int orderId, int customerId, String language) throws ExecutionException, InterruptedException {
//        Future<Order> orderFuture = executor.submit(() -> loadOrderFromOrderService(orderId));
//
//        Future<Customer> customerFuture = executor.submit(() -> loadCustomerFromDatabase(customerId));
//
//        Future<String> invoiceTemplateFuture = executor.submit(() -> loadInvoiceTemplateFromFile(language));
//
//        Order order = orderFuture.get();
//        Customer customer = customerFuture.get();
//        String invoiceTemplate = invoiceTemplateFuture.get();
//
//        return Invoice.generate(order, customer, invoiceTemplate);
//    }
//
//
//    // jdk 19 之后
//    public Invoice createInvoiceSinceJava19(int orderId, int customerId, String language)
//            throws ExecutionException, InterruptedException {
//        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
//            Future<Order> orderFuture =
//                    scope.fork(() -> loadOrderFromOrderService(orderId));
//
//            Future<Customer> customerFuture =
//                    scope.fork(() -> loadCustomerFromDatabase(customerId));
//
//            Future<String> invoiceTemplateFuture =
//                    scope.fork(() -> loadInvoiceTemplateFromFile(language));
//
//            scope.join();
//            scope.throwIfFailed();
//
//            Order order = orderFuture.resultNow();
//            Customer customer = customerFuture.resultNow();
//            String invoiceTemplate = invoiceTemplateFuture.resultNow();
//
//            return new Invoice(order, customer, invoiceTemplate);
//        }
//    }
//
//    private String loadInvoiceTemplateFromFile(String language) {
//        return language;
//    }
//
//    private Customer loadCustomerFromDatabase(int customerId) {
//        return new Customer(customerId);
//    }
//
//    private Order loadOrderFromOrderService(int orderId) {
//        return new Order(orderId);
//    }
//}
//
//class Invoice {
//    // TODO
//    public Invoice(Order order, Customer customer, String invoiceTemplate) {
//
//    }
//
//    public static Invoice generate(Order order, Customer customer, String invoiceTemplate) {
//        return null;
//    }
//}
//
//class Order {
//    private int id;
//
//    public Order(int orderId) {
//        this.id = orderId;
//    }
//}
//
//class Customer {
//    private int id;
//
//    public Customer(int customerId) {
//        this.id = customerId;
//    }
//}
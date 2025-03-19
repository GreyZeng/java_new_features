package git.snippets.jdk24;

import java.util.concurrent.*;

/**
 * 结构化并发 第四次预览
 */

// 传统方式
public class StructuredConcurrencyExample {
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        structuredConcurrency();
    }

    // 传统方式
    public static void traditionalConcurrency() throws ExecutionException, InterruptedException {
        Future<String> userFuture = executor.submit(() -> fetchUserData());
        Future<String> orderFuture = executor.submit(() -> fetchOrderData());

        try {
            String userData = userFuture.get(); // 阻塞直到用户数据返回
            String orderData = orderFuture.get(); // 阻塞直到订单数据返回
            System.out.println("用户: " + userData + ", 订单: " + orderData);
        } finally {
            executor.shutdown();
        }
    }

    // 新的方式
    public static void structuredConcurrency() throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            StructuredTaskScope.Subtask<String> userTask = scope.fork(() -> fetchUserData());
            StructuredTaskScope.Subtask<String> orderTask = scope.fork(() -> fetchOrderData());

            scope.join();  // 等待所有任务完成
            scope.throwIfFailed();  // 如果有任务失败，取消所有任务并抛出异常

            String userData = userTask.get();
            String orderData = orderTask.get();
            System.out.println("用户: " + userData + ", 订单: " + orderData);
        }
    }

    static String fetchUserData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "用户数据";
    }

    static String fetchOrderData() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "订单数据";
    }
}
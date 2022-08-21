package git.snippets.jdk15;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/21
 * @since 15
 */
public class SealedClassTest2 {
//    public static void main(String[] args) {
//        getId(new Employee());
//    }
//
//    public static String getId(Object person) {
//        if (person instanceof Employee) {
//            return ((Employee) person).getEmployeeId();
//        } else if (person instanceof Manager) {
//            return ((Manager) person).getSupervisorId();
//        }
//        return null;
//    }
}

//abstract sealed class Person permits Employee, Manager {
//
//    //...
//}
//
//final class Employee extends Person {
//    private String employeeId;
//
//    public String getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(String employeeId) {
//        this.employeeId = employeeId;
//    }
//}
//
//non-sealed class Manager extends Person {
//    private String supervisorId;
//
//    public void setSupervisorId(String supervisorId) {
//        this.supervisorId = supervisorId;
//    }
//
//    public String getSupervisorId() {
//        return supervisorId;
//    }
//}
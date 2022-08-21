package git.snippets.jdk14;

import java.util.ArrayList;

/**
 * instanceof自动命名(预览功能）
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 14
 */
public class InstanceofInJdk14 {
    public static void main(String[] args) {
        Object obj = new H();
        // Before Java 14:
        if (obj instanceof H) {
            H jd1 = (H) obj;
            jd1.setId(1);
        }
        // Java 14+
//        if (obj instanceof H jd2) {
//            jd2.setId(1);
//        }
    }
}

class H {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
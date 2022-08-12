package git.snippets.jdk7;

/**
 * @author <a href="mailto:410486047@qq.com">GreyZeng</a>
 * @version 1.0, 2022/8/12
 * @since 1.7
 */
public class CatchExceptionTest {
    // jdk1.7之前
    void catchExPre(String exceptionName) throws SecondException, FirstException {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (FirstException | SecondException e) {
            throw e;
        }
    }

    void catchEx(String exceptionName) throws FirstException, SecondException {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (FirstException e) {
            throw e;
        } catch (SecondException e) {
            throw e;
        }
    }

    public void rethrowException(String exceptionName) throws Exception {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

class FirstException extends Exception {
}

class SecondException extends Exception {
}

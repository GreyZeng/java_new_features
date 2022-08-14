package git.snippets.jdk9;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;

/**
 * 注意：添加module-info信息
 * jdk11已经把包移入：java.net.http
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/8/14
 * @since 9
 */
public class HttpClientTestJDK9 {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://httpbin.org/get");
        HttpRequest req = HttpRequest.newBuilder(uri).header("accept", "application/json").GET().build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandler.asString());
        String body = resp.body();
        System.out.println(body);
    }
}

package git.snippets.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * jdk9 中httpclient还在jdk.incubator.httpclient模块中
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/11/29
 * @since 11
 */
public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://httpbin.org/get");
        HttpRequest req = HttpRequest.newBuilder(uri).header("accept", "application/json").GET().build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        String body = resp.body();
        System.out.println(body);
    }
}

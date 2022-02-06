package my.gcp.cloudtest.web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test for local or remote service based on the env var
 * "SERVICE_URL". See java/CONTRIBUTING.MD for more information. 
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HelloWorldControllerIT {

  @LocalServerPort private int port;

  @Test
  public void respondsToHttpRequest(@LocalServerPort int port) throws IOException {

    String url = "http://localhost:" + port;
    String token = System.getenv("TOKEN");

    OkHttpClient ok =
        new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build();

    Request request = new Request.Builder().url(url + "/").header("Authorization", "Bearer " + token).get().build();

    String expected = "Congratulations, you successfully deployed a container image to Cloud Run";
    Response response = ok.newCall(request).execute();
    ResponseBody body = response.body();
    assertThat(body).isNotNull();
    assertThat(body.string()).contains(expected);
    assertThat(response.code()).isEqualTo(200);
  }
}

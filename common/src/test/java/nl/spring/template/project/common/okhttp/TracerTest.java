package nl.spring.template.project.common.okhttp;

import nl.spring.template.project.common.junit.annotation.UnitTests;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

@UnitTests
class TracerTest {


    @Test
    void testWithoutCorrelationIdHeader() {

        //Arrange
        final OkHttpClient client = new OkHttpClient()
            .newBuilder()
            .addInterceptor(new BaseUrlInterceptor("http://google.com"))
            .build();
        final Request request = new Request
            .Builder()
            .url("http://xx.com/integrator-config/www.nu.nl-nl.json")
            .build();
        final Call call = client.newCall(request);

        // Act
        try (final Response response = call.execute()) {
            var r = response;
        } catch (IOException e) {
            fail(e);
        }
    }

}
package com.github.johan.backstrom.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.util.Map;

public class RestCallsTests {

    private static final MediaType JSON  = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper mapper = new ObjectMapper();

    private String url = "http://localhost:8080/v1/quote";

    @Test
    public void volvoCosts1000() throws IOException {

        //TODO: Implement!

        assertThat(true, is(true));
    }

    Map<String,String> post(String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().string(), new TypeReference<Map<String, String>>(){});
    }
}
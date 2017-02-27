<<<<<<< HEAD
<<<<<<< HEAD
package org.baeldung.okhttp;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPostingLiveTest {

    private static final String BASE_URL = "http://localhost:8080/spring-rest";
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://browserspy.dk/password-ok.php";

    OkHttpClient client;

    @Before
    public void init() {

    	client = new OkHttpClient();
    }

    @Test
    public void whenSendPostRequest_thenCorrect() throws IOException {
        RequestBody formBody = new FormBody.Builder()
          .add("username", "test")
          .add("password", "test")
          .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/users")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenSendPostRequestWithAuthorization_thenCorrect() throws IOException {
        String postBody = "test post";

        Request request = new Request.Builder()
                .url(URL_SECURED_BY_BASIC_AUTHENTICATION)
                .addHeader("Authorization", Credentials.basic("test", "test"))
                .post(RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), postBody))
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenPostJson_thenCorrect() throws IOException {
        String json = "{\"id\":1,\"name\":\"John\"}";

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        Request request = new Request.Builder()
            .url(BASE_URL + "/users/detail")
            .post(body)
            .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenSendMultipartRequest_thenCorrect() throws IOException {
        RequestBody requestBody = new MultipartBody.Builder()
          .setType(MultipartBody.FORM)
          .addFormDataPart("username", "test")
          .addFormDataPart("password", "test")
          .addFormDataPart("file", "file.txt",
            RequestBody.create(MediaType.parse("application/octet-stream"), new File("src/test/resources/test.txt")))
          .build();

        Request request = new Request.Builder()
            .url(BASE_URL + "/users/multipart")
            .post(requestBody)
            .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }
}
=======
package org.baeldung.okhttp;

import static org.baeldung.client.Consts.APPLICATION_PORT;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.junit.Before;
import org.junit.Test;

public class OkHttpPostingLiveTest {

    private static final String BASE_URL = "http://localhost:" + APPLICATION_PORT + "/spring-rest";
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://browserspy.dk/password-ok.php";

    OkHttpClient client;

    @Before
    public void init() {

        client = new OkHttpClient();
    }

    @Test
    public void whenSendPostRequest_thenCorrect() throws IOException {
        final RequestBody formBody = new FormBody.Builder().add("username", "test").add("password", "test").build();

        final Request request = new Request.Builder().url(BASE_URL + "/users").post(formBody).build();

        final Call call = client.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenSendPostRequestWithAuthorization_thenCorrect() throws IOException {
        final String postBody = "test post";

        final Request request = new Request.Builder()
          .url(URL_SECURED_BY_BASIC_AUTHENTICATION)
          .addHeader("Authorization", Credentials.basic("test", "test"))
          .post(RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), "test post"))
          .build();

        final Call call = client.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenPostJson_thenCorrect() throws IOException {
        final String json = "{\"id\":1,\"name\":\"John\"}";

        final RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"id\":1,\"name\":\"John\"}");
        final Request request = new Request.Builder().url(BASE_URL + "/users/detail").post(body).build();

        final Call call = client.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenSendMultipartRequest_thenCorrect() throws IOException {
        final RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("username", "test").addFormDataPart("password", "test")
                .addFormDataPart("file", "file.txt", RequestBody.create(MediaType.parse("application/octet-stream"), new File("src/test/resources/test.txt"))).build();

        final Request request = new Request.Builder().url(BASE_URL + "/users/multipart").post(requestBody).build();

        final Call call = client.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }
}
>>>>>>> refs/remotes/eugenp/master
=======
package org.baeldung.okhttp;

import static org.baeldung.client.Consts.APPLICATION_PORT;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.junit.Before;
import org.junit.Test;

public class OkHttpPostingLiveTest {

    private static final String BASE_URL = "http://localhost:" + APPLICATION_PORT + "/spring-rest";
    private static final String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://browserspy.dk/password-ok.php";

    OkHttpClient client;

    @Before
    public void init() {

        client = new OkHttpClient();
    }

    @Test
    public void whenSendPostRequest_thenCorrect() throws IOException {
        final RequestBody formBody = new FormBody.Builder().add("username", "test").add("password", "test").build();

        final Request request = new Request.Builder().url(BASE_URL + "/users").post(formBody).build();

        final Call call = client.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenSendPostRequestWithAuthorization_thenCorrect() throws IOException {
        final String postBody = "test post";

        final Request request = new Request.Builder().url(URL_SECURED_BY_BASIC_AUTHENTICATION).addHeader("Authorization", Credentials.basic("test", "test")).post(RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), "test post")).build();

        final Call call = client.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenPostJson_thenCorrect() throws IOException {
        final String json = "{\"id\":1,\"name\":\"John\"}";

        final RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{\"id\":1,\"name\":\"John\"}");
        final Request request = new Request.Builder().url(BASE_URL + "/users/detail").post(body).build();

        final Call call = client.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void whenSendMultipartRequest_thenCorrect() throws IOException {
        final RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("username", "test").addFormDataPart("password", "test")
                .addFormDataPart("file", "file.txt", RequestBody.create(MediaType.parse("application/octet-stream"), new File("src/test/resources/test.txt"))).build();

        final Request request = new Request.Builder().url(BASE_URL + "/users/multipart").post(requestBody).build();

        final Call call = client.newCall(request);
        final Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }
}
>>>>>>> refs/remotes/eugenp/master
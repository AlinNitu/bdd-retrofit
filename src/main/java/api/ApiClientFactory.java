package api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientFactory {

    private static final String BASE_URL = "http://127.0.0.1:8900/";

    public static Retrofit setupClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

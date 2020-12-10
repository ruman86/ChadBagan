package club.innovinc.bagan;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static final String BASE_URL="http://amol.innovinc.club/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }
}

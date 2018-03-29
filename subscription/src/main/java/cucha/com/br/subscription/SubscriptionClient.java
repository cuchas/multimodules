package cucha.com.br.subscription;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import rx.Observable;

public class SubscriptionClient {
    private final SubscriptionAPI api;
    private static String URL = "https://api.themoviedb.org/3/";
    private static String API_KEY = "1f54bd990f1cdfb230adb312546d765d";
    private static String DEFAULT_LANGUAGE = "pt-BR";
    private static String DEFAULT_REGION = "BR";

    private SubscriptionClient() {
        api = new Retrofit.Builder()
                .baseUrl(URL)
                .client(new OkHttpClient.Builder().build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(SubscriptionAPI.class);
    }

    public static SubscriptionClient newInstance() {
        return new SubscriptionClient();
    }

   public Observable<UpcomingMoviesResponse> listUpcomingMovies() {
        return api.upcomingMovies(API_KEY, DEFAULT_LANGUAGE, 1L, DEFAULT_REGION);
   }
}

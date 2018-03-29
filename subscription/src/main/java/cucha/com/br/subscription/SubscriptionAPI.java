package cucha.com.br.subscription;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

interface SubscriptionAPI {
    @GET("movie/upcoming")
    Observable<UpcomingMoviesResponse> upcomingMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Long page,
            @Query("region") String region
    );
}

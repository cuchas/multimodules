package cucha.com.br.featurea;

import android.content.Context;
import android.content.Intent;
import android.support.v4.media.AudioAttributesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

import cucha.com.br.subscription.Movie;
import cucha.com.br.subscription.SubscriptionClient;
import cucha.com.br.subscription.UpcomingMoviesResponse;
import cucha.com.br.user.UserPreferencesImpl;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class AActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayAdapter<Object> adapter;

    public static Intent newIntent(Context context) {
        return new Intent(context, AActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        setupListView();

        UserPreferencesImpl preferences = UserPreferencesImpl.newInstance(getPreferences(MODE_PRIVATE));
        setTitle(preferences.getUserName());

        SubscriptionClient client = SubscriptionClient.newInstance();

        client.listUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpcomingMoviesResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UpcomingMoviesResponse upcomingMoviesResponse) {

                        List<String> list = new ArrayList<>(upcomingMoviesResponse.results.size());

                        for (Movie result : upcomingMoviesResponse.results) {
                            list.add(result.title);
                        }

                        adapter.addAll(list);
                    }
                });
    }

    private void setupListView() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }
}

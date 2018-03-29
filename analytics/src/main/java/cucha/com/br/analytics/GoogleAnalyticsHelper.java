package cucha.com.br.analytics;


import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import java.util.HashMap;

class GoogleAnalyticsHelper {

    private static final String ID = "UA-82275237-6";
    private final Tracker tracker;

    public GoogleAnalyticsHelper(Context context) {
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
        tracker = analytics.newTracker(ID);
    }

    void track(String name, String category) {
        tracker.send(new HashMap<String, String>());
    }
}

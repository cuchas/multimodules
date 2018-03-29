package cucha.com.br.analytics;


import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Map;

class FbAnalyticsHelper {
    private final FirebaseAnalytics analytics;

    public FbAnalyticsHelper(Context context) {
        analytics = FirebaseAnalytics.getInstance(context);
    }
    void track(String name, Map<String, String> map) {
        Bundle bundle = new Bundle();

        for (String key : map.keySet()) {
            bundle.putString(key, map.get(key));
        }

        analytics.logEvent(name, bundle);
    }
}

package cucha.com.br.analytics;


import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsHelperImpl implements AnalyticsHelper {
    FbAnalyticsHelper fbAnalyticsHelper;
    GoogleAnalyticsHelper googleAnalyticsHelper;
    public static final String CATEGORY = "category";

    public AnalyticsHelperImpl(Context context) {
        fbAnalyticsHelper = new FbAnalyticsHelper(context);
        googleAnalyticsHelper = new GoogleAnalyticsHelper(context);
    }

    @Override
    public void track(String name, String category) {
        Map<String, String> map = new HashMap<>();
        map.put(CATEGORY, category);

        fbAnalyticsHelper.track(name, map);
        googleAnalyticsHelper.track(name, category);
    }
}

package cucha.com.br.featureb;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cucha.com.br.analytics.AnalyticsHelperImpl;

public class BActivity extends AppCompatActivity implements View.OnClickListener {

    private AnalyticsHelperImpl analyticsHelper;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, BActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        analyticsHelper = new AnalyticsHelperImpl(getApplicationContext());

        findViewById(R.id.loginButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = newIntent();
        startActivity(intent);
    }

    @NonNull
    private Intent newIntent() {
        analyticsHelper.track("MEU_EVENTO", "MAIN");

        Intent intent = new Intent();
        intent.setAction("cucha.com.br.ACTION_C");
        return intent;
    }
}

package cucha.com.br.featureb;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class BActivityTest {

    @Rule
    public ActivityTestRule<BActivity> rule = new ActivityTestRule<>(BActivity.class);

    @Test
    public void should_showFeatureName() {
        onView(withId(R.id.featureBText))
                .check(matches(isDisplayed()));
    }
}

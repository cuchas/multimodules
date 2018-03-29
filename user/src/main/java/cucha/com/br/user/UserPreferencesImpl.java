package cucha.com.br.user;


import android.content.SharedPreferences;

public class UserPreferencesImpl implements UserPreferences {
    private final SharedPreferences preferences;
    private static final String USER_NAME = "USER_NAME";
    private static final String CUCHARRO = "Eduardo Cucharro";

    private UserPreferencesImpl(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public static UserPreferencesImpl newInstance(SharedPreferences prefs) {
        UserPreferencesImpl userPreferences = new UserPreferencesImpl(prefs);
        return userPreferences;
    }

    @Override
    public String getUserName() {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(USER_NAME, CUCHARRO);
        edit.apply();

        return preferences.getString(USER_NAME, CUCHARRO);
    }
}

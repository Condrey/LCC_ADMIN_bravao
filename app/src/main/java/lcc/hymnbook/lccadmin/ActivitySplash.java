package lcc.hymnbook.lccadmin;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.HashMap;
import java.util.Locale;

public class ActivitySplash extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIMEOUT = 3000;
    ShapeableImageView imageView;
    TextView textView;
    ///////////////////////////

    public static final String KEY_SHARED_PREFERENCE = "MySharedPref";
    public static final String PREF_APP_THEME = "APP THEME";
    public static final String PREF_APP_LANGUAGE = "APP LANGUAGE";
    SharedPreferences pref;

    /////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        ////////////////////////////////////////////////////////////////////////////////

        pref = getSharedPreferences(KEY_SHARED_PREFERENCE,MODE_PRIVATE);
/////////////////////////////////////////////////////////////////////////////////////////

        Animation fadeOut = new AlphaAnimation(1,0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(500);
        fadeOut.setFillAfter(false);
        fadeOut.setDuration(2800);
        imageView = findViewById(R.id.start_image);
        imageView.setAnimation(fadeOut);
        textView  = findViewById(R.id.start_title);
        textView.setAnimation(fadeOut);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ActivitySplash.this,Login.class));
                finish();
            }
        },SPLASH_SCREEN_TIMEOUT);
    }

    @Override
    protected void onStart() {
        super.onStart();
        applyCustomSettings();

    }
    private void applyCustomSettings() {
//        String theme = pref.getString(PREF_APP_THEME,"Light");
//        if (theme.equalsIgnoreCase("Light")){
//            setTheme(R.style.Theme_LCCHymnBook);
//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//
//        }else if(theme.equalsIgnoreCase("Dark")){
//            setTheme(R.style.Theme_LCCHymnBookDark);
//            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//        }
        String lang = pref.getString(PREF_APP_LANGUAGE,"English");
        String abbrv;
        if ("Luganda".equals(lang)) {
            abbrv = "lug";
        } else if ("Lango".equals(lang)) {
            abbrv = "lag";
        }else {
            abbrv = "en";

        }
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(abbrv);
        resources.updateConfiguration(configuration,displayMetrics);

    }

}
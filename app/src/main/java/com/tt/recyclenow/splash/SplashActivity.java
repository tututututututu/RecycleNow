package com.tt.recyclenow.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tt.recyclenow.R;
import com.tt.recyclenow.main.MainActivity;

/**
 * @author tt
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.rl_root).postDelayed(
                () -> {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
                , 2000);

    }
}

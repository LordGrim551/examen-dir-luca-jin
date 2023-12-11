package com.example.indianfood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.time.Instant;

public class MainSplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash_screen);
        ImageView logoSplash = findViewById(R.id.logoSplash);
        TextView appNameSplash = findViewById(R.id.appNameSplash);

        ImageView backgroundSplash = findViewById(R.id.backgroundSplash);


        Glide.with(this)
                .load("https://www.masalamastee.com/wp-content/uploads/elementor/thumbs/indian-food-new-p8kgl7ytuyijphx2c58ghakahqbtubuq81so6yi0b4.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                //.centerCrop()
                .into(backgroundSplash);


        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.go_up);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.go_down);

        final TextView name = findViewById(R.id.appNameSplash);
        final ImageView logo = findViewById(R.id.logoSplash);

        name.setAnimation(animation2);
        logo.setAnimation(animation1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainSplashScreen.this, MainLoginScreen.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(logo, "ryodanTrans");
                pairs[1] = new Pair<View, String>(name, "crTrans");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainSplashScreen.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        },4000);
    }


    }
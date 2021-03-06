package com.example.brianr.keuanganhimasif;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Index extends AppCompatActivity {
    private static int WELCOME_TIMEOUT = 4000;
    TextView judul;
    Typeface tf1;
    Button login, guest;
    Animation frombottom, fromtop;
    RelativeLayout layout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        judul = (TextView) findViewById(R.id.judul);
        tf1 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        judul.setTypeface(tf1);

        login = (Button) findViewById(R.id.login);
        guest = (Button) findViewById(R.id.guest);
        login.setTypeface(tf1);
        guest.setTypeface(tf1);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        judul.setAnimation(fromtop);
        guest.setAnimation(frombottom);
        login.setAnimation(frombottom);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Index.this, Login.class);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                startActivity(i);
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GuestActivity.class);
                startActivity(i);
            }
        });

        layout = (RelativeLayout) findViewById(R.id.layout);

        animationDrawable = (AnimationDrawable) layout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }
}

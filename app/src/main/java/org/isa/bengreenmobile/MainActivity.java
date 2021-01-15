package org.isa.bengreenmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView titre;
    private static int SPLASH_SCREEN = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enlevons la bare en haut
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_main);

        //Animations
        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation_layout);
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation_layout);
        //Hooks
        logo = findViewById(R.id.imageView);
        titre = findViewById(R.id.textView);
        //Assignment
        logo.setAnimation(topAnim);
        titre.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Déclaration d'une nouvelle intention
                Intent intent = new Intent(MainActivity.this,AccueilActivity.class);
                //Démarrage de l'intention
                startActivity(intent);
                //Cloture du Splash Screen
                finish();
            }
        },SPLASH_SCREEN);

    }
}
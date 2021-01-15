package org.isa.bengreenmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccueilActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCategorie, btnProduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        btnCategorie = findViewById(R.id.btnCategorie);
        btnProduit = findViewById(R.id.btnProduit);
        btnCategorie.setOnClickListener(this);
        btnProduit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCategorie){
            launchParentsActivity();
        }
        if(v == btnProduit){
            launchProductActivity();
        }
    }

    private void launchProductActivity() {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    private void launchParentsActivity() {
        Intent intent = new Intent(this, ParentsActivity.class);
        startActivity(intent);
    }
}
package org.isa.bengreenmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParentsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RubriqueAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView test;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents);

        test = findViewById(R.id.testResult);

        progressDialog = new ProgressDialog(ParentsActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/apiVillageGreen/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        MonApi monApi = retrofit.create(MonApi.class);
        Call<List<Rubrique>> call = monApi.getParents();

        call.enqueue(new Callback<List<Rubrique>>() {
            @Override
            public void onResponse(Call<List<Rubrique>> call, Response<List<Rubrique>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
                
                if (!response.isSuccessful()){
                    test.setText("Code "+response.code());
                }

            }

            @Override
            public void onFailure(Call<List<Rubrique>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ParentsActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

                //to find out what went wrong :
                //test.setText(t.getMessage());
            }
        });

    }

    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<Rubrique> rubList) {
        mRecyclerView = findViewById(R.id.RecyclerView);
        //if you know your recyclerview wont change in size, set this to true to improve app's performance:
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RubriqueAdapter(rubList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RubriqueAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                launchRubriqueActivity(position);
            }
        });
    }

    private void launchRubriqueActivity(int position) {
        //use position as link to parent id of rubrique - to finish
        Intent intent = new Intent(this, RubriqueActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }


}
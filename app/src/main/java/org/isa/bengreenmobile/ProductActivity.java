package org.isa.bengreenmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ProgressDialog progressDialog;
    private TextView tVListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        tVListe = findViewById(R.id.tVListe);

        progressDialog = new ProgressDialog(ProductActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/apiVillageGreen/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        MonApi monApi = retrofit.create(MonApi.class);
        Call<List<Product>> call = monApi.listAllProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());

                if (!response.isSuccessful()){
                    tVListe.setText("Code "+response.code());
                }

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ProductActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

                //to find out what went wrong :
                tVListe.setText(t.getMessage());
            }
        });

    }

    //Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<Product> pdtList) {
        mRecyclerView = findViewById(R.id.rVProduits);
        //if you know your recyclerview wont change in size, set this to true to improve app's performance:
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ProductAdapter(pdtList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}
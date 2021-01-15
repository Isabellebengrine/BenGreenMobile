package org.isa.bengreenmobile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> mProductList;


    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iVProductPicture);
            mTextView1 = itemView.findViewById(R.id.tVProductName);
            mTextView2 = itemView.findViewById(R.id.tVPdtRubrique);
        }
    }

    public ProductAdapter(List<Product> pList) {
        mProductList = pList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentItem = mProductList.get(position);

        //15/01/21 with Glide to show product's picture from url in database:
        GlideApp.with(holder.itemView.getContext())
                .load(currentItem.getProductsPicture())
                .into(holder.mImageView);

        holder.mTextView1.setText(currentItem.getProductsName());
        holder.mTextView2.setText(currentItem.getRubriqueName());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

}

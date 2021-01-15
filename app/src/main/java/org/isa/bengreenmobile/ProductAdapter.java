package org.isa.bengreenmobile;

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

        //13/01/21 - pb to display pictures from database url - test with default picture - ok :
        holder.mImageView.setImageResource(R.drawable.notesmusic);

//        URL url = null;
//        try {
//            url = new URL(currentItem.getProductsPicture());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        HttpURLConnection httpConn = null;
//        try {
//            httpConn = (HttpURLConnection) url.openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            httpConn.connect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int resCode = 0;
//        try {
//            resCode = httpConn.getResponseCode();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (resCode == HttpURLConnection.HTTP_OK) {
//            InputStream in = null;
//            try {
//                in = httpConn.getInputStream();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Bitmap bitmap = BitmapFactory.decodeStream(in);
//
//            holder.mImageView.setImageBitmap(bitmap);
//        }
//
        holder.mTextView1.setText(currentItem.getProductsName());
        holder.mTextView2.setText(currentItem.getRubriqueName());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

}

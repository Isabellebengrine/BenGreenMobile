package org.isa.bengreenmobile;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RubriqueAdapter extends RecyclerView.Adapter<RubriqueAdapter.RubriqueViewHolder> {

    private int[] mImageIds = new int[] {R.drawable.categoriesguitare, R.drawable.categoriesmicro, R.drawable.categoriespiano, R.drawable.categoriesbatterie, R.drawable.categoriessaxo, R.drawable.categoriescable, R.drawable.categoriescases, R.drawable.categoriessono};

    private List<Rubrique> mRubriqueList;

    //to make cardview clicable :
    private OnItemClickListener mListener;//(this listener will then be our activity)
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class RubriqueViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView;

        public RubriqueViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iVRubriquePicture);
            mTextView = itemView.findViewById(R.id.tVRubriqueName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RubriqueAdapter(List<Rubrique> rubriqueList) {
        mRubriqueList = rubriqueList;
    }

    @NonNull
    @Override
    public RubriqueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        RubriqueViewHolder rvh = new RubriqueViewHolder(v, mListener);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RubriqueViewHolder holder, int position) {
        Rubrique currentItem = mRubriqueList.get(position);
        holder.mImageView.setImageResource(mImageIds[position]);
        holder.mTextView.setText(currentItem.getRubriqueName());
    }

    @Override
    public int getItemCount() {
        return mRubriqueList.size();
    }

}

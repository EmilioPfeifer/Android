package com.example.registradora;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.mViewHolder> {

    private ArrayList<Item> mList;

    public static class mViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public mViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public Adaptador(ArrayList<Item> list) {
        mList = list;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        mViewHolder mvh = new mViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int i) {
        Item currentItem = mList.get(i);
        holder.mImageView.setImageResource(currentItem.getmImagen());
        holder.mTextView1.setText(currentItem.getmText());
        holder.mTextView2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

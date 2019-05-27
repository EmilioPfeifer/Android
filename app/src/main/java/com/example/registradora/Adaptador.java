package com.example.registradora;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.mViewHolder> {

    private ArrayList<Item> mList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onDeleteItemClick(int index);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public Button btnRemove;

        public mViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);

            btnRemove = itemView.findViewById(R.id.btn_remove);

            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int index = getAdapterPosition();
                        if(index != RecyclerView.NO_POSITION) {
                            listener.onDeleteItemClick(index);
                        }
                    }
                }
            });
        }
    }

    public Adaptador(ArrayList<Item> list) {
        mList = list;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        mViewHolder mvh = new mViewHolder(v, mListener);
        return mvh;
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int i) {
        Item currentItem = mList.get(i);
        holder.mImageView.setImageResource(currentItem.getmImagen());
        holder.mTextView1.setText(String.valueOf(currentItem.getmPrecio()));
        holder.mTextView2.setText(currentItem.getmDetalle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

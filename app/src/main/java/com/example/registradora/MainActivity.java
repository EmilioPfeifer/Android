package com.example.registradora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> Items;

    private RecyclerView mRecyclerView;
    private Adaptador mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Items = new ArrayList<>();
        Items.add(new Item(R.drawable.ic_all_out, "Line 1", "Line 2", Items.size()));
        Items.add(new Item(R.drawable.ic_all_out, "Line 1", "Line 2", Items.size()));

        construirRecyclerView();
        setButtons();
    }

    public void setButtons() {
        btnInsert = findViewById(R.id.btn_insert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItem();
            }
        });
    }

    private void construirRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Adaptador(Items);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new Adaptador.OnItemClickListener() {
            @Override
            public void onDeleteItemClick(int index) {
                removeItem(index);
            }
        });
    }

    public void insertItem() {
        Items.add(new Item(R.drawable.ic_all_out, "Line 1", "Line 2", Items.size()));
        mAdapter.notifyItemInserted(Items.size());
    }
    public void removeItem(int index) {
        Items.remove(index);
        mAdapter.notifyItemRemoved(index);
    }

}

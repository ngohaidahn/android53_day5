package com.example.android53_day5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android53_day5.Adapter.MyAdapter;
import com.example.android53_day5.Helper.MyButton;
import com.example.android53_day5.Helper.MyButtonClickListener;
import com.example.android53_day5.Helper.MySwipeHelper;
import com.example.android53_day5.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        recyclerView = (RecyclerView) findViewById(R.id.recycler_test);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MySwipeHelper swipeHelper =new MySwipeHelper(this,recyclerView,200) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MyButton> buttons) {
                buttons.add(new MyButton(MainActivity.this,
                        "Delete",
                        30,
                        0,
                        Color.parseColor("#FF3C30"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this,"Delete click",Toast.LENGTH_SHORT).show();
                            }
                        }));
                buttons.add(new MyButton(MainActivity.this,
                        "Update",
                        30,
                        R.drawable.ic_edit_white_24,
                        Color.parseColor("#FF9502"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this,"Update click",Toast.LENGTH_SHORT).show();
                            }
                        }));
            }
        };

        generateItem();


    }

    private void generateItem() {
        List<Item> itemList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            itemList.add(new Item("Cafe " + (+i),
                    "https://caphekhoanbetong.com/wp-content/uploads/2021/09/cac-mui-vi-cua-mot-ly-cafe-ngon-va-dat-chuan.jpg",
                    "50.000 VND"));
        }
        adapter = new MyAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
    }
}
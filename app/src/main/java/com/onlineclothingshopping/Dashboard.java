package com.onlineclothingshopping;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapter.ItemAdapter;


public class Dashboard extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<ItemModel> itemsList=new ArrayList<>();
//    private ItemModel  itemModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView=findViewById(R.id.recyclerview);

        readItem();

        recyclerView.setAdapter(new ItemAdapter(getApplicationContext(),itemsList));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));



    }

    public void readItem(){
        try {
            FileInputStream fos=openFileInput("items.txt");
            InputStreamReader isr=new InputStreamReader(fos);

            BufferedReader br=new BufferedReader(isr);
            String line="";

            while ((line=br.readLine()) != null){
                String[] parts=line.split("->");
                String imgDrawagble=parts[2];
                int id=getResources().getIdentifier(imgDrawagble,"drawable",getPackageName());

                itemsList.add(new ItemModel(parts[0],parts[1],parts[2],parts[3],id));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

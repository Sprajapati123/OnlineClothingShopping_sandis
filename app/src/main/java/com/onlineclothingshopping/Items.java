package com.onlineclothingshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintStream;

public class Items extends AppCompatActivity {

    private EditText itemname, itemprice, itemimgname, itemdescription;
    private Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        itemname = findViewById(R.id.itemname);
        itemprice = findViewById(R.id.itemprice);
        itemimgname = findViewById(R.id.itemimgname);
        itemdescription = findViewById(R.id.itemdescription);
        btnadd = findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    public void addItem() {
        try {
            PrintStream printStream=new PrintStream(openFileOutput("items.txt",MODE_PRIVATE |MODE_APPEND));
            printStream.println(itemname.getText().toString() + "->"+itemprice.getText().toString()
                    + "->"+itemimgname.getText().toString()+"->"+itemdescription.getText().toString());
            Toast.makeText(this, "saved to"+getFilesDir(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.d("Online Shoping","error:"+e.toString());
            e.printStackTrace();
        }
    }

}


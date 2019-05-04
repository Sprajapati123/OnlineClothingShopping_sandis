package com.onlineclothingshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    TextView name,price,description;
    CircleImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name=findViewById(R.id.name2);
        price =findViewById(R.id.price2);
        description=findViewById(R.id.description2);
        imageview=findViewById(R.id.imgview2);

        Bundle bundle=getIntent().getExtras();

        if (bundle!=null){

            imageview.setImageResource(bundle.getInt("image"));
            name.setText(bundle.getString("name"));
            price.setText(bundle.getString("price"));
            description.setText(bundle.getString("desc"));
        }


    }

}

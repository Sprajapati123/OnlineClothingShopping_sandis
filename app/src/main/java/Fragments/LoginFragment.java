package Fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.onlineclothingshopping.MainActivity;
import com.onlineclothingshopping.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText username_login, password_login;
    private Button btnlogin;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false);


        View view = inflater.inflate(R.layout.fragment_login, container, false);

        username_login = view.findViewById(R.id.username);
        password_login = view.findViewById(R.id.password);
        btnlogin = view.findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        return view;
    }

    public void Login() {
        SharedPreferences sharedPreferences=this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","");
        String password=sharedPreferences.getString("password","");

        if (username.equals(username_login.getText().toString()) && password.equals(password_login.getText().toString())){
            Toast.makeText(this.getActivity(), "Successfully logged in", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(this.getActivity(), MainActivity.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(this.getActivity(), "Invalid username and password", Toast.LENGTH_SHORT).show();
        }
    }

}

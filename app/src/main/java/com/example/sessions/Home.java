package com.example.sessions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView password,username;Button kill;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        kill = findViewById(R.id.kill);


                //get session variables and assign to the TextViews
                pref = getSharedPreferences("user_details", MODE_PRIVATE);
                String pass = pref.getString("password", null);
                String myUsername = pref.getString("username",null);

                //set to TextViews
                password.setText(pass);
                username.setText(myUsername);

    //Kill session var
        kill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear sesion variables
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();

                Toast.makeText(getApplicationContext(), "Log out success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                //Now the variable will be cleared after that
                //Test now
            }
        });


    }
}
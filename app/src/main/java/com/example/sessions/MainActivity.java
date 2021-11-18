package com.example.sessions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText usernamee, passwordd; Button login;SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        usernamee = findViewById(R.id.username);
        passwordd = findViewById(R.id.password);

        // Check first if user is logged in
        pref = getSharedPreferences("user_details", MODE_PRIVATE);
        if(pref.contains("username") || pref.contains("password")) {
            //direct user to Home activity
            Toast.makeText(getApplicationContext(), "You already Logged in", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);

        }else {
            //do nothing
        }

        //add even listener to btn

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // check if pass is correct and set sessions variable

                String myUsername = usernamee.getText().toString();
                String myPasword = passwordd.getText().toString();
                //Lets now debug set var as local variables to onclick btn

                if(myUsername.equals(null) || passwordd.equals(null)) {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                }else if(myPasword.equals("1234") && myUsername.equals("username"))
                    {
                    //set session variable

                        pref = getSharedPreferences("user_details",MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                        editor.putString("username", myUsername);
                        editor.putString("password",myPasword);
                    editor.commit();

                    //Direct user to Home Activity
                    Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
               } else {
                    Toast.makeText(getApplicationContext(), "Wrong password username combination", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
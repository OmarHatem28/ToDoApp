package com.m.warhit.todoapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.m.warhit.todoapp.Models.ToDo;
import com.m.warhit.todoapp.R;
import com.m.warhit.todoapp.Views.LoginView;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoginView {

    EditText ET_username;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        ET_username = findViewById(R.id.username);
        login_button = findViewById(R.id.login_button);

        // ToDo: make a remember me checkbox when true, save username in shared preference

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hi there", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void login_user(List<ToDo> user_todo_list) {

    }
}

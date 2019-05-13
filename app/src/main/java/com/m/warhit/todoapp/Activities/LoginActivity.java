package com.m.warhit.todoapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.m.warhit.todoapp.Models.ToDo;
import com.m.warhit.todoapp.Presenters.LoginPresenter;
import com.m.warhit.todoapp.R;
import com.m.warhit.todoapp.Views.LoginView;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoginView {

    EditText ET_username;
    Button login_button;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        ET_username = findViewById(R.id.username);
        login_button = findViewById(R.id.login_button);

        loginPresenter = new LoginPresenter(this);

        // ToDo: make a remember me checkbox when true, save username in shared preference

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ET_username.getText().toString();
                if ( valid(name) ){
                    loginPresenter.loginUser(name);
                } else {
                    ET_username.setError("Username must be at least 3 characters");
                }
            }
        });
    }

    boolean valid(String name) {
        return name.length() >= 3;
    }

    @Override
    public void login_user(ArrayList<ToDo> user_todo_list) {
        if ( user_todo_list.isEmpty() ){
            Toast.makeText(getApplicationContext(),"empty dumb", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),user_todo_list.get(0).getTitle(), Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(LoginActivity.this, ToDoActivity.class);
        intent.putParcelableArrayListExtra("user_todo_list", user_todo_list);
        startActivity(intent);
    }
}

package com.m.warhit.todoapp.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.m.warhit.todoapp.Models.ToDo;
import com.m.warhit.todoapp.R;

import java.util.ArrayList;

public class ToDoActivity extends AppCompatActivity {

    TextView textView;
    ArrayList<ToDo> user_todo_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        textView = findViewById(R.id.text);
        user_todo_list = (ArrayList<ToDo>) getIntent().getSerializableExtra("user_todo_list");
        textView.setText(user_todo_list.get(0).getTitle());
    }

}

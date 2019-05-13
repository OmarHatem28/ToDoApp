package com.m.warhit.todoapp.Presenters;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.m.warhit.todoapp.Models.ToDo;
import com.m.warhit.todoapp.Views.LoginView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoginPresenter {

    LoginView loginView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<ToDo> user_todo_list = new ArrayList<>();

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void loginUser(String username) {
        db.collection("users").document(username)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        ArrayList todo_list = (ArrayList) document.getData().get("ToDo");
                        for (int i = 0; i < todo_list.size(); i++) {
                            Map<String,Object> data = (Map<String, Object>) todo_list.get(i);
                            ToDo toDo = new ToDo();
                            toDo.setTitle(data.get("title").toString());
                            toDo.setDate(data.get("date").toString());
                            toDo.setDone((Boolean) data.get("done"));
                            toDo.setPriority((long) data.get("priority"));
                            toDo.setComments((List<String>) data.get("comments"));
                            user_todo_list.add(toDo);
                        }
                        Log.d("debug", "DocumentSnapshot data: " + document.getData());
                        loginView.login_user(user_todo_list);
                    } else {
                        Log.d("debug", "No such document");
                        loginView.login_user(user_todo_list);
                    }
                } else {
                    Log.d("debug", "get failed with ", task.getException());
                }
            }
        });
    }
}

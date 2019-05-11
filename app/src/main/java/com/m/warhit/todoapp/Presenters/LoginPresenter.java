package com.m.warhit.todoapp.Presenters;


import com.m.warhit.todoapp.Views.LoginView;

public class LoginPresenter {

    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    void loginUser(String username) {
        // firebase operations then call
//        loginView.login_user(user_todo_list);
    }
}

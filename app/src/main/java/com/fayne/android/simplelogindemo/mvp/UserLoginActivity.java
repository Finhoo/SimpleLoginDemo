package com.fayne.android.simplelogindemo.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fayne.android.simplelogindemo.R;
import com.fayne.android.simplelogindemo.mvp.bean.User;
import com.fayne.android.simplelogindemo.mvp.presenter.UserLoginPresenter;
import com.fayne.android.simplelogindemo.mvp.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView{

    private EditText etUsername, etPassword;
    private Button btnLogin, btnClear;
    private ProgressBar pbLoading;
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();
    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        btnLogin = findViewById(R.id.btn_login);
        btnClear = findViewById(R.id.btn_clear);

        pbLoading = findViewById(R.id.pb_loading);
        btnLogin.setOnClickListener(view ->
            userLoginPresenter.login()
        );

        btnClear.setOnClickListener(view ->
            userLoginPresenter.clear()
        );
    }

    @Override
    public String getUserName() {
        return etUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showLoading() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +" login success, toMainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        etUsername.setText("");
    }

    @Override
    public void clearPassword() {
        etPassword.setText("");
    }
}

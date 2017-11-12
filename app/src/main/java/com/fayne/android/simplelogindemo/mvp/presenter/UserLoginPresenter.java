package com.fayne.android.simplelogindemo.mvp.presenter;

import android.os.Handler;

import com.fayne.android.simplelogindemo.mvp.bean.User;
import com.fayne.android.simplelogindemo.mvp.biz.IUserBiz;
import com.fayne.android.simplelogindemo.mvp.biz.OnLoginListener;
import com.fayne.android.simplelogindemo.mvp.biz.UserBiz;
import com.fayne.android.simplelogindemo.mvp.view.IUserLoginView;

/**
 * Created by fan on 2017/11/12.
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}

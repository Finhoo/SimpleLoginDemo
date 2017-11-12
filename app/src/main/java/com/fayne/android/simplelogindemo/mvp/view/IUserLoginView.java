package com.fayne.android.simplelogindemo.mvp.view;

import com.fayne.android.simplelogindemo.mvp.bean.User;

/**
 * Created by fan on 2017/11/12.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

    void clearUserName();

    void clearPassword();
}

package com.fayne.android.simplelogindemo.mvp.biz;

import com.fayne.android.simplelogindemo.mvp.bean.User;

/**
 * Created by fan on 2017/11/12.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}

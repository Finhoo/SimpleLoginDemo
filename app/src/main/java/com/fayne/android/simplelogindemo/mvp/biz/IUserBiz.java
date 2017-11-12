package com.fayne.android.simplelogindemo.mvp.biz;

/**
 * Created by fan on 2017/11/12.
 */

public interface IUserBiz {
    public void login(String username, String password, OnLoginListener loginListener);
}

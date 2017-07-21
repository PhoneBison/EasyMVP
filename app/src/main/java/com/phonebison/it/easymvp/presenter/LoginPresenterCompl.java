package com.phonebison.it.easymvp.presenter;

import com.phonebison.it.easymvp.model.User;
import com.phonebison.it.easymvp.view.ILoginView;

/**
 * Created by Touch on 2017/7/21.
 */

public class LoginPresenterCompl implements ILoginPresenter {
    private ILoginView loginView;
    private User user;

    public LoginPresenterCompl(ILoginView loginView) {
        this.loginView = loginView;
        user=new User("提莫","123456");
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(String userName, String passWord) {
        boolean result=false;
        int code=0;
        if(userName.equals(user.getPassWord())&&passWord.equals(user.getPassWord())){
            result=true;
            code=0;
        }else{
            result=false;
            code=0;
        }
        loginView.onLoginResult(result,code);
    }
}

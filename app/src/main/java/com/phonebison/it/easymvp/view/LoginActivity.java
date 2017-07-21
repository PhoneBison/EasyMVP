package com.phonebison.it.easymvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.phonebison.it.easymvp.R;

public class LoginActivity extends AppCompatActivity implements ILoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onClear() {

    }

    @Override
    public void onLoginResult(Boolean result, int code) {

    }
}

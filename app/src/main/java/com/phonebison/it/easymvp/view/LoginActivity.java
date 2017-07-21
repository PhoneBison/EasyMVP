package com.phonebison.it.easymvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.phonebison.it.easymvp.R;
import com.phonebison.it.easymvp.presenter.ILoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity implements ILoginView{

    ILoginPresenter loginPresenter;

    @BindView(R.id.et_username)
     EditText mUserName;
    @BindView(R.id.et_password)
     EditText mPassWord;
    @BindView(R.id.bt_clear)
     Button mClear;
    @BindView(R.id.bt_login)
     Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //butterknife绑定Activity
        ButterKnife.bind(this);
    }

    @Override
    public void onClearText() {
        mUserName.setText("");
        mPassWord.setText("");
        Toast.makeText(this,"很干净了！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        if(result){
            Toast.makeText(this,"登录成功，欢迎你！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"登录失败，请检查你的用户名和密码",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.bt_clear,R.id.bt_login})
    void onClick(View v){
        //用户名
        String userName=mUserName.getText().toString();
        //密码
        String password=mPassWord.getText().toString();

        switch (v.getId()){
            case R.id.bt_clear:
                loginPresenter.clear();
                break;

            case R.id.bt_login:
                loginPresenter.doLogin(userName,password);
                break;
        }
    }

}

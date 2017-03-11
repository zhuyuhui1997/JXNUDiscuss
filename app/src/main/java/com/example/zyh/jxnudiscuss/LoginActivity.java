package com.example.zyh.jxnudiscuss;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by zyh on 17-3-9.
 */

public class LoginActivity extends Activity  implements View.OnClickListener {
    private EditText user_edit;
    private EditText passwd_edit;
    private Button login_btn;
    private Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        init();
        ActivityCollector.addActivity(this);
    }

    public void init() {
        user_edit = (EditText) findViewById(R.id.loginActivity_username_tv_edit);
        passwd_edit = (EditText) findViewById(R.id.loginActivity_userpasswd_edit);
        login_btn = (Button) findViewById(R.id.loginActivity_login_btn);
        register_btn = (Button) findViewById(R.id.loginActivity_register_btn);
        login_btn.setOnClickListener(this);
        register_btn.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginActivity_register_btn:
                if (passwd_edit.getText().toString().length() > 7) {
                    CommonUser commonUser = new CommonUser();
                    commonUser.setUsername(user_edit.getText().toString());
                    commonUser.setPassword(passwd_edit.getText().toString());
                    commonUser.signUp(new SaveListener<CommonUser>() {

                        @Override
                        public void done(CommonUser commonUser, BmobException e) {
                            if (e == null) {
                                Toast.makeText(LoginActivity.this, "register ok", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "register fall", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(this, "passwd length please >7,try again", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.loginActivity_login_btn:
                CommonUser commonuser = new CommonUser();
                commonuser.setPassword(passwd_edit.getText().toString());
                commonuser.setUsername(user_edit.getText().toString());
                commonuser.login(new SaveListener<CommonUser>() {

                    @Override
                    public void done(CommonUser commonUser, BmobException e) {
                        if (e == null) {
                            Toast.makeText(LoginActivity.this, "登录成功:", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "login false", Toast.LENGTH_LONG).show();
                        }

                    }


                });
                break;
        }
    }
}


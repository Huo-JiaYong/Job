package com.yong.job.two.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.yong.job.R;

public class LoginActivity extends Activity {

    private EditText name;
    private EditText pwd;
    private Button login;
    private ImageView image;

    private UserList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_login_activity);
        image = (ImageView) findViewById(R.id.image);
        name = (EditText) findViewById(R.id.name);
        pwd = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);

        list = initData();

        name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String nameString = name.getText().toString();

                    User user = list.getUserByName(nameString);
                    if (user.getImage() == 0 && user.getName() == "0" && user.getPwd() == "0") {
                        return;
                    }
                    image.setImageResource(user.getImage());
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String pwdString = pwd.getText().toString();

                if (nameString.equals("123") && pwdString.equals("123")) {
                    //start QQ activity
                    Intent intent = new Intent(LoginActivity.this, QQActivity.class);
                    startActivity(intent);
                    LoginActivity.this.finish();
                } else {
                    Toast.makeText(LoginActivity.this, "账号与密码不匹配", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public UserList initData(){
        UserList list = new UserList();
        User user = new User(R.drawable.green,"123","123");
        list.add(user);
        User user1 = new User(R.drawable.blue,"321","123");
        list.add(user1);
        User user2 = new User(R.drawable.gray,"132","123");
        list.add(user2);
        User user3 = new User(R.drawable.brown,"213","123");
        list.add(user3);
        return list;
    }
}

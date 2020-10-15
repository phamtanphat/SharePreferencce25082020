package com.example.sharepreferencce25082020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sharepreferencce25082020.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mMainBinding;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mMainBinding.getRoot());

        mSharedPreferences = getSharedPreferences("Mycache",MODE_PRIVATE);

        String username = mSharedPreferences.getString("username","");
        String password = mSharedPreferences.getString("password","");
        boolean isChecked = mSharedPreferences.getBoolean("ischecked",false);

        mMainBinding.checkboxSave.setChecked(isChecked);
        mMainBinding.edittextUsername.setText(username);
        mMainBinding.edittextPassword.setText(password);

        mMainBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mMainBinding.edittextUsername.getText().toString();
                String password = mMainBinding.edittextPassword.getText().toString();

                if (username.equals("phat") && password.equals("123")){
                    if (mMainBinding.checkboxSave.isChecked()){
                        mEditor = mSharedPreferences.edit();
                        mEditor.putString("username",username);
                        mEditor.putString("password",password);
                        mEditor.putBoolean("ischecked",true);
                        mEditor.commit();
                    }else{
                        mEditor = mSharedPreferences.edit();
                        mEditor.clear();
                        mEditor.commit();
                    }
                }
            }
        });
    }
}
package com.cong.cly.android_data_binding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cong.cly.android_data_binding.databinding.LoginDataBinding;
import com.cong.cly.android_data_binding.vm.LoginVM;

/**
 * Created by cong on 16/3/23.
 */
public class LoginActivity extends AppCompatActivity {
    private LoginVM loginVM;
    private LoginDataBinding loginDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginVM = new LoginVM(this);
        loginDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginDataBinding.setLoginVM(loginVM);
    }
}

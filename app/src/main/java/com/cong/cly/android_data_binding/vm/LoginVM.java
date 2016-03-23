package com.cong.cly.android_data_binding.vm;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cong.cly.android_data_binding.BR;
import com.cong.cly.android_data_binding.adapter.TextWatcherAdapter;
import com.cong.cly.android_data_binding.bind.BindableString;

/**
 * Created by cong on 16/3/23.
 */
public class LoginVM extends BaseObservable {
    private Context mContext;
    private String name;
    private String pwd;
    private int loginColor;
    public boolean loginEnable;

    public LoginVM(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 如果没有该绑定注解@Bindable，BR将不会有name属性
     */
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateLoginColor();
    }

    @Bindable
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        updateLoginColor();
    }

    private void updateLoginColor() {
        if (!TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(name)) {
            int color = mContext.getResources().getColor(android.R.color.holo_green_dark);
            Log.e("afterTextChanged", "setName1" + name);
            if (loginColor != color) {
                Log.e("LoginVM", "setName2" + name);
                setLoginColor(color);
                setLoginEnable(true);
            }
        } else {
            int color = mContext.getResources().getColor(android.R.color.background_light);
            if (loginColor != color) {
                setLoginColor(color);
                setLoginEnable(false);
                Log.e("LoginVM", "setName" + name);
            }
        }
    }

    @Bindable
    public int getLoginColor() {
        Log.e("LoginVM", "getLoginColor");
        return loginColor;
    }

    public void setLoginColor(int loginColor) {
        this.loginColor = loginColor;
        notifyPropertyChanged(BR.loginColor);
        Log.e("LoginVM", "setLoginColor" + loginColor);
    }

    @Bindable
    public TextWatcher nameWatcher = new TextWatcherAdapter() {
        @Override
        public void afterTextChanged(Editable s) {
            setName(s.toString());
        }
    };

    @Bindable
    public TextWatcher pwdWatcher = new TextWatcherAdapter() {
        @Override
        public void afterTextChanged(Editable s) {
            setPwd(s.toString());
        }
    };

    @Bindable
    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, "on click", Toast.LENGTH_SHORT).show();
        }
    };

    @BindingAdapter({"app:binding"})
    public static void bindEditText(EditText view, final BindableString bindableString) {

    }

//    @BindingAdapter({"android:enabled"})
//    public static void setEnabled(View view, boolean enabled) {
//        view.setEnabled(enabled);
//    }

    /**
     * 即使是boolean类型，也必须是get方法，而不是is方法
     */
    @Bindable
    public boolean getLoginEnable() {
        return loginEnable;
    }

    /**
     * @param loginEnable
     */
    public void setLoginEnable(boolean loginEnable) {
        this.loginEnable = loginEnable;
        notifyPropertyChanged(BR.loginEnable);
    }
}

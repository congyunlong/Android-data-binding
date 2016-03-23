package com.cong.cly.android_data_binding.bind;

import android.databinding.BaseObservable;

/**
 * Created by cong on 16/3/23.
 */
public class BindableBoolean extends BaseObservable {
    private boolean value;

    public boolean get() {
        return value;
    }

    public void set(boolean value) {
        if (this.value != value) {
            notifyChange();
        }
    }
}

package com.example.coffeeexpressandroid.ui.capsule;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CapsuleViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public CapsuleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Capsules fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

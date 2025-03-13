package com.example.coffeeexpressandroid.ui.capsule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.coffeeexpressandroid.databinding.FragmentCapsuleBinding;

public class CapsuleFragment extends Fragment {
private FragmentCapsuleBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                               ViewGroup container, Bundle savedInstanceState) {
        CapsuleViewModel capsulesViewModel =
                new ViewModelProvider(this).get(CapsuleViewModel.class);

        binding = FragmentCapsuleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView7;
        capsulesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

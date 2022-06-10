package com.example.temphum.ui.main_fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.temphum.R;
import com.example.temphum.Navigator;
import com.example.temphum.databinding.MainFragmentBinding;


public class MainFragment extends Fragment {

    private MainFragmentBinding binding;
    private MainFragmentViewModel model;
    private Navigator navigator;

    public MainFragment() {
        super(R.layout.main_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = MainFragmentBinding.bind(view);
        model = new ViewModelProvider(this).get(MainFragmentViewModel.class);
        navigator = (Navigator) requireActivity();
        model.getTemperature().observe(getViewLifecycleOwner(), tempAnswer ->
        {
            if (tempAnswer == null) {
                Toast.makeText(getContext(), "try again", Toast.LENGTH_LONG).show();
            } else {
                binding.textTemp.setText("Температура: " + tempAnswer.getTemp());
                binding.textHum.setText("Влажность: " + tempAnswer.getHum());
            }
        });
        binding.outputTemperature.setOnClickListener(v -> model.loadTemp());
        binding.schedule.setOnClickListener(v -> {
            navigator.navigateToGraph();
        });
    }


}

package com.example.temphum.ui.main_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.temphum.databinding.ActivityMainBinding;
import com.example.temphum.ui.graph_fragment.GraphFragmentt;
import com.example.temphum.Navigator;
import com.example.temphum.ui.main_fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements Navigator {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().
                beginTransaction()
                .add(binding.container.getId(),new MainFragment())
                .commit();
    }

    @Override
    public void navigateToGraph() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.container.getId(),new GraphFragmentt())
                .addToBackStack(GraphFragmentt.TAG)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

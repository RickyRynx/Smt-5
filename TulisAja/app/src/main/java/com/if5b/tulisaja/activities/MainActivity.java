package com.if5b.tulisaja.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.if5b.tulisaja.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
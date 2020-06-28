package com.example.observerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();


    Observer observer = new Observer() {
        @Override
        public void update(String text) {

            secondFragment.setTextObserver(text);
        }
    };

    Observer observer1 = new Observer() {
        @Override
        public void update(String text) {
            firstFragment.setTextObserver(text);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstFragment.register(observer);
        secondFragment.register(observer1);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.firstframe, firstFragment).addToBackStack(null);
        transaction.replace(R.id.secondframe, secondFragment).addToBackStack(null);
        transaction.commit();
    }
}
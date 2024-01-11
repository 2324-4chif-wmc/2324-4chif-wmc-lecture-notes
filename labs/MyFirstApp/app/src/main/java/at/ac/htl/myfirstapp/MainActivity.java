package at.ac.htl.myfirstapp;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;

import at.ac.htl.myfirstapp.ui.layout.MainViewKt;

public class MainActivity extends ComponentActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate()");
        MainViewKt.SetContentView(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, "onSaveInstanceState()");
    }
}
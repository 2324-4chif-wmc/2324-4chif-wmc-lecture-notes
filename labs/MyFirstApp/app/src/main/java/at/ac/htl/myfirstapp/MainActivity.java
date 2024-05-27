package at.ac.htl.myfirstapp;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;

import javax.inject.Inject;

import at.ac.htl.myfirstapp.model.Model;
import at.ac.htl.myfirstapp.model.Store;
import at.ac.htl.ui.layout.MainView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Store store;

    @Inject
    MainView mainView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainView.setContentView(this);

        store.set(model -> model.greeting = "mit consumer");
        var s2 = store.subject
                .map(model -> model.greeting.toUpperCase())
                .subscribe(text -> Log.i(TAG, text));
    }

    @Override
    public void onSaveInstanceState(
            @NonNull Bundle outState,
            @NonNull PersistableBundle outPersistentState
    ) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, "onSaveInstanceState()");
    }
}
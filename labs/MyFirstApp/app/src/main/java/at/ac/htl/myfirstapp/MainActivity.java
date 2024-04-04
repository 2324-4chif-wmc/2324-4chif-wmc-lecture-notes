package at.ac.htl.myfirstapp;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;

import javax.inject.Inject;

import at.ac.htl.myfirstapp.model.Model;
import at.ac.htl.myfirstapp.model.Store;
import at.ac.htl.myfirstapp.ui.layout.MainViewCreator;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Store store;

    @Inject
    MainViewCreator mainView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        var model = new Model("Hallo ");
        store.subject.onNext(model);

        Log.i(TAG, String.format("onCreate() %s", store.greeting));
        mainView.setContentView(this);
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
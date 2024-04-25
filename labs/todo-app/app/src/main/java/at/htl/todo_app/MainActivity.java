package at.htl.todo_app;

import android.os.Bundle;

import androidx.activity.ComponentActivity;

import javax.inject.Inject;

import at.htl.todo_app.ui.MainViewBuilder;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    @Inject
    MainViewBuilder mainViewBuilder;

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewBuilder.setContentview(this);
    }
}


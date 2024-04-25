package at.htl.todo_app;

import android.app.Application;
import android.util.Log;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class TodoMain extends Application {

    public static final String TAG = Application.class.getSimpleName();

    public TodoMain() {
        Log.i(TAG, "Main gestartet");
    }
}

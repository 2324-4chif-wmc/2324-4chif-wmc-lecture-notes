package at.htl.todo_app;

import android.os.Bundle;

import androidx.activity.ComponentActivity;

import java.util.List;

import javax.inject.Inject;

import at.htl.todo_app.model.Store;
import at.htl.todo_app.model.Todo;
import at.htl.todo_app.model.TodoViewModel;
import at.htl.todo_app.ui.MainViewBuilder;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    @Inject
    MainViewBuilder mainViewBuilder;

    @Inject
    Store store;

    @Override
     public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewBuilder.setContentview(this);

        createDemoData();
    }

    void createDemoData() {
        var todo1 = new Todo();
        todo1.id= 1L;
        todo1.title = "HÜ";
        todo1.completed = false;
        todo1.userId = 1L;

        var todo2 = new Todo();
        todo2.id= 2L;
        todo2.title = "Üben für Mathe-SA";
        todo2.completed = false;
        todo2.userId = 1L;

        store.set(model -> model.todos = List.of(todo1, todo2));

        var observable = store.subject.map(model -> model.todos);
        // TODO: auscoden ...
    }
}


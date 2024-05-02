package at.htl.todo_app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.State
import androidx.compose.runtime.rxjava3.subscribeAsState
import at.htl.todo_app.model.Model
import at.htl.todo_app.model.Store
import at.htl.todo_app.ui.theme.TodoappTheme
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class MainViewBuilder {

    val store: Store

    @Inject
    constructor(store: Store) {
        this.store = store
    }

    fun setContentview(activity: ComponentActivity){
        activity.setContent {
            TodoappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state = store.subject.subscribeAsState(initial = Model())
                    Greeting(state)
                }
            }
        }
    }

}

@Composable
fun Greeting(state: State<Model>, modifier: Modifier = Modifier) {
    Text(
        text = "Hello ${state.value.name} ${state.value.todos.size}!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoappTheme {
        //Greeting("4chif")
    }
}
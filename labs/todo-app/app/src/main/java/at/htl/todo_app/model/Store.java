package at.htl.todo_app.model;

import java.util.function.Consumer;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Singleton
public class Store {

    public BehaviorSubject<Model> subject;

    @Inject
    Store() {
        subject = BehaviorSubject.createDefault(new Model());
    }

    public void set(Consumer<Model> recipe) {
        var mapper = new ModelMapper<Model>(Model.class);
        final var currentModel = subject.getValue();
        var nextModel = mapper.clone(currentModel); // deep-clone
        //var nextModel = mapper.clone(subject.getValue()); // deep-clone
        recipe.accept(nextModel); // ändert das model
        subject.onNext(nextModel);

        // Typescript version:
        // const nextModel = produce(store.getValue(), recipe)
        // store.next(nextModel)
    }
}

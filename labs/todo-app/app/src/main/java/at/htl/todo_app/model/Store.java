package at.htl.todo_app.model;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class Store {

//    const initialState: Model = {
//        name: "Chris",
//                email: "chris@example.com",
//                photos: []
//    }

    //store = new BehaviorSubject<Model>(initialState)

    public BehaviorSubject<Model> store = BehaviorSubject.create();
    // TODO: to be continued ...
}

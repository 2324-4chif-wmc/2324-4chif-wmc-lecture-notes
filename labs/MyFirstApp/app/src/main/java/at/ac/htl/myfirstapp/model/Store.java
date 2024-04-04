package at.ac.htl.myfirstapp.model;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Singleton
public class Store {

    @Inject
    Store() {
        subject = BehaviorSubject.createDefault(new Model("Hallo"));
    }

    public BehaviorSubject<Model> subject;
    public String greeting = "Hello World";


}

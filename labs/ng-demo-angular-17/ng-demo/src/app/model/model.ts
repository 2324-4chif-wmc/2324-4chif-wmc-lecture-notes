import {Photo} from "./photo";
import {signal, WritableSignal} from "@angular/core";

export interface Model {
  readonly name: WritableSignal<string>
  readonly email: WritableSignal<string>
  readonly photos: WritableSignal<Photo[]>
}

const initialState: Model = {
  name: signal("Chris"),
  email: signal("chris@example.com"),
  photos: signal([]),
}
//export const store = new BehaviorSubject<Model>(initialState)
export const store = initialState;



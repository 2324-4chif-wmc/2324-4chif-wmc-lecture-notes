import {BehaviorSubject} from "rxjs";
import {Draft, produce} from "immer";
import {Photo} from "./photo";

export interface Model {
  readonly name: string
  readonly email: string
  readonly photos: Photo[]
}

const initialState: Model = {
  name: "Chris",
  email: "chris@example.com",
  photos: []
}
export const store = new BehaviorSubject<Model>(initialState)

export function set(recipe: (model: Draft<Model>) => void) {
  const nextModel = produce(store.getValue(), recipe)
  store.next(nextModel)
}

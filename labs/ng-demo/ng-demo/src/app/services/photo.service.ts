import {inject, Injectable, model} from '@angular/core';
import {Photo} from "../model";
import {StoreService} from "./store.service";
import {scheduleObservable} from "rxjs/internal/scheduled/scheduleObservable";

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  store = inject(StoreService).store

  async getAll() {
    const response = await fetch("https://jsonplaceholder.typicode.com/photos?_start=0&_limit=5")
    const photos: Photo[] = await response.json()

    /*set(model => {
      model.photos = photos
    })*/

    this.store.photos.set(photos);
  }
}

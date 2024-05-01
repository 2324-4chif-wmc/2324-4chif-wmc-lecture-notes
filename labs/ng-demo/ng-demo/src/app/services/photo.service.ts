import {Injectable} from '@angular/core';
import {Photo, set} from "../model";

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  async getAll() {
    const response = await fetch("https://jsonplaceholder.typicode.com/photos?_start=0&_limit=5")
    const photos: Photo[] = await response.json()

    set(model => {
      model.photos = photos
    })
  }
}

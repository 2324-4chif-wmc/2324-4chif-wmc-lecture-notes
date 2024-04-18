import {Injectable} from '@angular/core';
import {Photo, set} from "../model";

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  async getAll() {
    const response = await fetch("https://jsonplaceholder.typicode.com/photos")
    const photos: Photo[] = await response.json()

    set(model => {
      model.photos = photos
    })
  }
}

import {Injectable} from '@angular/core';
import {store} from "../model/model";

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  get store() {
    return store
  }
}

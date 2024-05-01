import { Routes } from '@angular/router'
import {HelloComponent} from "./components/hello/hello.component"
import {PhotoComponent} from "./components/photo/photo.component";
import {PhotosComponent} from "./components/photos/photos.component";

export const routes: Routes = [
  {path:"hello", component:HelloComponent},
  {path:"photos", component:PhotosComponent},
]

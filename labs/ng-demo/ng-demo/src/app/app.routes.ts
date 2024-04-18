import { Routes } from '@angular/router'
import {HelloComponent} from "./components/hello/hello.component"
import {PhotoComponent} from "./components/photo/photo.component";

export const routes: Routes = [
  {path:"hello", component:HelloComponent},
  {path:"photos", component:PhotoComponent}
]

import {Component, inject} from '@angular/core';
import {StoreService} from "../../services/store.service";
import {set} from "../../model";

@Component({
  selector: 'app-hello',
  standalone: true,
  imports: [],
  templateUrl: './hello.component.html',
  styleUrl: './hello.component.css'
})
export class HelloComponent {

  store = inject(StoreService).store

  onEmailChanged(value: string) {
    set(model => {
      model.email = value
    })
  }

  onNameChanged(value: string) {
    set(model => {
      model.name = value
    })
  }
}

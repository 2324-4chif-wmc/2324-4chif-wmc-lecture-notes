import {Component, inject} from '@angular/core';
import {StoreService} from "../../services/store.service";

@Component({
  selector: 'app-photo',
  standalone: true,
  imports: [],
  templateUrl: './photo.component.html',
  styleUrl: './photo.component.css'
})
export class PhotoComponent {
  store = inject(StoreService).store
}

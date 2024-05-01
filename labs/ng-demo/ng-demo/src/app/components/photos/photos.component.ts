import {Component, inject, OnInit} from '@angular/core';
import {StoreService} from "../../services/store.service";
import {PhotoComponent} from "../photo/photo.component";

@Component({
  selector: 'app-photos',
  standalone: true,
  imports: [
    PhotoComponent
  ],
  templateUrl: './photos.component.html',
  styleUrl: './photos.component.css'
})
export class PhotosComponent {
  store = inject(StoreService).store

  clickCount = 0

  addClickCount() {
    this.clickCount++
  }
}

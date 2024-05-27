import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Photo} from "../../model";

@Component({
  selector: 'app-photo',
  standalone: true,
  imports: [],
  templateUrl:  './photo.component.html',
  styleUrl: './photo.component.css'
})
export class PhotoComponent {
  @Input() photo: Photo = {} as Photo;
  @Output() photoClicked = new EventEmitter<number>();

  photoClick(value: number) {
    this.photoClicked.emit(value);
  }

  protected readonly toString = toString;
}

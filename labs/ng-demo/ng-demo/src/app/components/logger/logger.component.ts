import {Component, inject, OnInit} from '@angular/core';
import {StoreService} from "../../services/store.service";
import {distinctUntilChanged, map} from "rxjs";

@Component({
  selector: 'app-logger',
  standalone: true,
  imports: [],
  templateUrl: './logger.component.html',
  styleUrl: './logger.component.css'
})
export class LoggerComponent implements OnInit {
  store = inject(StoreService).store

  ngOnInit() {
    this.store
      .pipe(map(model => model.name),
        distinctUntilChanged())
      .subscribe(name =>
        console.log("name changed ", name))
      this.store.pipe(map(model => model.photos),
        distinctUntilChanged())
        .subscribe(photos => console.log("Photos loaded ...", photos)
        )
  }
}

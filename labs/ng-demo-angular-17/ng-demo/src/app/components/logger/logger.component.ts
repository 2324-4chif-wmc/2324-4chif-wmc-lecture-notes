import {Component, effect, inject, Injector, OnInit, runInInjectionContext} from '@angular/core';
import {StoreService} from "../../services/store.service";
import {distinctUntilChanged, map} from "rxjs";
import {toObservable} from "@angular/core/rxjs-interop";

@Component({
  selector: 'app-logger',
  standalone: true,
  imports: [],
  templateUrl: './logger.component.html',
  styleUrl: './logger.component.css'
})
export class LoggerComponent implements OnInit {
  store = inject(StoreService).store

  constructor() {
    effect(() => {
      console.log("name changed ", this.store.name())
    })
    effect(() => {
      console.log("Photos loaded ...", this.store.photos())
    });

    effect(() => {
      console.log("Email changed ", this.store.email())
    });
  }
  ngOnInit() {
    /* this.store
      .pipe(map(model => model.name),
        distinctUntilChanged())
      .subscribe(name =>
        console.log("name changed ", name))
      this.store.pipe(map(model => model.photos),
        distinctUntilChanged())
        .subscribe(photos => console.log("Photos loaded ...", photos)
      ) */
  }
}

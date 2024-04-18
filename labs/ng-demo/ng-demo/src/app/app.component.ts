import {Component, inject, OnInit} from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {LoggerComponent} from "./components/logger/logger.component";
import {PhotoService} from "./services/photo.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoggerComponent, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  photoService = inject(PhotoService)

  ngOnInit() {
    this.photoService.getAll()

  }
}

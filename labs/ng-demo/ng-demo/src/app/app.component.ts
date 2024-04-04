import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoggerComponent} from "./components/logger/logger.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoggerComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

}

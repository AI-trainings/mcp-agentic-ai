import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ChatComponent} from "./chat/chat.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ChatComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'chat-ai-frontend';
}

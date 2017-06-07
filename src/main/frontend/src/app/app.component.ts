import {Component} from "@angular/core";
import {Http} from "@angular/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';

  users = [];

  constructor(private http: Http) {
  }

  getUsers() {
    console.log('getUsers');

    this.http.get('api/users').subscribe(next => {
      console.log(next);
      this.users = next.json();
    })
  }
}

import {Component} from "@angular/core";
import {Http} from "@angular/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    title: string = "Crazy Charlie's House of Deals";
    products = [];
    total;
    showTotal: boolean;

    constructor(private http: Http) {
        this.getProducts();
        this.showTotal = false;
    }

    buy(productId: string) {
        this.showTotal = false;
        this.http.get('/api/cart/buy/' + productId).subscribe(next => {
                this.total = next.json();
            })
    }

    unbuy(productId: string) {
        this.showTotal = false;
        this.http.get('/api/cart/unbuy/' + productId).subscribe(next => {
                this.total = next.json();
            })
    }

    getTotal() {
        this.showTotal = true;
        this.http.get('/api/cart/total/').subscribe(next => {
                this.total = next.json();
            })
    }

    getProducts() {
        console.log('getProducts');
        this.http.get('/api/products').subscribe(next => {
                console.log(next);
                this.products = next.json();
            })
            }

    prettyPrice(price: number): string {
        price /= 100;
        return price.toLocaleString('de-DE', { style: 'currency', currency: 'EUR'});
    }
}

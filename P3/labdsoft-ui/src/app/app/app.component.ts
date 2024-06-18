import { UserService } from './shared/services/user.service';
import { Component, OnDestroy, OnInit, Renderer2, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common'
import { AuthService } from './shared/services/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
  subscriptions: Subscription[] = [];
  loading = true;
  isLoggedIn: boolean = false;

  constructor(
    private authService: AuthService,
    private userService: UserService,
    private _renderer2: Renderer2, 
    @Inject(DOCUMENT) private _document: Document
  ) {
    this.subscriptions.push(
      this.authService.isLoggedInObservable.subscribe((isLoggedIn) => {
        this.isLoggedIn = isLoggedIn;
      })
    );
  }

  ngOnInit(): void {

    let script = this._renderer2.createElement('script');
        script.type = `application/ld+json`;
        script.text = `
            {
                "@context": "https://schema.org"
                /* your schema.org microdata goes here */
            }
        `;

        this._renderer2.appendChild(this._document.body, script);
        
    this.subscriptions.push(
      this.authService.isLoggedInObservable.subscribe((logged) => {
        this.isLoggedIn = logged;
        if (logged) {
          this.subscriptions.push(
            this.userService.getCurrentUser().subscribe((res) => {
              this.loading = false;
            })
          );
        }
      })
    );
    this.authService.checkStatus();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach((x) => x.unsubscribe());
  }
}

import { UserService } from './shared/services/user.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
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
    private userService: UserService
  ) {
    this.subscriptions.push(
      this.authService.isLoggedInObservable.subscribe((isLoggedIn) => {
        this.isLoggedIn = isLoggedIn;
      })
    );
  }

  ngOnInit(): void {
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

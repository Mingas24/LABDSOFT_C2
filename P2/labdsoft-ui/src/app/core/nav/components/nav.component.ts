import { Subscription } from 'rxjs';
import { UserService } from './../../../shared/services/user.service';
import { AuthService } from './../../../shared/services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/shared/models/user.model';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {
  user!: User;

  constructor(
    private authService: AuthService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.user = this.userService.user;
  }

  logout() {
    this.authService.logout();
    window.location.reload();
  }
}

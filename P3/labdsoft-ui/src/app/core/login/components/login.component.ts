import { AuthRequest } from './../../../shared/models/auth-request.model';
import { AuthService } from '../../../shared/services/auth.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators
} from '@angular/forms';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit, OnDestroy {
  subscriptions: Subscription[] = [];
  loginForm: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl('')
  });
  submitted = false;
  invalidLogin = false;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: [
        '',
        [Validators.required, Validators.minLength(5), Validators.maxLength(20)]
      ],
      password: [
        '',
        [Validators.required, Validators.minLength(5), Validators.maxLength(40)]
      ]
    });
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach((x) => x.unsubscribe());
  }

  get f(): { [key: string]: AbstractControl } {
    return this.loginForm.controls;
  }

  onSubmit(): void {
    this.submitted = true;

    if (!this.loginForm.valid) {
      return;
    }
    let authRequest: AuthRequest = this.loginForm.value;
    this.subscriptions.push(
      this.authService.login(authRequest).subscribe((authResponse) => {
        if (!authResponse.success) {
          this.invalidLogin = true;
        }
      })
    );
  }
}

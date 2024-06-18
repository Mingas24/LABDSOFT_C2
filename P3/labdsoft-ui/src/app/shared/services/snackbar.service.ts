import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class SnackbarService {
  private SUCCESS_CSS_STR = 'green-snackbar';
  private ERROR_CSS_STR = 'red-snackbar';

  constructor(private snackbar: MatSnackBar) {}

  showSucessNotification(message: string) {
    this.snackbar.open(message, 'Close', {
      duration: 3000,
      panelClass: [this.SUCCESS_CSS_STR]
    });
  }

  showErrorNotification(message: string) {
    this.snackbar.open(message, 'Close', {
      duration: 3000,
      panelClass: [this.ERROR_CSS_STR]
    });
  }
}

import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'readonly',
  templateUrl: './readonly.component.html',
  styleUrls: ['./readonly.component.scss']
})
export class ReadonlyComponent implements OnInit {
  @Input() field: any = {};
  @Input() form!: FormGroup;

  constructor() {}

  ngOnInit(): void {}
}

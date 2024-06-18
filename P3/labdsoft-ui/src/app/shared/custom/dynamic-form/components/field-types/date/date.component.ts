import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'date',
  templateUrl: './date.component.html',
  styleUrls: ['./date.component.scss']
})
export class DateComponent implements OnInit {
  @Input() field: any = {};
  @Input() form!: FormGroup;

  constructor() {}

  ngOnInit(): void {}
}

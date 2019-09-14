import { Component, OnInit } from '@angular/core';
import {RestService} from "../connectivity/rest.service";
import {TagInputModule} from "ngx-chips";

@Component({
  selector: 'app-taskform',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.scss']
})
export class TaskFormComponent implements OnInit {

  items = [];
  inputTaskDescriptionModel: any;

  constructor(private restService: RestService) { }

  ngOnInit() {
  }

  click() {
    console.log(this.items);
  }
}

TagInputModule.withDefaults({
  tagInput: {
    placeholder: '+',
    secondaryPlaceholder: 'Теги для поиска'
  }
});

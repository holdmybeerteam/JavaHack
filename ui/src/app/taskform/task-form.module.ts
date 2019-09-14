import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {TaskFormRoutingModule} from './task-form-routing.module';
import {TaskFormComponent} from "./task-form.component";
import {TagInputModule} from "ngx-chips";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    TaskFormRoutingModule,
    TagInputModule,
    FormsModule
  ],
  declarations: [TaskFormComponent]
})
export class TaskFormModule {
}

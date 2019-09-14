import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {TaskFormRoutingModule} from './task-form-routing.module';
import {TaskFormComponent} from "./task-form.component";

@NgModule({
  imports: [
    CommonModule,
    TaskFormRoutingModule
  ],
  declarations: [TaskFormComponent]
})
export class TaskFormModule {
}

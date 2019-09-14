import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CommonModule} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {AuthGuard} from "./common/shared/guard";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {TagInputModule} from "ngx-chips";
import {TextareaAutosizeModule} from 'ngx-textarea-autosize';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    TagInputModule,
    FormsModule,
    ReactiveFormsModule,
    TextareaAutosizeModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}

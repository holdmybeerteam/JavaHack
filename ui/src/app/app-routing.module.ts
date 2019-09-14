import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AuthGuard} from "./common/shared/guard";

const routes: Routes = [
  { path: '', loadChildren: () => import('./common/layout/layout.module').then(m => m.LayoutModule), canActivate: [AuthGuard] },
  { path: 'login', loadChildren: () => import('./common/login/login.module').then(m => m.LoginModule) },
  { path: 'signup', loadChildren: () => import('./common/signup/signup.module').then(m => m.SignupModule) },
  { path: 'error', loadChildren: () => import('./common/server-error/server-error.module').then(m => m.ServerErrorModule) },
  { path: '**', redirectTo: 'not-found' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

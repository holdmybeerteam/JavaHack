import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../router.animations';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent {
    constructor(public router: Router) {}

    onLoggedin() {
        localStorage.setItem('isLoggedin', 'true');
    }
}

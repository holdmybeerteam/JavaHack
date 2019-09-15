import {Component, Input, OnInit} from '@angular/core';
import { routerTransition } from '../../../router.animations';
import {Task} from "./task";
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss'],
    animations: [routerTransition()]
})
export class DashboardComponent implements OnInit{
    @Input()
    task: Task;
    par: any;

    constructor(private route: ActivatedRoute) {
        this.route.params.subscribe(params => this.par = params);
    }

    ngOnInit() {
        console.log(this.par);
        console.log("Heelllo, motherfucker");
    }
}

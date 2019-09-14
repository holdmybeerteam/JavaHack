import {Component, Input} from '@angular/core';
import {TaskAction, TaskInfo} from "./task-info";

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.scss']
})
export class TimelineComponent {
    @Input()
    taskInfo: TaskInfo[] = [
        new TaskInfo(
            'TITLE',
            'DESCRIPTION',
            TaskAction.ExecutorSubmitted,
            new Date()),
        new TaskInfo(
            'TITLE',
            'DESCRIPTION',
            TaskAction.ClientAsked,
            new Date())
    ];

    trackByFn(index, item) {
        return index;
    }
}

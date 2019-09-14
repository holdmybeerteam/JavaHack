import * as moment from "moment";

export enum TaskAction {
    ClientSubmitted,
    ClientAccepted,
    ExecutorAccepted,
    ExecutorSubmitted,
    ClientPartiallyAccepted,
    ClientRejected,
    ExecutorRejected,
    ExecutorAsked,
    ClientAsked
}

export const taskIcons = {
    [TaskAction.ClientSubmitted]: [`<i class="fa fa-info"></i>`, 'timeline-badge', 'info'],
    [TaskAction.ClientAccepted]: [`<i class="fa fa-graduation-cap"></i>`, 'timeline-badge', 'success'],
    [TaskAction.ExecutorAccepted]: [`<i class="fa fa-info></i>`, 'timeline-inverted', 'info'],
    [TaskAction.ExecutorSubmitted]: [`<i class="fa fa-space-shuttle" ></i>`, 'timeline-inverted', 'success'],
    [TaskAction.ClientPartiallyAccepted]: [`<i class="fa fa-minus-circle" ></i>`,'timeline-badge', 'warning'],
    [TaskAction.ClientRejected]: [`<i class="fa fa-exclamation-circle">`, 'timeline-badge', 'danger'],
    [TaskAction.ExecutorRejected]: [`<i class="fa fa-exclamation-circle">`, 'timeline-inverted', 'danger'],
    [TaskAction.ExecutorAsked]: [`<i class="fa fa-question-circle">`, 'timeline-inverted', 'info'],
    [TaskAction.ClientAsked]: [`<i class="fa fa-question-circle">`, 'timeline-badge', 'info']
};

export class TaskInfo {
    constructor(
        readonly title: string,
        readonly description: string,
        readonly action: TaskAction,
        readonly time: Date
    ) {}

    get timeLeft(): string {
        return moment(this.time).fromNow();
    }

    get html(): string {
        return taskIcons[this.action][0];
    }

    get statusClass(): string {
        return taskIcons[this.action][2];
    }

    get positionClass(): string {
        return taskIcons[this.action][1];
    }
}

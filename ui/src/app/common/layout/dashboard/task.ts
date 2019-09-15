import {TaskInfo} from "./components/timeline/task-info";

export class Task {
    constructor(readonly id: number, readonly title: string, readonly taskInfo: TaskInfo[]) {}
}

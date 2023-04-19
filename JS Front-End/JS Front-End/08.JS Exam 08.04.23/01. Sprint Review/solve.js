function solve(input) {
    let n = Number(input.shift());
    let tasksObj = {};
    let points = {
        ToDo: 0,
        'In Progress': 0,
        'Code Review': 0,
        Done: 0
    }

    for (let i = 0; i < n; i++) {
        let [assignee, taskId, title, status, estimatedPoints] = input.shift().split(':');
        if (!tasksObj.hasOwnProperty(assignee)) {
            tasksObj[assignee] = [];
        }
        tasksObj[assignee].push({ taskId, title, status, estimatedPoints });
        points[status] += Number(estimatedPoints);
    }

    for (const line of input) {
        let commandLine = line.split(':');
        let command = commandLine.shift();
        let assignee = commandLine.shift();
        //Add New
        if (command === 'Add New') {
            let [taskId, title, status, estimatedPoints] = commandLine;
            if (tasksObj.hasOwnProperty(assignee)) {
                tasksObj[assignee].push({ taskId, title, status, estimatedPoints });
                points[status] += Number(estimatedPoints);
            } else {
                console.log(`Assignee ${assignee} does not exist on the board!`);
            }
            //Change Status
        } else if (command === 'Change Status') {
            let [taskId, newStatus] = commandLine;
            if (!tasksObj.hasOwnProperty(assignee)) {
                console.log(`Assignee ${assignee} does not exist on the board!`)
            } else {
                for (const task of tasksObj[assignee]) {
                    if (task.taskId !== taskId) {
                        console.log(`Task with ID ${taskId} does not exist for ${assignee}!`);
                    } else {
                        points[task.status] -= task.estimatedPoints;
                        task.status = newStatus;
                        points[newStatus] += Number(task.estimatedPoints);
                    }
                }
            }
            //Remove Task
        } else if (command === 'Remove Task') {
            let [index] = commandLine;
            if (!tasksObj.hasOwnProperty(assignee)) {
                console.log(`Assignee ${assignee} does not exist on the board!`)
            } else {
                if (tasksObj[assignee].length <= index || index < 0) {
                    console.log('Index is out of range!')
                } else {
                    let pointsToRemove = tasksObj[assignee][index].estimatedPoints;
                    let currentStatus = tasksObj[assignee][index].status;
                    points[currentStatus] -= Number(pointsToRemove);
                    tasksObj[assignee].splice(Number(index), 1);
                }
            }
        }
    }
    console.log(`ToDo: ${points['ToDo']}pts`);
    console.log(`In Progress: ${points['In Progress']}pts`);
    console.log(`Code Review: ${points['Code Review']}pts`);
    console.log(`Done Points: ${points['Done']}pts`);

    if (points['Done'] >= (points['ToDo'] + points['In Progress'] + points['Code Review'])) {
        console.log('Sprint was successful!');
    } else {
        console.log('Sprint was unsuccessful...');
    }
}

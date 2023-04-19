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
                const validId = tasksObj[assignee].filter(e => e.taskId === taskId);
                if (validId.length === 0) {
                    console.log(`Task with ID ${taskId} does not exist for ${assignee}!`);
                } else {
                    for (const task of tasksObj[assignee]) {
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

solve([
    '5',
    'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
    'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
    'Peter:BOP-1211:POC:Code Review:5',
    'Georgi:BOP-1212:Investigation Task:Done:2',
    'Mariya:BOP-1213:New Account Page:In Progress:13',
    'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
    'Change Status:Mariya:BOP-1290:ToDo',
    'Remove Task:Mariya:1',
    'Remove Task:Joro:1',
]
);
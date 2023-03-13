function flightSch(input) {
    let flights = {};

    input[0].forEach(line => {
        let [flightNum, destination] = line.split(' ');
        flights[flightNum] = {
            Destination: destination,
            Status: 'Ready to fly'
        }
    });

    input[1].forEach(line => {
        let [flightNum, status] = line.split(' ');
        if (flights.hasOwnProperty(flightNum)) {
            flights[flightNum].Status = status;
        }
    });

    let toPrint = String(input[2]);

    for (const flight in flights) {
        if (flights[flight].Status === toPrint) {
            console.log(flights[flight]);
        }
    }

}
// Test
flightSch([['WN269 Delaware',
    'FL2269 Oregon',
    'WN498 Las Vegas',
    'WN3145 Ohio',
    'WN612 Alabama',
    'WN4010 New York',
    'WN1173 California',
    'DL2120 Texas',
    'KL5744 Illinois',
    'WN678 Pennsylvania'],
['DL2120 Cancelled',
    'WN612 Cancelled',
    'WN1173 Cancelled',
    'SK330 Cancelled'],
['Ready to fly']
]
);

flightSch([['WN269 Delaware',
'FL2269 Oregon',
 'WN498 Las Vegas',
 'WN3145 Ohio',
 'WN612 Alabama',
 'WN4010 New York',
 'WN1173 California',
 'DL2120 Texas',
 'KL5744 Illinois',
 'WN678 Pennsylvania'],
 ['DL2120 Cancelled',
 'WN612 Cancelled',
 'WN1173 Cancelled',
 'SK430 Cancelled'],
 ['Cancelled']
]
);

function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      let inputArr = JSON.parse(document.querySelector('#inputs textarea').value);
      let avgSalary = 0;
      let ttlSalary = 0;
      let currAvgSalary = 0;
      let bestRestaurantName = '';
      let output = {};

      for (let element of inputArr) {
         let restaurantInfo = element.split(' - ');
         let restaurantName = restaurantInfo.shift();
         let workersInfo = restaurantInfo[0].split(', ');
         for (let worker of workersInfo) {
            let [name, salary] = worker.split(' ');

            if (!output.hasOwnProperty(restaurantName)) {
               output[restaurantName] = {};
               output[restaurantName][name] = Number(salary);
            } else {
               output[restaurantName][name] = Number(salary);
            }
         }
      }

      let entries = Object.entries(output);
      for (let entry of entries) {
         let key = entry[0];
         let values = Object.entries(entry[1]);
         for (let [name, salary] of values) {
            ttlSalary += salary;
         }

         avgSalary = ttlSalary / values.length;

         if (avgSalary > currAvgSalary) {
            currAvgSalary = avgSalary;
            bestRestaurantName = key;
            ttlSalary = 0;
         }
      }

      let toPrint = '';
      let result = Object.entries(output[bestRestaurantName]).sort((w1, w2) => w2[1] - w1[1]);

      result.forEach((w) => toPrint += `Name: ${w[0]} With Salary: ${w[1]} `);

      document.querySelector('#bestRestaurant p')
         .textContent = `Name: ${bestRestaurantName} Average Salary: ${currAvgSalary.toFixed(2)} Best Salary: ${result[0][1].toFixed(2)}`;

      document.querySelector('#workers p').textContent = toPrint;
   }
}










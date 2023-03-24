function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/forecaster/';
    const inputField = document.getElementById('location');
    const getWeatherBtn = document.getElementById('submit');
    const forecastContainer = document.getElementById('forecast');
    const currentForecast = document.getElementById('current');
    const upcomingForecast = document.getElementById('upcoming');
    let sunny = '&#x2600';
    let partlySunny = '&#x26C5';
    let overcast = '&#x2601';
    let rain = '&#x2614';
    let degrees = '&#176';
    let code = '';
    let divElCurrent = document.createElement('div');
    let divElUpcoming = document.createElement('div');


    getWeatherBtn.addEventListener('click', getWeather);

    function getWeather() {
        divElCurrent.innerHTML = '';
        divElUpcoming.innerHTML = '';
        forecastContainer.style.display = 'block';

        divElCurrent.setAttribute('class', 'forecasts');
        divElUpcoming.setAttribute('class', 'forecast-info');

        fetch(`${BASE_URL}locations`)
            .then((response) => response.json())
            .then((data) => {
                data.forEach(locationObj => {
                    if (locationObj.name === inputField.value) {
                        code = locationObj.code;
                    }
                });

                fetch(`${BASE_URL}today/${code}`)
                    .then(response => response.json())
                    .then(data => {
                        let conditionSpan = document.createElement('span');
                        conditionSpan.setAttribute('class', 'condition');
                        let tempSpan = document.createElement('span');
                        tempSpan.setAttribute('class', 'forecast-data');
                        let citySpan = document.createElement('span');
                        citySpan.setAttribute('class', 'forecast-data')
                        let weatherSpan = document.createElement('span');
                        weatherSpan.setAttribute('class', 'forecast-data');
                        let weatherSymbolSpan = document.createElement('span');
                        weatherSymbolSpan.setAttribute('class', 'condition symbol');

                        citySpan.textContent = data.name;
                        tempSpan.innerHTML = `${data.forecast.low}${degrees}/${data.forecast.high}${degrees}`;
                        weatherSpan.textContent = data.forecast.condition;

                        if (data.forecast.condition == 'Sunny') {
                            weatherSymbolSpan.innerHTML = sunny;
                        } else if (data.forecast.condition == 'Partly sunny') {
                            weatherSymbolSpan.innerHTML = partlySunny;
                        } else if (data.forecast.condition == 'Overcast') {
                            weatherSymbolSpan.innerHTML = overcast;
                        } else if (data.forecast.condition == 'Rain') {
                            weatherSymbolSpan.innerHTML = rain;
                        }

                        conditionSpan.appendChild(citySpan);
                        conditionSpan.appendChild(tempSpan);
                        conditionSpan.appendChild(weatherSpan);

                        divElCurrent.appendChild(weatherSymbolSpan);
                        divElCurrent.appendChild(conditionSpan);

                        currentForecast.appendChild(divElCurrent);

                    })
                    .catch(error => console.log(error))

                fetch(`${BASE_URL}upcoming/${code}`)
                .then(response => response.json())
                .then(data => {
                    let upcomingDays = data.forecast;
                    upcomingDays.forEach(day => {
                        let weatherSymbolSpan = document.createElement('span');
                        weatherSymbolSpan.setAttribute('class', 'symbol');
                        let conditionSpan = document.createElement('span');
                        conditionSpan.setAttribute('class', 'upcoming');
                        let tempSpan = document.createElement('span');
                        tempSpan.setAttribute('class', 'forecast-data');
                        let weatherSpan = document.createElement('span');
                        weatherSpan.setAttribute('class', 'forecast-data');
                        

                        tempSpan.innerHTML = `${day.low}${degrees}/${day.high}${degrees}`;
                        weatherSpan.textContent = day.condition;

                        if (day.condition == 'Sunny') {
                            weatherSymbolSpan.innerHTML = sunny;
                        } else if (day.condition == 'Partly sunny') {
                            weatherSymbolSpan.innerHTML = partlySunny;
                        } else if (day.condition == 'Overcast') {
                            weatherSymbolSpan.innerHTML = overcast;
                        } else if (day.condition == 'Rain') {
                            weatherSymbolSpan.innerHTML = rain;
                        }

                        conditionSpan.appendChild(weatherSymbolSpan);
                        conditionSpan.appendChild(tempSpan);
                        conditionSpan.appendChild(weatherSpan);

                        divElUpcoming.appendChild(conditionSpan);

                        upcomingForecast.appendChild(divElUpcoming);
                    })

                })
                .catch(error => console.log(error))
            })
            .catch((error) => console.log(error))
    }
}

attachEvents();
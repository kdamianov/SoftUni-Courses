function cityTaxes(name, population, treasury) {
    let city = {
        name,
        population,
        treasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += Math.trunc(this.population * this.taxRate);
        },
        applyGrowth(percentage) {
            this.population += Math.trunc(this.population * (percentage/ 100));
        },
        applyRecession(percentage) {
            this.treasury -= Math.trunc(this.treasury * (percentage/ 100));
        }
    }

    return city;
}


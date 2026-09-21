const random = require('random-number-generator');

function tirarDaus() {
    const dau1 = random(6); // Random integer between 0 and 6 (exclusive), so 0-5
    const dau2 = random(6); // Random integer between 0 and 6 (exclusive), so 0-5
    return dau1+dau2
}

console.log("La suma dels dos daus es:",tirarDaus());

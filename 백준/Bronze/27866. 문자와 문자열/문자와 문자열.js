const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let str = input[0];
let number = input[1];

console.log(str.charAt(number-1));


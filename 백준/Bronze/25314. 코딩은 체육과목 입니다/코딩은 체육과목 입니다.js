const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().split(" ");

const N = parseInt(input[0]);

for(i=0;i<N/4;i++){
    process.stdout.write("long ");
}
process.stdout.write("int");
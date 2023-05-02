const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const [N,M] = input[0].split(' ').map(item=>Number(item)); 

let list = new Array(N);
for(a=0;a<N;a++){
    list[a]=0;
}

for(a=1;a<=M;a++){
    let [i,j,k] = input[a].split(' ').map(item=>Number(item));
    for(b=i;b<=j;b++){
        list[b-1]=k;
    }
}

console.log(list.join(" "));

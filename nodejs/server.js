const http = require('http');


http.createServer(handler).listen(8080);

function handler(req, res) {
    if (req.url.length < 2) {
        res.write('Please enter some number as path.');
        return res.end();
    }
    let n = parseInt(req.url.substring(1, req.url.length));
    if (isNaN(n)) {
        res.write('Path is not a number.');
        res.end();
    } else {
        let result = arrayToString(fib(n));
        res.write(`Fibonacci sequence your requested: \n${result}`);
        res.end();
    }
}

function arrayToString(array) {
    let result = "";
    for (let i = 0; i < array.length; i++) {
        result += `${i + 1}: ${array[i]} \n`;
    }
    return result;
}

function fib(max) {
    let sequence = [0,1]
    for (let i = 2; i < max; i++) {
        sequence[i] = sequence[i - 1] + sequence[i - 2]
    }
    return sequence;
}
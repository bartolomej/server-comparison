const http = require('http');

const PORT = 8000;

http.createServer(handler).listen(PORT);
console.log(`Node.js server started on port ${PORT}`);

function handler(req, res) {
    if (req.url.length < 2) {
        res.write('Node.js server is asking you to enter some number as a path :)');
        return res.end();
    }
    let n = parseInt(req.url.substring(1, req.url.length));
    if (isNaN(n)) {
        res.write('Path is not a number.');
        res.end();
    } else {
        let result = arrayToString(fib(n));
        res.write(`Fibonacci sequence your requested: \n`);
        res.write(result);
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
    let sequence = [0,1];
    for (let i = 2; i < max; i++) {
        sequence[i] = sequence[i - 1] + sequence[i - 2]
    }
    return sequence;
}
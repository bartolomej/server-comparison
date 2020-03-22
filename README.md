# Server comparison

Performance comparison of a simple "framework-free" server application, written in 
[Golang](https://golang.org/), 
[Node.js](https://nodejs.org/en/),
[Python](https://www.python.org/).

Performance testing is done by a simple tool [Hey](https://github.com/rakyll/hey).
Install for MacOS via `brew install hey`.

## Running

| LANGUAGE   |      PORT    |
|----------|:-------------:|
| Node.js |  8000 |
| Golang |    8001  |
| Python | 8002 |

Run tests:
1. Start servers with `sh start.sh`
2. Run tests: `sh test.sh <url-path> <requests>`

Example:
```bash
sh start.sh && sh test.sh /1000 10
```
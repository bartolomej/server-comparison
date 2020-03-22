from BaseHTTPServer import BaseHTTPRequestHandler, HTTPServer

PORT = 8000


def array_to_string(array):
    result = ""
    for i in range(0, len(array)):
        result += str(i + 1) + ": " + str(array[i]) + "\n"
    return result


def fib(max_n):
    sequence = [0, 1]
    for i in range(2, max_n):
        sequence.append(sequence[i - 1] + sequence[i - 2])
    return sequence


class Handler(BaseHTTPRequestHandler):

    # Handler for the GET requests
    def do_GET(self):
        self.send_response(200)
        self.send_header('Content-type', 'text/html')
        self.end_headers()
        # Send the html message
        try:
            self.wfile.write(
                "Fibonacci sequence you requested: \n" +
                array_to_string(fib(int(self.path[1:])))
            )
        except ValueError:
            self.wfile.write("Path is not a number")
        return


try:
    # Create a web server and define the handler to manage the
    # incoming request
    server = HTTPServer(('', PORT), Handler)
    print('Started httpserver on port ', PORT)

    # Wait forever for incoming htto requests
    server.serve_forever()

except KeyboardInterrupt:
    print('^C received, shutting down the web server')
    server.socket.close()

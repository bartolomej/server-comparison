package main

import (
	"fmt"
	"log"
	"net/http"
	"strconv"
)

func main() {
	http.HandleFunc("/", handler)
	log.Fatal(http.ListenAndServe(":8080", nil))
}

func handler(w http.ResponseWriter, r *http.Request) {
	if len(r.URL.Path) < 2 {
		fmt.Fprint(w, "Enter number of fibonacci sequence elements as path :)")
		return;
	}
	i, err := strconv.Atoi(r.URL.Path[1:])
	if err != nil {
		fmt.Fprint(w, "Path is not a number :(")
		return
	}
	fmt.Fprintf(w, "Here is your fibonacci sequence: \n%s", sliceToString(fib(i)))
}

func sliceToString (array []int64) string {
	result := ""
	for i := 0; i < len(array); i++ {
		result += strconv.Itoa(i + 1) + ": " + strconv.Itoa(int(array[i])) + "\n"
	}
	return result
}

func fib (max int) []int64 {
	sequence := make([]int64 , max)
	sequence[0] = 0
	sequence[1] = 1
	for i := 2; i < max; i++ {
		sequence[i] = sequence[i - 1] + sequence[i - 2]
	}
	return sequence
}

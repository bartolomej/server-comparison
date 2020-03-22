package main

import (
	"fmt"
	"log"
	"math/big"
	"net/http"
	"strconv"
)

const PORT = 8001

func main() {
	fmt.Println("Go server started on port " + strconv.Itoa(PORT))
	http.HandleFunc("/", handler)
	log.Fatal(http.ListenAndServe(":" + strconv.Itoa(PORT), nil))
}

func handler(w http.ResponseWriter, r *http.Request) {
	if len(r.URL.Path) < 2 {
		fmt.Fprint(w, "Go server is asking you to enter some number as a path :)")
		return
	}
	i, err := strconv.Atoi(r.URL.Path[1:])
	if err != nil {
		fmt.Fprint(w, "Path is not a number :(")
		return
	}
	if i < 2 {
		fmt.Fprintf(w, "Please enter a number larger that %d :(", i)
		return
	}
	fmt.Fprint(w, "Here is your fibonacci sequence: \n")
	fmt.Fprint(w, sliceToString(fib(i)))
}

func sliceToString (array []*big.Int) string {
	result := ""
	for i := 0; i < len(array); i++ {
		result += strconv.Itoa(i + 1) + ": " + array[i].String() + "\n"
	}
	return result
}

func fib (max int) []*big.Int {
	sequence := make([]*big.Int , max)
	sequence[0] = big.NewInt(0)
	sequence[1] = big.NewInt(1)
	for i := 2; i < max; i++ {
		sequence[i] = big.NewInt(0).Add(sequence[i - 1], sequence[i - 2])
	}
	return sequence
}

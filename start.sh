node nodejs/server.js &
go run golang/server.go &
python python/server.py
kotlinc kotlin/src/server.kt -include-runtime -d kotlin/out/server.jar
java -jar kotlin/out/server.jar

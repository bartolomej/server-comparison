# Kotlin server

Kotlin is compiled to .jar file and run in JVM.

Compile src/server.kt:
```bash
kotlinc src/server.kt -include-runtime -d out/server.jar
```

Run out/server.jar:
```bash
java -jar out/server.jar
```
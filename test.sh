path=$1
requests=$2

echo "NUMBER OF REQUESTS: $requests"
echo "PATH: $path"
echo "\n"

echo "-----------------------NODE.js"
echo "\n"
hey "http://localhost:8000${path}"
echo "\n"

echo "-----------------------GOLANG"
hey "http://localhost:8001${path}"
echo "\n"

echo "-----------------------PYTHON"
hey "http://localhost:8002${path}"

echo "-----------------------KOTLIN"
hey "http://localhost:8003${path}"
path=$1
requests=$2
output_file=$3

echo "NUMBER OF REQUESTS: $requests"
echo "PATH: $path"

output=""

output+="---------------------------NODE.JS"
output+=$(hey "http://localhost:8000${path}")
output+="\n"


output+="---------------------------GOLANG"
output+=$(hey "http://localhost:8001${path}")
output+="\n"

output+="---------------------------PYTHON"
output+=$(hey "http://localhost:8002${path}")
output+="\n"


echo $output >> $output_file
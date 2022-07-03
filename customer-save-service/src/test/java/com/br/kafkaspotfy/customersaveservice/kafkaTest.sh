echo "Executando o curl";

curl --header "Content-Type: application/json"\
  --request POST \
  --data '{ "name": "Nome", "country": "BR", "musicStyle": "funk" }' \
  http://localhost:8081/v1/post

echo "\n";
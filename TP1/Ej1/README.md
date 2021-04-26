# Ejercicio 1 y 2
### Server:
**Docker:**
```sh
docker run -p 4000:4000 silvafacundo/sdypp-ej1-2:server
```
**Java:**
```sh
java -cp ./target/Ej1-1.0-SNAPSHOT.jar "app.Server" [port]
```
### Cliente:
**Docker:**
```sh
docker run --network="host" -it silvafacundo/sdypp-ej1-2:client
```
**Java:**
```sh
java -cp ./target/Ej1-1.0-SNAPSHOT.jar "app.Client" [host] [port]
```

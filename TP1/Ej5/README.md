# Ejercicio 5, 6 y 7

### Server
**Docker:**
```sh
docker run -p 4000:4000 silvafacundo/sdypp-ej5-6-7:server
```
**Java:**
```sh
java -cp ./target/Ej5-1.0-SNAPSHOT.jar "app.Server" [port]
```

### Client
**Docker:**
```sh
docker run --network="host" silvafacundo/sdypp-ej5-6-7:client
```
**Java:**
```sh
java -cp ./target/Ej5-1.0-SNAPSHOT.jar "app.Client" [host] [port]
```
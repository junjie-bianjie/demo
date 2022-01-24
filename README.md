
# build images

```shell
    docker build -t demo .
```

# run

````shell
    docker run -p8080:8080 -it --name demo demo
````

# get api
```shell
    curl localhost:8080/query_account
```

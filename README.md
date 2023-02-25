## Bug when using typesense-java post version 0.0.6 in Kotlin runtime JVM

Guide to reproduce bug in `typesense-java` after changing to 
OkHttp client post version `0.0.6`.

Run file `RunMain.kt` and observe the results:

w/ `org.typesense:typesense-java:0.0.6`:
```
{"success":true}
{"success":true}
```


w/ `org.typesense:typesense-java:0.0.9-beta4`:

```
{"code":400,"document":"\"{\\\"countryName\\\": \\\"India\\\", \\\"gdp\\\": 5215}\\n{\\\"countryName\\\": \\\"Iran\\\", \\\"gdp\\\": 5215}\"","error":"Bad JSON: not a properly formed document.","success":false}
```


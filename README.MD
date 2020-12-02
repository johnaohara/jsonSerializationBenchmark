Comparison of JSON Serialization to File
========================================

This repository contains a JMH benchmark to measure the average time to serialize an Array of Objects to disk using;
 - GSON
 - JSON-B + yasson
 - Jackson

*N.B. this benchmark has been ran in a single thread, there is nothing to manage contention between threads writing to the same file*

Results
-------

Benchmark                                  |Mode  |Cnt    |Score   |Error  |Units
---|---|---|---|---|---
SerializationBenchmark.testGson             |avgt   |50   |65.464 |± 1.232  |us/op
SerializationBenchmark.testGsonNotFlushing  |avgt   |50   |63.178 |± 0.677  |us/op
SerializationBenchmark.testJackson          |avgt   |50   |29.759 |± 0.239  |us/op
SerializationBenchmark.testJsonB            |avgt   |50  |116.546 |± 1.216  |us/op
SerializationBenchmark.testJsonBFileWriter  |avgt   |50  |121.553 |± 2.058  |us/op


How to run
----------

 - Build benchmark
 
```shell script
$ mkdir -p /tmp/benchdata/
$ mvn clean package
```

 - Run Benchmark
 
 ```shell script
$ java -jar target/benchmarks.jar  -wi 5 -i 10 
```

# Introduction
This repo is used for testing how jvm is initialized in kubernetes. The article to explain the output of various pod configs is published on medium.com


# Setup 
I have setup minikube k8s cluster with podman as driver. You can use the minikube config file under `.minikube/config/config.json`
There are two files relevant to this test.
* JvmStatisticsInfo: this is a simple java class part of jvm-stats maven project that print jvm stats like availableProcessors, Garbage collector used and Heap memory. 
* Dockerfile: this packages JvmStatisticsInfo with jdk 21 into a container image

start test k8s cluster with `minikube start` command. 
build jvm-stats maven project `mvn clean package`
then run `build_minikube.sh` to build the container image and upload to the minikube container registry.

# Execution

deploy each pod to k8s with
`kubectl apply -f jvm-stats1.yaml` and so forth. Then you can pull logs for the container than ran and printed the stats with:
`kubectl logs pod/jvm-stats1` and so forth. Below are 

## jvm-stats1.yaml

```text
Total Available Processors: 1
Garbage Collectors in use:
- Copy
- MarkSweepCompact
Total Heap Memory (Max): 247 MB
```

## jvm-stats2.yaml

```text
Total Available Processors: 5
Garbage Collectors in use:
- G1 Young Generation
- G1 Concurrent GC
- G1 Old Generation
Total Heap Memory (Max): 1840 MB
```

## jvm-stats3.yaml

```text
Total Available Processors: 1
Garbage Collectors in use:
- Copy
- MarkSweepCompact
Total Heap Memory (Max): 1484 MB
```

## jvm-stats4.yaml

```text
Total Available Processors: 1
Garbage Collectors in use:
- ZGC Minor Cycles
- ZGC Minor Pauses
- ZGC Major Cycles
- ZGC Major Pauses
Total Heap Memory (Max): 1536 MB
```

## jvm-stats5.yaml

```text
Total Available Processors: 2
Garbage Collectors in use:
- ZGC Minor Cycles
- ZGC Minor Pauses
- ZGC Major Cycles
- ZGC Major Pauses
Total Heap Memory (Max): 1536 MB
```

## jvm-stats6.yaml

```text
Total Available Processors: 4
Garbage Collectors in use:
- ZGC Minor Cycles
- ZGC Minor Pauses
- ZGC Major Cycles
- ZGC Major Pauses
Total Heap Memory (Max): 1536 MB
```
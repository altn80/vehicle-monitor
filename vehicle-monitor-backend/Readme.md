# vehicle-monitor

## Build/Run Requirements
* apache maven 3
* jdk 1.8
* docker 18.09.7

## Build Instructions

  ```
  mvn clean package
  ```

## Run Instructions

  ```
  sudo docker build . -t vehicle-monitor-backend
  sudo docker run -p 8080:8080 -t vehicle-monitor-backend

  ```

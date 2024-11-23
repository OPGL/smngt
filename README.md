# Simple Server Management API

## Compilation

To compile the project, you can use the following commands:

### Build with JAR:
```bash
./mvnw package
```

### Build as a Native Image:
```bash
./mvnw package -Dpackaging=native-image
```

### Build as a docker image
```bash
./build_docker.sh
```

## Usage

### Usage (built with JAR)
```bash
java -jar ./target/smngt.jar
```

### Usage (build as a Native Image)
```bash
./target/smngt
```

### Usage (built as a Docker Image)
#### docker-compose (no need of building image)
```bash
docker compose up
```
#### docker run
```bash
docker run smngt
```

## Overview

This is a program designed for server management. It provides various options for monitoring system resources such as CPU and memory usage, and system information like the OS version. Currently, the program is in active development.

## Environment Variables

- **MICRONAUT_SERVER_PORT**: The environment variable used to define the server port. This can be set to configure which port the application will run on.

## API Endpoints

Once the application is running, you can access the following API endpoint:

### 1. `/api/sysinfo` (System Information)

This endpoint provides detailed system information including the operating system, CPU, and RAM usage.

**Example Response:**
```json
{
  "os": {
    "name": "Fedora",
    "version": "41"
  },
  "cpu": {
    "processorName": "12th Gen Intel(R) Core(TM) i5-12400F",
    "cpuUsage": 13.008130081300814,
    "coreUsages": [
      {
        "cpu0": 7.8431372549019605
      },
      {
        "cpu1": 8
      },
      {
        "cpu2": 32
      },
      {
        "cpu3": 6.122448979591836
      },
      {
        "cpu4": 4.166666666666666
      },
      {
        "cpu5": 4
      },
      {
        "cpu6": 13.725490196078432
      },
      {
        "cpu7": 6
      },
      {
        "cpu8": 8
      },
      {
        "cpu9": 6
      },
      {
        "cpu10": 6.122448979591836
      },
      {
        "cpu11": 10
      }
    ]
  },
  "ram": {
    "ramTotal": 33472905216,
    "ramFree": 15211909120,
    "swapTotal": 8589930496,
    "swapUsed": 1310720
  }
}
```

- **OS Information**: Shows the name and version of the operating system.
- **CPU Usage**: Provides the processor name and the usage of each individual CPU core.
- **RAM Information**: Displays the total and available RAM in bytes.

## Current Status

This project is still under active development, and additional features and improvements will be added in the future.

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
    "version": "41",
    "uptime": 16036
  },
  "cpu": {
    "processorName": "12th Gen Intel(R) Core(TM) i5-12400F",
    "cpuUsage": 6.0200668896321075,
    "coreUsages": [
      {
        "cpu0": 6.122448979591836
      },
      {
        "cpu1": 2
      },
      {
        "cpu2": 8
      },
      {
        "cpu3": 6.122448979591836
      },
      {
        "cpu4": 4
      },
      {
        "cpu5": 2.0408163265306123
      },
      {
        "cpu6": 2.083333333333333
      },
      {
        "cpu7": 2.0408163265306123
      },
      {
        "cpu8": 8.16326530612245
      },
      {
        "cpu9": 5.88235294117647
      },
      {
        "cpu10": 4
      },
      {
        "cpu11": 5.88235294117647
      }
    ]
  },
  "ram": {
    "ramTotal": 33472909312,
    "ramFree": 13626728448,
    "swapTotal": 8589930496,
    "swapUsed": 707788800
  },
  "disk": {
    "total": 1552249749504,
    "free": 1172867170304
  }
}
```

- **OS Information**: Shows the name and version of the operating system.
- **CPU Usage**: Provides the processor name and the usage of entire cpu and each individual CPU core.
- **RAM Information**: Displays the total and available RAM/SWAP in bytes.
- **Disk Information**: Displays the total and available Disk space in bytes.

## Current Status

This project is still under active development, and additional features and improvements will be added in the future.

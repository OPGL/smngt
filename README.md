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
    "cpuUsage": 5,
    "coreUsages": [
      {"cpu0": 6},
      {"cpu1": 5},
      {"cpu2": 6},
      {"cpu3": 5},
      {"cpu4": 6},
      {"cpu5": 5},
      {"cpu6": 6},
      {"cpu7": 5},
      {"cpu8": 6},
      {"cpu9": 5},
      {"cpu10": 6},
      {"cpu11": 5}
    ]
  },
  "ram": {
    "total": 33472913408,
    "free": 20653191168
  }
}
```

- **OS Information**: Shows the name and version of the operating system.
- **CPU Usage**: Provides the processor name and the usage of each individual CPU core.
- **RAM Information**: Displays the total and available RAM in bytes.

## Current Status

This project is still under active development, and additional features and improvements will be added in the future.

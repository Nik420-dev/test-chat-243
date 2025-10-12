# Spring Boot Chat Application with OpenRouter API

This is a Spring Boot application that provides a chat-like interface for interacting with the OpenRouter API.

## Features

- **Java 11** based Spring Boot application
- **Maven** for dependency management
- **Thymeleaf** for the frontend UI
- **RestTemplate** for API communication
- Chat-like interface with message input and response display
- Integration with OpenRouter API

## Project Structure

```
day2lesson2/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── example/
        │           └── chatapp/
        │               ├── ChatAppApplication.java
        │               ├── controller/
        │               │   └── MessageController.java
        │               └── service/
        │                   └── OpenRouterService.java
        └── resources/
            ├── application.yml
            └── templates/
                └── chat.html
```

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- OpenRouter API key

## Setup Instructions

1. **Set your OpenRouter API Key:**
   
   You have two options:
   
   **Option 1: Environment Variable (Recommended)**
   ```bash
   export OPENROUTER_API_KEY="your-api-key-here"
   ```
   
   **Option 2: Direct Configuration**
   Edit `src/main/resources/application.yml` and replace `${OPENROUTER_API_KEY}` with your actual API key.

2. **Build the application:**
   ```bash
   mvn clean compile
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**
   Open your browser and navigate to: `http://localhost:8080`

## Usage

1. Open the application in your browser
2. Type your question in the text area
3. Click "Send Message" to send your question to the OpenRouter API
4. The response will be displayed in the message box above

## Configuration

The application configuration is in `src/main/resources/application.yml`:

```yaml
server:
  port: 8080

openrouter:
  api-url: "https://openrouter.ai/api/v1/chat/completions"
  api-key: "${OPENROUTER_API_KEY}"
  model: "openai/gpt-oss-20b:free"
```

## API Integration

The application sends POST requests to the OpenRouter Chat Completions API (`https://openrouter.ai/api/v1/chat/completions`) with the following structure:

```json
{
  "model": "openai/gpt-oss-20b:free",
  "messages": [
    {
      "role": "user",
      "content": "Your question here"
    }
  ],
  "max_tokens": 1000,
  "temperature": 0.7
}
```

The API key is sent in the Authorization header as a Bearer token. The application automatically parses the JSON response to extract the message content.

## Technologies Used

- **Spring Boot 2.7.18** - Main framework
- **Spring Web** - REST API and web functionality
- **Thymeleaf** - Template engine for UI
- **RestTemplate** - HTTP client for API calls
- **Maven** - Build tool and dependency management
- **Java 11** - Programming language

## Troubleshooting

1. **API Key Issues:**
   - Ensure your OpenRouter API key is correctly set
   - Check that the environment variable is properly exported

2. **Connection Issues:**
   - Verify your internet connection
   - Check if the OpenRouter API endpoint is accessible

3. **Build Issues:**
   - Ensure Java 11 is installed and configured
   - Verify Maven is properly installed

## Development

To run in development mode with hot reload:

```bash
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.devtools.restart.enabled=true"
```

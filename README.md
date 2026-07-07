# AI-Powered Email Copilot

AI-powered real-time email reply generator built using Spring Boot and Gemini AI.

## 🚀 Overview

AI-Powered Email Copilot is an intelligent email assistant that generates professional and context-aware email replies in real time. The application analyzes incoming email content and uses Google's Gemini AI model to generate smart responses instantly.

This project demonstrates the integration of Generative AI APIs with a full-stack backend application using Spring Boot.

---

## ✨ Features

- Generate intelligent email replies instantly
- Professional tone-based response generation
- Real-time AI-powered suggestions
- REST API integration with Gemini AI
- Spring Boot backend architecture
- CORS-enabled API support
- Easy integration with browser extensions or frontend applications

---

## 🛠️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Web
- REST APIs

### AI Integration
- Gemini AI API

### Frontend
- JavaScript
- HTML/CSS
- Fetch API

### Tools
- Maven
- Git & GitHub
- VS Code / IntelliJ

---

## 📂 Project Structure

```bash
email-copilot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   ├── resources/
│   │
│   └── test/
│
├── pom.xml
├── README.md
└── .gitignore
content.js
```

---

## ⚙️ Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/dharanipath/Email_Copilot.git
```

### 2. Navigate to the Project

```bash
cd Email_Copilot
```

### 3. Configure Gemini API Key

Add your Gemini API key in:

```properties
application.properties
```

Example:

```properties

gemini.api.key=YOUR_API_URL
gemini.api.key=YOUR_API_KEY

```
### 4. Run the Application

```bash
mvn spring-boot:run
```

required host to run on local,it might different to run on a server:

```text
http://localhost:8080
```

---

## 📡 API Endpoint

### Generate Email Reply

```http
POST /api/email/generate
```

### Request Body

```json
{
  "emailContent": "Can we schedule a meeting tomorrow?",
  "tone": "professional"
}
```

### Response

```json
{
  "reply": "Thank you for reaching out. I would be happy to schedule a meeting tomorrow..."
}
```

---

## 🔒 CORS Configuration

The backend supports CORS configuration for frontend/browser extension integration.

Example:

```java
@CrossOrigin(origins = "*")
```

---

## 🎯 Future Enhancements

- Gmail API integration
- Browser extension support
- Multiple response tones
- AI summarization
- User authentication
- Email history management

---

## 👨‍💻 Author

Dharanipathi Pala

GitHub: https://github.com/dharanipath

---

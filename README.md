#  Real-Time Chat Application

A modern, feature-rich real-time chat application built with Spring Boot and WebSocket technology. Support text messages, image sharing, and audio file transmission with live preview capabilities.

![Chat Application Demo](https://img.shields.io/badge/Status-Active-brightgreen)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen)
![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blue)
![Frontend](https://img.shields.io/badge/Frontend-HTML5%2FJS-orange)

##  Features

###  Core Chat Features
- **Real-time messaging** - Instant message delivery using WebSocket/STOMP
- **User identification** - Set your name to identify messages
- **Message history** - See all messages in the current session
- **Auto-scroll** - Chat automatically scrolls to newest messages

###  File Sharing
- **Image sharing** - Send and view images directly in chat
- **Audio sharing** - Send MP3, WAV, and OGG audio files
- **File preview** - Preview files before sending
- **Click to expand** - Click images to view in fullscreen modal

###  Audio Features
- **Audio preview** - Listen to audio files before sending
- **In-chat playback** - Play audio messages with built-in controls
- **Multiple formats** - Support for MP3, WAV, and OGG formats
- **File size validation** - Automatic file size checking (5MB limit)

###  User Interface
- **Modern design** - Clean, responsive Bootstrap-based UI
- **Message bubbles** - Distinct styling for sent vs received messages
- **File type icons** - Visual indicators for different file types
- **Loading states** - User feedback during file processing

##  Technology Stack

### Backend
- **Spring Boot** - Main application framework
- **Spring WebSocket** - Real-time communication
- **STOMP Protocol** - WebSocket messaging protocol
- **Lombok** - Reduce boilerplate code

### Frontend
- **HTML5** - Modern web standards
- **Bootstrap 5** - Responsive CSS framework
- **SockJS** - WebSocket fallback support
- **STOMP.js** - Client-side STOMP implementation

##  Prerequisites

- Java 17 or higher
- Maven 3.6+
- Modern web browser with WebSocket support

##  Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/NguyenHoangNam-1410/Real-Time-Chat-App.git
cd realtime-chat-app
```

### 2. Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

### 3. Access the Application
Open your browser and navigate to:
```
http://localhost:8080/chat
```
### Or you can run directly at 'ChatApplication.java' if you use IntelliJ IDEA

##  Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/chat/app/
│   │       ├── ChatApplication.java          # Main application class
│   │       ├── controller/
│   │       │   └── ChatController.java       # WebSocket message handling
│   │       ├── model/
│   │       │   └── ChatMessage.java          # Message entity
│   │       └── config/
│   │           └── WebSocketConfig.java      # WebSocket configuration
│   └── resources/
│       ├── templates/
│       │   └── chat.html                     # Chat interface
│       └── application.properties            # App configuration
```

##  Customization

### File Size Limits
Modify the file size limit in the JavaScript:
```javascript
const maxSize = 10 * 1024 * 1024; // 10MB in bytes
```

### Supported File Types
Update the file input accept attribute:
```html
<input type="file" accept="image/*,audio/*,.mp3,.wav,.ogg">
```

##  Troubleshooting

### Common Issues

**WebSocket Connection Failed**
- Check if port 8080 is available
- Verify CORS settings in WebSocketConfig
- Ensure firewall allows WebSocket connections

**File Upload Fails**
- Check file size (must be under 5MB)
- Verify WebSocket message size limits
- Check browser console for error messages

**Audio Not Playing**
- Ensure browser supports HTML5 audio
- Check audio file format compatibility
- Verify base64 encoding is correct

### Debug Mode
Enable debug logging in `application.properties`:
```properties
logging.level.org.springframework.web.socket=DEBUG
logging.level.org.springframework.messaging=DEBUG
```

##  Performance Considerations

- **File Size**: Large files increase memory usage and transmission time
- **Concurrent Users**: Each connection consumes server resources
- **Message History**: Messages are not persisted; consider adding database storage for production
- **Scaling**: For high-traffic applications, consider using message brokers like RabbitMQ or Redis

##  Security Notes

- **Input Validation**: Always validate file types and sizes
- **XSS Prevention**: Sanitize user input before displaying
- **CORS Configuration**: Restrict allowed origins in production
- **File Uploads**: Consider virus scanning for uploaded files

##  Future Enhancements

- [ ] **User Authentication** - Add login/registration system
- [ ] **Private Messaging** - Direct messages between users
- [ ] **Chat Rooms** - Multiple chat channels
- [ ] **Message History** - Persistent message storage
- [ ] **File Compression** - Automatic image/audio compression
- [ ] **Emoji Support** - Rich text messaging
- [ ] **Push Notifications** - Browser notifications for new messages
- [ ] **Mobile App** - React Native or Flutter mobile client

##  Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

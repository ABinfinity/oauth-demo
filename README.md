# OAuth2 Login Demo — Google & GitHub

This is a simple Spring Boot project demonstrating **OAuth2 login** with **Google** and **GitHub** providers.

✅ Perfect for learning  
✅ Clean and minimal codebase  
✅ Ready to showcase in your resume & GitHub profile 🚀

---

## Features

- 🔒 OAuth2 login with Google and GitHub
- 👤 Fetch and display user profile:
    - Name
    - Email
    - Profile Picture
    - Login Provider (Google/GitHub)
- 🚀 Automatic redirect to profile page after login
- ✅ Easy to extend (add more providers or custom flows)

---

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security
- Thymeleaf (for basic frontend templates)
- Maven

---

## Setup & Run

### 1. Clone the repo

```bash
git clone https://github.com/your-username/oauth2-demo.git
cd oauth2-demo
```

### 2. Configure OAuth apps
👉 Google
- Go to Google Developer Console.

- Create a new OAuth 2.0 Client ID.

- Set Authorized Redirect URI to:

```bash
http://localhost:8080/login/oauth2/code/google
```

👉 GitHub
- Go to GitHub Developer Settings.

- Create a new OAuth App.

- Set Authorization callback URL to:

``` bash
http://localhost:8080/login/oauth2/code/github
```
### 3. Update application.yml
``` yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: YOUR_GOOGLE_CLIENT_ID
            client-secret: YOUR_GOOGLE_CLIENT_SECRET
          github:
            client-id: YOUR_GITHUB_CLIENT_ID
            client-secret: YOUR_GITHUB_CLIENT_SECRET

```

### 4. Run the app
```bash
./mvnw spring-boot:run
Visit: http://localhost:8080
```


## Credit
- Telusko tutorials --> https://www.youtube.com/watch?v=xAaGxhDiGg8

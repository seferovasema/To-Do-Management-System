# To-Do-Management-System
A RESTful Todo Management System built with Spring Boot — featuring full CRUD for users and tasks, status tracking, task assignment, and an interactive browser-based UI.
# 📝 Todo Management System

A RESTful task management API built with **Spring Boot**, supporting full CRUD operations for users and tasks, assignment management, and status tracking.

---

## 🚀 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17+ |
| Framework | Spring Boot |
| ORM | Spring Data JPA |
| Mapping | MapStruct |
| Boilerplate | Lombok |
| Build Tool | Maven |
| Database | PostgreSQL / MySQL |

---

## 📁 Project Structure

```
src/main/java/az/afb/todomanagementsystem/
├── controller/
│   ├── TaskController.java
│   └── UserController.java
├── service/
│   ├── TaskService.java
│   ├── UserService.java
│   └── impl/
│       ├── TaskServiceImpl.java
│       └── UserServiceImpl.java
├── entity/
│   ├── Task.java
│   └── User.java
├── model/
│   ├── dto/
│   │   ├── TaskDto.java
│   │   └── UserDto.java
│   └── view/
│       ├── TaskView.java
│       └── UserView.java
├── mapper/
│   ├── TaskMapper.java
│   └── UserMapper.java
├── repository/
│   ├── TaskRepository.java
│   └── UserRepository.java
└── enums/
    ├── TaskStatus.java
    └── UserRole.java
```

---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- PostgreSQL or MySQL running locally

### Installation

```bash
# 1. Clone the repository
git clone https://github.com/your-username/todo-management-system.git
cd todo-management-system

# 2. Configure database in application.properties
# src/main/resources/application.properties

# 3. Build and run
mvn spring-boot:run
```

### application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tododb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

---

## 📡 API Endpoints

### 👤 Users — `/users`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/users` | Get all users |
| `GET` | `/users/{id}` | Get user by ID |
| `POST` | `/users` | Create new user |
| `PUT` | `/users/{id}` | Update user |
| `DELETE` | `/users?id={id}` | Delete user |

#### UserDto (Request Body)

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "userRole": "USER"
}
```

> `userRole` values: `USER`, `ADMIN`

---

### ✅ Tasks — `/tasks`

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/tasks` | Get all tasks |
| `GET` | `/tasks/{id}` | Get task by ID |
| `POST` | `/tasks` | Create new task |
| `PUT` | `/tasks/{id}` | Update task |
| `DELETE` | `/tasks?id={id}` | Delete task |
| `PUT` | `/tasks/assign/{id}?userId={userId}` | Assign task to user |
| `PUT` | `/tasks/unassign?id={id}` | Unassign task |
| `GET` | `/tasks/user/{userId}` | Get tasks by user |
| `PUT` | `/tasks/status/{id}?status={status}` | Change task status |
| `GET` | `/tasks/status?taskStatus={status}` | Filter tasks by status |

#### TaskDto (Request Body)

```json
{
  "title": "Fix login bug",
  "description": "Users are unable to log in with correct credentials",
  "taskStatus": "TODO"
}
```

> `taskStatus` values: `TODO`, `IN_PROGRESS`, `DONE`

---

## 🔄 Task Status Flow

```
TODO  ──▶  IN_PROGRESS  ──▶  DONE
```

---

## 📬 Example Requests

### Create a User

```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Ali Hasanov","email":"ali@example.com","userRole":"USER"}'
```

### Create a Task

```bash
curl -X POST http://localhost:8080/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Setup CI/CD","description":"Configure GitHub Actions pipeline","taskStatus":"TODO"}'
```

### Assign Task to User

```bash
curl -X PUT "http://localhost:8080/tasks/assign/1?userId=2"
```

### Change Task Status

```bash
curl -X PUT "http://localhost:8080/tasks/status/1?status=IN_PROGRESS"
```

---

## 🖥️ Interactive UI

A browser-based dashboard (`todo-dashboard.html`) is included for testing the API visually — no Postman needed.

**Features:**
- Live user and task lists loaded from the API
- Create / Edit / Delete users and tasks via modals
- Assign tasks to users with a user picker
- Change task status inline
- Filter tasks by status

Simply open the HTML file in a browser and set your API base URL (`http://localhost:8080`).

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

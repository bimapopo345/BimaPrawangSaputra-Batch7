# Simple User & Post REST API

## Setup Database

1. Buat database PostgreSQL:

```sql
CREATE DATABASE uath_db;
```

2. Konfigurasi database ada di `praktik/demo/src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/uath_db
spring.datasource.username=postgres
spring.datasource.password=bima
```

## Cara Menjalankan

1. Import collection Postman dari file `praktik/postman/user-post-api.postman_collection.json`

2. Masuk ke folder project:

```bash
cd praktik/demo
```

2. Jalankan aplikasi:

```bash
./mvnw spring-boot:run
```

## Skema Database

1. Tabel `users`:

   - id (Long, Primary Key)
   - username (String)
   - password (String)

2. Tabel `posts`:
   - id (Long, Primary Key)
   - title (String)
   - content (String)
   - user_id (Foreign Key ke users)

## Flow Autentikasi

1. User melakukan login dengan username & password
2. Server memberikan JWT token
3. Token digunakan sebagai Bearer token di header untuk akses endpoint post

## API Endpoints

### User Management

```bash
# Get all users
curl http://localhost:8080/api/users

# Get user by ID
curl http://localhost:8080/api/users/1

# Create new user
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"username":"john","password":"123456"}'

# Update user
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"username":"john2","password":"123456"}'

# Delete user
curl -X DELETE http://localhost:8080/api/users/1
```

### Authentication

```bash
# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"john","password":"123456"}'
```

### Post Management (Perlu Token)

```bash
# Get user's posts
curl http://localhost:8080/api/me/posts \
  -H "Authorization: Bearer {token}"

# Create post
curl -X POST http://localhost:8080/api/me/posts \
  -H "Authorization: Bearer {token}" \
  -H "Content-Type: application/json" \
  -d '{"title":"Hello","content":"World"}'

# Update post
curl -X PATCH http://localhost:8080/api/me/posts/1 \
  -H "Authorization: Bearer {token}" \
  -H "Content-Type: application/json" \
  -d '{"title":"Updated Title"}'

# Delete post
curl -X DELETE http://localhost:8080/api/me/posts/1 \
  -H "Authorization: Bearer {token}"
```

Note: Ganti `{token}` dengan JWT token yang didapat dari login.

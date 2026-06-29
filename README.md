# inventarioIS

Stock and inventory management CRUD application for Internet Services companies. Built as a learning project — later rebuilt with modern technologies in [InventarioIS IA Rebuild](https://github.com/eze7791/InventarioIS-IA-Rebuild).

## What it does

- **Inventory management** — track materials per agency, add/edit/delete items (quantity 1–1000)
- **Order/request system (Pedidos)** — create requests, track new vs viewed, delete completed ones
- **Notes** — add timestamped comments to any order
- **Photo attachments** — attach images to materials
- **Dashboard** — see counts of new/viewed orders and full material list at a glance
- **Auth** — login/logout with role-based access (ADMIN and USER roles), BCrypt passwords, remember-me

## Stack

| Layer | Technology |
|---|---|
| Language | Java 11 |
| Framework | Spring Boot 2.7.1 |
| View | Thymeleaf (server-side rendering) |
| Security | Spring Security 5 (session-based, BCrypt) |
| Database | MySQL |
| ORM | Spring Data JPA / Hibernate |
| Frontend | Bootstrap 4 + jQuery + DataTables |
| Build | Maven |

## Database schema

Seven tables: `users`, `roles`, `user_roles`, `inventarios`, `materiales`, `pedidos`, `notas`, `fotos`. Schema is auto-managed by Hibernate (`ddl-auto=update`).

## How to run

**Prerequisites:** Java 11, Maven, MySQL running locally.

1. Create a MySQL database named `proyecto`
2. Set credentials in `src/main/resources/application.properties` (default: `root` / no password)
3. Run:

```bash
./mvnw spring-boot:run
```

Open [http://localhost:8080](http://localhost:8080)

A test user is seeded on startup (see `CrearUsuarioPrueba`).

## Limitations (why it was rebuilt)

| Problem | Impact |
|---|---|
| Server-side rendering with Thymeleaf | Tightly couples frontend and backend — hard to build a mobile app or modern UI later |
| Session-based auth | Doesn't scale horizontally; no JWT support |
| `ddl-auto=update` | Dangerous in production — schema changes are uncontrolled |
| Spring Boot 2.7 / Java 11 | End of OSS support; misses virtual threads, modern security API |
| MySQL with no migrations | No audit trail of schema changes |
| No API layer | Can't be consumed by other clients |

## Rebuilt version

➡️ [InventarioIS IA Rebuild](https://github.com/eze7791/InventarioIS-IA-Rebuild) — Spring Boot 3.5 + Java 21 + React 18 + PostgreSQL + JWT + Flyway

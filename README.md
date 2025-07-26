# 📦 VersionControl — Демонстрация 6 подходов к версионированию REST API в Spring Boot

Этот проект показывает, как можно реализовать различные стратегии API-версирования в Spring Boot.

---

## 🔧 Подходы к версионированию

### 1. ✅ Версионирование через `@ApiVersion` + путь `/v1/...`

```java
@ApiVersion("1")
@RestController
@RequestMapping("/api/client")
public class ClientControllerV1 {
    @PostMapping("/new")
    public ResponseEntity<?> createClient(@RequestBody DepositRequestV1 request) { ... }
}
```

📎 Пример запроса:

```bash
curl --location --request POST 'http://localhost:8080/api/v1/client/new' --header 'Content-Type: application/json' --data '{ "amount": 1000 }'
```

---

### 2. 📨 Версионирование через HTTP Header (`X-API-Version`)

```java
@RestController
@RequestMapping("/api/loan")
public class HeaderControlController {
    @PostMapping(value = "/new", headers = "X-API-Version=1")
    public ResponseEntity<?> v1() { ... }
}
```

📎 Пример запроса:

```bash
curl --location --request POST 'http://localhost:8080/api/loan/new' \
--header 'X-API-Version: 1'
```

---

### 3. 🎭 Версионирование через `Content-Type` (media type)

```java
@RestController
@RequestMapping("/api/card")
public class MediaTypeControlController {
    @PostMapping(value = "/new", consumes = "application/vnd.company.v1+json")
    public ResponseEntity<?> v1() { ... }
}
```

📎 Пример запроса:

```bash
curl --location --request POST 'http://localhost:8080/api/card/new' \
--header 'Content-Type: application/vnd.company.v1+json'
```

---

### 4. 🧩 Версионирование через query-параметр

```java
@RestController
@RequestMapping("/api/transaction")
public class ParamsControlController {
    @PostMapping(value = "/new", params = "version=1")
    public ResponseEntity<?> v1() { ... }
}
```

📎 Пример запроса:

```bash
curl --location --request POST 'http://localhost:8080/api/transaction/new?version=1'
```

---

### 5. 📦 Версионирование через тело запроса (поле `version`)

```java
@RestController
@RequestMapping("/api/deposit")
public class BodyControlController {
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody DepositRequest request) { ... }
}
```

DTO-интерфейс:

```java
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "version", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = DepositRequestV1.class, name = "v1"),
  @JsonSubTypes.Type(value = DepositRequestV2.class, name = "v2")
})
public interface DepositRequest {}
```

📎 Пример запроса:

```bash
curl --location --request POST 'http://localhost:8080/api/deposit/new' \
--header 'Content-Type: application/json' \
--data '{
  "version": "v1",
  "amount": 1000
}'
```

---

### 6. 📁 Версионирование через префикс в URL (ручное)

```java
@RestController
@RequestMapping("/api/v1/account")
public class SimpleControlController {
    @PostMapping("/new")
    public ResponseEntity<?> create() { ... }
}
```

📎 Пример запроса:

```bash
curl --location --request POST 'http://localhost:8080/api/v1/account/new'
```

---

## 🧪 DTO-запросы

```java
// V1
public class DepositRequestV1 implements DepositRequest {
    private Long amount;
}

// V2
public class DepositRequestV2 implements DepositRequest {
    private String name;
    private Long amount;
}
```

---

## 🔄 Используемые технологии

- Spring Boot 4 (snapshot)
- Jackson `@JsonTypeInfo` для полиморфной сериализации
- Кастомная аннотация `@ApiVersion`
- `WebMvcConfigurationSupport` и `RequestMappingHandlerMapping`

---

## 🧰 Как запустить

```bash
./gradlew bootRun
```

---

👨‍💻 Автор: Nodir @ Meloman Group

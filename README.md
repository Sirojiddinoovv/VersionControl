# 📦 VersionControl — Демонстрация 6 подходов к версионированию REST API в Spring Boot

Этот проект показывает, как можно реализовать различные стратегии API-версирования в Spring Boot.

---

## 🔧 Подходы к версионированию

### 1. ✅ Версионирование через `@ApiVersion` + путь `/v1/...`

```java
@RestController
@RequestMapping("/api/client")
/**
 *     "error": "Not Found" if version not set
 */
public class CustomAnnotationControlController {


    @PostMapping(value = "/new")
    @ApiVersion("1")
    public ResponseEntity<?> addNewV1() {
        return ResponseEntity.ok("Client v1 added");
    }


    @PostMapping(value = "/new")
    @ApiVersion("2")
    public ResponseEntity<?> addNewV2() {
        return ResponseEntity.ok("Client v2 added");
    }
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


    @PostMapping(
            value = "/new",
            produces = "application/vnd.company.api.v1+json"
    )
    public ResponseEntity<?> addNewCardV1() {
        //todo call service

        return ResponseEntity.ok("Card v1 added");
    }


    @PostMapping(
            value = "/new",
            produces = "application/vnd.company.api.v2+json"
    )
    public ResponseEntity<?> addNewCardV2() {
        //todo call service

        return ResponseEntity.ok("Card v2 added");
    }
}

```

📎 Пример запроса:

```bash
curl --location --request POST 'http://localhost:8080/api/card/new' \
--header 'Accept: application/vnd.company.api.v1+json'
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

### 5. 📦 Версионирование через тело запроса (поле `type`)

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


## 🔄 Используемые технологии

- Spring Boot 3.5.4
- Jackson `@JsonTypeInfo` для полиморфной сериализации
- Кастомная аннотация `@ApiVersion`
- `WebMvcConfigurationSupport` и `RequestMappingHandlerMapping`

---


```Примечание
Хотел добавить поддержку параметра version «из коробки» в Spring Boot 4.0, но так как это пока ещё snapshot-версия, некоторые параметры пока не удалось корректно настроить. Поэтому реализовал собственные подходы к версионированию API.
```

---

👨‍💻 Автор: Nodir @ Meloman Group

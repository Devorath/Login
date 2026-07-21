# Login Android con Kotlin

## Descripción

Esta aplicación es un ejemplo de autenticación básica desarrollada en **Android Studio** utilizando **Kotlin** y **View Binding**.

La aplicación valida un correo electrónico y una contraseña definidos en el código. Si las credenciales son correctas, el usuario es dirigido a una pantalla de bienvenida.

---

## Características

- Interfaz desarrollada con XML.
- Implementación de View Binding.
- Validación de campos vacíos.
- Validación del formato del correo electrónico.
- Habilitación del botón "Login" únicamente cuando ambos campos contienen información.
- Validación de credenciales.
- Mensajes de error utilizando `setError()`.
- Notificación mediante `Toast` cuando las credenciales son incorrectas.
- Navegación entre actividades mediante `Intent`.

---

## Tecnologías utilizadas

- Kotlin
- Android Studio
- View Binding
- Material Components
- Android SDK

---

## Credenciales de prueba

Correo:

```
user@tic.unam.mx
```

Contraseña:

```
d1pl0m0v1l35?
```

---

## Funcionamiento

### 1. Pantalla de inicio

El usuario introduce:

- Correo electrónico
- Contraseña

El botón **Login** permanece deshabilitado hasta que ambos campos contienen texto.

---

### 2. Validaciones

La aplicación realiza las siguientes comprobaciones:

- El correo no puede estar vacío.
- El correo debe tener un formato válido.
- La contraseña no puede estar vacía.
- El correo y la contraseña deben coincidir con las credenciales definidas.

---

### 3. Inicio de sesión exitoso

Si las credenciales son correctas:

- Se crea un `Intent`.
- Se envía el correo mediante `putExtra`.
- Se abre `WelcomeActivity`.
- Se finaliza la actividad de Login.

```kotlin
val intent = Intent(this, WelcomeActivity::class.java)
intent.putExtra("usuario", correo)
startActivity(intent)
finish()
```

---

### 4. Inicio de sesión incorrecto

Si las credenciales son incorrectas:

- Se muestra un mensaje de error en el campo correspondiente.
- Se despliega un `Toast` indicando que el correo o la contraseña son incorrectos.

---

## Estructura del proyecto

```
app/
│
├── java/
│   └── com.example.login/
│       ├── MainActivity.kt
│       └── WelcomeActivity.kt
│
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   └── activity_welcome.xml
│   │
│   ├── values/
│   │   └── strings.xml
│   │
│   └── drawable/
│
└── AndroidManifest.xml
```

---

## Lógica principal

Las credenciales válidas se encuentran definidas como constantes:

```kotlin
private val usuarioCorrecto = "user@tic.unam.mx"
private val passwordCorrecta = "d1pl0m0v1l35?"
```

La autenticación compara los datos ingresados por el usuario con estas credenciales.

---

## Aprendizajes

Durante el desarrollo de esta práctica se implementaron los siguientes conceptos:

- Uso de View Binding.
- Manejo de eventos mediante `OnClickListener`.
- Validación de formularios.
- Uso de expresiones `when`.
- Validación de correos mediante `Patterns.EMAIL_ADDRESS`.
- Navegación entre Activities con `Intent`.
- Uso de `Toast`.
- Envío de información entre actividades mediante `putExtra`.

---

## Autor

**Devorath Barrios**

Proyecto desarrollado como práctica de Android Studio utilizando Kotlin.

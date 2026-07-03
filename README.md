# 🎮 Gravity Ball Kotlin

¡Bienvenido a **Gravity Ball**! Un videojuego móvil casual desarrollado nativamente para Android utilizando **Kotlin**. El juego aprovecha los sensores físicos del dispositivo móvil (Acelerómetro) para controlar el movimiento de una esfera en tiempo real dentro de un entorno dinámico con físicas de rebote, obstáculos y objetivos puntuales.

---

## 🚀 Características Principales

El proyecto se divide en diferentes niveles de complejidad técnica, abordando desde la renderización de gráficos en 2D hasta la gestión física y de hardware del dispositivo.

### 🔹 Menú de Inicio (Pantalla Principal)
*   **Interfaz de Usuario Independiente:** Incorporación de una `MenuActivity` dedicada con diseño moderno mediante XML que actúa como lanzador principal de la app.
*   **Navegación Fluida:** Transición optimizada entre el menú principal y la zona de juego mediante `Intents` nativos de Android.

### 🔹 Nivel Básico (Personalización y Datos en Tiempo Real)
*   **Estilización Visual:** Se modificó la paleta de colores nativa de la bolita a un tono *Azul Eléctrico* de alta visibilidad, conservando capas de brillo 2D (`Canvas.drawCircle`).
*   **Ajuste de Escala:** El radio predeterminado de la esfera fue incrementado a `60f` para mejorar la jugabilidad y la precisión de colisiones.
*   **UI Dinámica e Instrucciones:** Inclusión de un banner superior con texto informativo persistente usando la clase `Paint`.
*   **Telemetría de Posición:** Mapeo y renderizado en tiempo real de las coordenadas exactas $(X, Y)$ de la bolita en pantalla.

### 🔹 Nivel Intermedio (Mecánicas de Juego y Físicas)
*   **Generación de Obstáculos:** Expansión del mapa mediante la adición de múltiples geometrías colisionables (`Obstacles` en forma de cajas y barras) distribuidas estratégicamente a través de `RectF`.
*   **Sistema de Reglas y Puntaje:**
    *   **Bonificación:** Recolectar el objetivo verde (`Target`) otorga un incremento de $+15$ puntos y reubica el objetivo aleatoriamente.
    *   **Penalización:** Impactar contra un obstáculo rojo resta una vida, reinicia la posición de la bola, ejecuta un patrón de vibración prolongado y descuenta $-5$ puntos del marcador general.
*   **Físicas de Contención (Choque con Bordes):** Implementación de algoritmos de detección matemática en los bordes de la pantalla. La bola detecta dinámicamente los límites del viewport (evitando sobrepasar el header del juego) y se mantiene contenida en el área jugable.

---

## 🛠️ Tecnologías y Herramientas Utilizadas

*   **Lenguaje de Programación:** Kotlin 1.9+
*   **Entorno de Desarrollo:** Android Studio (Jellyfish / Koala o superior)
*   **Framework de Gráficos:** Android Graphics (`Canvas`, `Paint`, `RectF`)
*   **Hardware Integration:** `SensorManager` & `Sensor.TYPE_ACCELEROMETER`
*   **Feedback Háptico:** `Vibrator` / `VibrationEffect` (Soporte retrocompatible)

---

## 📂 Estructura del Código Fuente

El núcleo del videojuego está estructurado de forma modular bajo el paquete `com.epn.gravitygame`:

*   **`MenuActivity.kt`**: Gestiona la pantalla de bienvenida y el disparo del hilo del juego.
*   **`MainActivity.kt`**: Controla el ciclo de vida de los sensores del hardware (Register/Unregister del acelerómetro).
*   **`GameView.kt`**: El motor del juego. Administra el bucle de renderizado, lógica de puntuación, dibujo de fondos matriciales y ciclos de actualización de los componentes.
*   **`Ball.kt`**: Modelo matemático y gráfico de la esfera (gestiona velocidad, radio, color y restricciones perimetrales).
*   **`Collision.kt`**: Objeto utilitario encargado de procesar intersecciones matemáticas complejas (*Círculo vs Círculo* y *Círculo vs Rectángulo*).
*   **`Target.kt` & `Obstacle.kt`**: Entidades del juego con lógica de dibujo y reubicación pseudoaleatoria (`Random`).

---


## 🔧 Instalación y Ejecución

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/WilmerRamos21/Kotlin-Juego.git
   ```

2. Abre el proyecto en Android Studio.

3. Deja que Gradle sincronice las dependencias del sistema.

4. Conecta un dispositivo físico Android (recomendado para probar el sensor de movimiento) o inicia un emulador con los sensores virtuales activos.

5. Presiona el botón Run (Shift + F10).

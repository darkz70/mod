# Night Vision Toggle (Fabric 1.21.1)

Мини-мод для Fabric: нажимай `G`, чтобы включать и выключать ночное зрение.

## Что внутри

- Minecraft **1.21.1**
- Fabric
- Клавиша по умолчанию: **G**
- Работает как **client-side** мод

## Как собрать проект

1. Поставь **Java 21**.
2. Открой проект в IntelliJ IDEA или VS Code как **Gradle project**.
3. Подожди, пока Gradle скачает зависимости.
4. Запусти:
   ```bash
   ./gradlew runClient
   ```
5. Для сборки jar:
   ```bash
   ./gradlew build
   ```

Готовый jar появится в папке:

```text
build/libs/
```

## Как поменять клавишу

Открой файл:

```text
src/main/java/com/darkz/nightvision/NightVisionClient.java
```

Найди строку:

```java
GLFW.GLFW_KEY_G
```

Замени `G` на другую клавишу из списка GLFW.

## Как переименовать мод

Если хочешь другое название, поменяй эти файлы:

- `src/main/resources/fabric.mod.json`
- `src/main/resources/assets/nightvisiontoggle/lang/en_us.json`
- `gradle.properties`

Если меняешь `id`, то папку `assets/nightvisiontoggle/` тоже нужно переименовать под новый `id`.

## Что делает код

- Нажатие `G` переключает флаг `enabled`
- Пока мод включён, игроку каждый тик выдаётся Night Vision
- Когда мод выключается, эффект снимается

## Если Gradle ругается на версии

Открой Fabric Template Generator и проверь рекомендуемые версии для **Minecraft 1.21.1**, затем обнови:

- `minecraft_version`
- `yarn_mappings`
- `loader_version`
- `fabric_version`

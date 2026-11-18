# 🗣️ Languages App (JavaFX + FXML)

A desktop app built with **JavaFX** and **FXML** for language learners: a vocabulary list on one side and a practice chat on the other. It's the desktop version of the *Prata* language-learning project.

## 📁 Project Structure

```
LanguagesApp/
├── pom.xml                                   → Maven build (JavaFX dependencies + javafx-maven-plugin)
└── src/main/
    ├── java/
    │   ├── module-info.java                  → Java module declaration
    │   └── com/mycompany/languagesapp/
    │       ├── MainApp.java                  → Application entry point, loads the FXML scene
    │       └── MainController.java           → Handles button actions
    └── resources/com/mycompany/languagesapp/
        └── main-view.fxml                    → UI layout (SplitPane with two panels)
```

## 🚀 How It Works

The window is a `SplitPane` with two halves:

| Left panel — Vocabulary | Right panel — Conversation |
|---|---|
| `TextField` to type a word | Read-only `TextArea` with the chat |
| **Add New Word** button | `TextField` + **SEND** button |
| `ListView` with saved words | Messages appear as `You: ...` |

### Layout in FXML, logic in the controller

The view is declared in `main-view.fxml` and linked to its controller with `fx:controller`. Each control gets an `fx:id` and each button an `onAction`:

```xml
<TextField fx:id="textWord" promptText="Type your new word"/>
<Button onAction="#onAddWord">Add New Word</Button>
```

Those names match the fields and methods annotated with `@FXML` in `MainController`:

```java
@FXML private TextField textWord;
@FXML private ListView<String> wordList;

@FXML
protected void onAddWord() {
    wordList.getItems().add(textWord.getText());
}
```

### Loading the scene

`MainApp` extends `Application`, loads the FXML with `FXMLLoader` and shows it in a 320×240 `Stage`.

## 🧠 Key Concepts

- **JavaFX `Application` lifecycle** — `launch()` → `start(Stage)`
- **FXML** — separating the UI (XML) from the logic (Java)
- **`@FXML` injection** — binding `fx:id` controls to controller fields
- **Event handlers** — `onAction="#method"`
- **Layouts** — `SplitPane`, `VBox`, `HBox` with `vgrow` / `hgrow`
- **Maven + Java modules** — `module-info.java`

## 🛠️ How To Run

Requires JDK 17+. From the project folder:

```bash
cd LanguagesApp
./mvnw clean javafx:run
```

Or open `LanguagesApp` in NetBeans / IntelliJ as a Maven project and run `MainApp`.

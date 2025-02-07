import java.util.Objects;

import chaewon.Chaewon;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogueContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Chaewon chaewon;
    private Image userImage = new Image(Objects.requireNonNull(
            this.getClass().getResourceAsStream("/images/joyuri.png")));
    private Image chaewonImage = new Image(Objects.requireNonNull(
            this.getClass().getResourceAsStream("/images/chaechae.png")));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogueContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setChaewon(Chaewon chaewon) {
        this.chaewon = chaewon;
    }

    /**
     * Creates two dialogue boxes, one echoing user input and the
     * other containing Chaewon's reply and then appends them to the
     * dialogue container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        assert input != null && !input.isEmpty() : "Input should not be empty";
        dialogueContainer.getChildren().add(
                DialogueBox.getUserDialogue(input, userImage)
        );
        userInput.clear();
        PauseTransition delay = new PauseTransition(Duration.seconds(0.8));
        delay.setOnFinished(event -> {
            String response = chaewon.getResponse(input);
            dialogueContainer.getChildren().add(
                    DialogueBox.getDukeDialogue(response, chaewonImage)
            );
            if (chaewon.isExit()) {
                PauseTransition exitDelay = new PauseTransition(Duration.seconds(3));
                exitDelay.setOnFinished(e -> {
                    Stage stage = (Stage) dialogueContainer.getScene().getWindow();
                    stage.close();
                });
                exitDelay.play();
            }
        });
        delay.play();
    }
}

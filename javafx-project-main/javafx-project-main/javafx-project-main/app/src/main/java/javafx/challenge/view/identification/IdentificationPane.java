
package javafx.challenge.view.identification;

import javafx.challenge.view.components.MyLabel;
import javafx.challenge.view.components.MyTextField;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class IdentificationPane extends GridPane {

    private final TextField firstNameField = new MyTextField();
    private final TextField end_corresField = new MyTextField();
    private final TextField emailField = new MyTextField();
    private final TextField rgField = new MyTextField();
    private final TextField cpfField = new MyTextField();
    private final TextField bairroField = new MyTextField();
    private final TextField cidadeField = new MyTextField();
    private final TextField cepField = new MyTextField();
    private final TextField telefoneResidencialField = new MyTextField();
    private final TextField celularField = new MyTextField();

    private final VBox messageBox = new VBox(); // VBox para exibir a mensagem
    private final ToggleGroup optionGroup = new ToggleGroup();
    private final RadioButton locatarioRadioButton = new RadioButton("Locatário");
    private final RadioButton proprietarioRadioButton = new RadioButton("Proprietário");
    
    public IdentificationPane() {
        buildGUI();
        setRadioButtons();
    }

    private void buildGUI() {
        add(createForm(), 0, 0);
    }

    private Node createForm() {
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(120, 50, 30, 35));

        int row = 0;

        formGrid.add(new MyLabel("First Name:"), 0, row);
        formGrid.add(firstNameField, 1, row);

        formGrid.add(new MyLabel("End.Correspondencia name:"), 0, ++row);
        formGrid.add(end_corresField, 1, row);

        formGrid.add(new MyLabel("Email:"), 0, ++row);
        formGrid.add(emailField, 1, row);

        formGrid.add(new MyLabel("RG:"), 0, ++row);
        formGrid.add(rgField, 1, row);
    
        formGrid.add(new MyLabel("CPF:"), 2, row);
        formGrid.add(cpfField, 3, row);

        formGrid.add(new MyLabel("Bairro:"), 0, ++row);
        formGrid.add(bairroField, 1, row);
    
        formGrid.add(new MyLabel("Cidade:"), 2, row);
        formGrid.add(cidadeField, 3, row);
    
        formGrid.add(new MyLabel("CEP:"), 4, row);
        formGrid.add(cepField, 5, row);

        formGrid.add(new MyLabel("Telefone Residencial:"), 0, ++row);
        formGrid.add(telefoneResidencialField, 1, row);
    
        formGrid.add(new MyLabel("Celular:"), 2, row);
        formGrid.add(celularField, 3, row);

        formGrid.add(new MyLabel("Option:"), 0, ++row);
        formGrid.add(locatarioRadioButton, 1, row);
        formGrid.add(proprietarioRadioButton, 2, row);

        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(10);

        Button cadastrarButton = new Button("Cadastrar");
        cadastrarButton.setOnAction(event -> cadastrar());
        buttonsBox.getChildren().add(cadastrarButton);

        Button cancelarButton = new Button("Cancelar");
        cancelarButton.setOnAction(event -> limparCampos());
        buttonsBox.getChildren().add(cancelarButton);

        formGrid.add(buttonsBox, 1, row + 1);

        messageBox.setSpacing(10);

        TitledPane titledPane = new TitledPane("Personal Info", formGrid);
        titledPane.setCollapsible(false);

        VBox containerBox = new VBox();
        containerBox.getChildren().addAll(titledPane, messageBox); // Adiciona o VBox da mensagem

        return containerBox;
    }

    private void setRadioButtons() {
        locatarioRadioButton.setToggleGroup(optionGroup);
        proprietarioRadioButton.setToggleGroup(optionGroup);
    }

    private void cadastrar() {
        String firstName = firstNameField.getText();
        String end_corres = end_corresField.getText();
        String email = emailField.getText();
        String rg = rgField.getText();
        String cpf = cpfField.getText();
        String bairro = bairroField.getText();
        String cidade = cidadeField.getText();
        String cep = cepField.getText();
        String telefone = telefoneResidencialField.getText();
        String celular = celularField.getText();


        

        String selectedOption = "";
        RadioButton selectedRadioButton = (RadioButton) optionGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            selectedOption = selectedRadioButton.getText();
        }

        // Exibe a mensagem "Cadastrado com sucesso!" e a opção selecionada
        MyLabel successLabel = new MyLabel("Cadastrado com sucesso!\nOpção selecionada: " + selectedOption);
        messageBox.getChildren().add(successLabel);

        // Exibe as informações cadastradas
        MyLabel firstNameLabel = new MyLabel("First Name: " + firstName);
        MyLabel end_corresLabel = new MyLabel("Last Name: " + end_corres);
        MyLabel emailLabel = new MyLabel("Email: " + email);
        MyLabel rgField = new MyLabel("RG: " + rg);
        MyLabel cpfField = new MyLabel("CPF: " + cpf);
        MyLabel bairroField = new MyLabel("Bairro: " + bairro);
        MyLabel  cidadeField = new MyLabel("Cidade: " + cidade);
        MyLabel  cepField = new MyLabel("CEP: " + cep);
        MyLabel  telefoneResidencialField = new MyLabel("Telefone: " + telefone);
        MyLabel  celularField = new MyLabel("Celular: " + celular);
        messageBox.getChildren().addAll(firstNameLabel, end_corresLabel, emailLabel, rgField, cpfField, bairroField,  cidadeField, cepField, telefoneResidencialField, celularField );
    }

    private void limparCampos() {
        firstNameField.clear();
        end_corresField.clear();
        emailField.clear();
        rgField.clear();
        cpfField.clear();
        bairroField.clear();
        cidadeField.clear();
        cepField.clear();
        telefoneResidencialField.clear();
        celularField.clear();



        // Limpa a mensagem
        messageBox.getChildren().clear();
    }
}

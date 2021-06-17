package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class loadController implements Initializable {

    @FXML
    public Button mainmenu;
    public AnchorPane anchorRootLoad;
    public StackPane parentContainerLoad;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void LoadSlot1() {
        SaveState savefile;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("SaveSlot1.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            savefile = (SaveState) in.readObject();


            in.close();
            file.close();

            FileOutputStream fileo = new FileOutputStream("file.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileo);

            // Method for serialization of object
            out.writeObject(savefile);

            out.close();
            fileo.close();

            System.out.println("Object has been deserialized ");
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    public void LoadSlot2() {
        SaveState savefile;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("SaveSlot2.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            savefile = (SaveState) in.readObject();


            in.close();
            file.close();

            FileOutputStream fileo = new FileOutputStream("file.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileo);

            // Method for serialization of object
            out.writeObject(savefile);

            out.close();
            fileo.close();

            System.out.println("Object has been deserialized ");
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    public void LoadSlot3() {
        SaveState savefile;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("SaveSlot3.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            savefile = (SaveState) in.readObject();


            in.close();
            file.close();

            FileOutputStream fileo = new FileOutputStream("file.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileo);

            // Method for serialization of object
            out.writeObject(savefile);

            out.close();
            fileo.close();

            System.out.println("Object has been deserialized ");
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    public void SaveSlot1() {
        SaveState savefile = null;
        try {
            FileInputStream file = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            savefile = (SaveState) in.readObject();

            in.close();
            file.close();

            FileOutputStream fileo = new FileOutputStream("SaveSlot1.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileo);

            // Method for serialization of object
            out.writeObject(savefile);

            out.close();
            fileo.close();

            System.out.println("Object has been serialized");
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public void SaveSlot2() {
        SaveState savefile = null;
        try {
            FileInputStream file = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            savefile = (SaveState) in.readObject();

            in.close();
            file.close();

            FileOutputStream fileo = new FileOutputStream("SaveSlot2.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileo);

            // Method for serialization of object
            out.writeObject(savefile);

            out.close();
            fileo.close();

            System.out.println("Object has been serialized");
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println("IOException is caught");
        }
    }

    public void SaveSlot3() {
        SaveState savefile = null;
        try {
            FileInputStream file = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            savefile = (SaveState) in.readObject();

            in.close();
            file.close();

            FileOutputStream fileo = new FileOutputStream("SaveSlot3.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileo);

            // Method for serialization of object
            out.writeObject(savefile);

            out.close();
            fileo.close();

            System.out.println("Object has been serialized");
        }
        catch(IOException | ClassNotFoundException ex)
        {
            System.out.println("IOException is caught");
        }
    }


    public void returnMenu(ActionEvent actionEvent) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("/sample/mainmenu.fxml"));
        Scene menuScene = anchorRootLoad.getScene();

        menuParent.translateYProperty().set(menuScene.getHeight());

        parentContainerLoad.getChildren().add(menuParent);

        Timeline timeline = new Timeline();

        KeyValue kv = new KeyValue(menuParent.translateYProperty(),0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1),kv);
        timeline.getKeyFrames().add(kf);

        timeline.setOnFinished(t -> {
            parentContainerLoad.getChildren().remove(anchorRootLoad);
        });
        timeline.play();
    }

    public void loadMenu(ActionEvent actionLoad) throws IOException {
        Parent settingParent = FXMLLoader.load(getClass().getResource("/sample/loadscreen.fxml"));
        Scene settingScene = new Scene(settingParent);

        Stage window = (Stage)((Node)actionLoad.getSource()).getScene().getWindow();

        window.setScene(settingScene);
        window.show();
    }


}

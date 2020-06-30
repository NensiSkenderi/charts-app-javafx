package main;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class demo extends Application {

   @Override
   public void start(Stage primaryStage) throws Exception {

       PieChart pieChart = new PieChart();

       PieChart.Data slice1 = new PieChart.Data("USA", 17947195);
       PieChart.Data slice2 = new PieChart.Data("EU", 11540278);
       PieChart.Data slice3 = new PieChart.Data("China", 10982829);
       PieChart.Data slice4 = new PieChart.Data("Japan", 4116242);
       PieChart.Data slice5 = new PieChart.Data("Others", 28584442);

       pieChart.getData().add(slice1);
       pieChart.getData().add(slice2);
       pieChart.getData().add(slice3);
       pieChart.getData().add(slice4);
       pieChart.getData().add(slice5);
       
       pieChart.setPrefSize(400, 300);

       pieChart.setLegendSide(Side.LEFT);
       pieChart.setStartAngle(30);

       final Label caption = new Label("");
       caption.setTextFill(Color.WHITE);
       caption.setStyle("-fx-font: 12 arial;");

       for (final PieChart.Data data : pieChart.getData()) {
           data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
               @Override
               public void handle(MouseEvent e) {
                   caption.setTranslateX(e.getSceneX());
                   caption.setTranslateY(e.getSceneY());

                   caption.setText(String.valueOf(data.getPieValue()));
               }
           });
       }

       primaryStage.setTitle("JavaFX PieChart (o7planning.org)");
       AnchorPane root = new AnchorPane();
       root.getChildren().addAll(pieChart, caption);
       
       

       Scene scene = new Scene(root, 400, 300);

       primaryStage.setScene(scene);

       primaryStage.show();
   }

   public static void main(String[] args) {
       Application.launch(args);
   }
}
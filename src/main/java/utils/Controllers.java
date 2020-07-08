package utils;

import controller.activityTrailController;
import controller.datasetController;
import controller.editProfileController;
import controller.barChartController;
import javafx.scene.layout.VBox;

public class Controllers {

	private static activityTrailController activityTrailController;
	private static datasetController datasetController;
	private static barChartController barChartController;
	private static editProfileController editProfileController;
	
	public static void getActivityTrailController(VBox box) {
		activityTrailController = activityTrailController == null ? new activityTrailController() : activityTrailController;
		config(box, activityTrailController);
	}
	
	public static void getDataset(VBox box) {
		datasetController = datasetController == null ? new datasetController() : datasetController;
		config(box, datasetController);
	}
	
	public static void getBarChart(VBox box) {
		barChartController = barChartController == null ? new barChartController() : barChartController;
		config(box, barChartController);
	}
	
	public static void getEditProfile(VBox box) {
		editProfileController = editProfileController == null ? new editProfileController() : editProfileController;
		config(box, editProfileController);
	}
	
	//when we click on a button, we load the controller that we define, and also the view we want
	public static void config(VBox box, VBox content) {
		box.getChildren().clear();
		box.getChildren().add(content);
	}

}

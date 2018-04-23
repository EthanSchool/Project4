package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	private TableView<TempName> table;

	@FXML
	private TableColumn<TempName, String> column1;
	@FXML
	private TableColumn<TempName, String> column2;
	@FXML
	private TableColumn<TempName, String> column3;
	@FXML
	private TableColumn<TempName, String> column4;

	/**
	 * Initialization function for Controller
	 *
	 * Loads the ExampleTable.txt Resource file splitting it on the 1st new line
	 * with the first part being the header and 2nd being data.
	 * The header is further split by tabs to become each column name.
	 * And the data part being further split by each new line representing
	 * each new row and then further split again by tabs representing the item
	 * in each column. With each item also being trimmed to cutoff the excess whitespace.
	 *
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String s = null;
		try {
			s = new String(Files.readAllBytes(Paths.get(getClass().getResource("/ExampleTable.txt").getFile())));// Loads in the string from the ExampleTable.txt Resource file
		} catch(IOException e) {
			e.printStackTrace();
		}

		String[] p = s.split("\n", 2);// Splits off the header line (1st line) from the rest of the data
		//Labels are currently set in the fxml file
		String[] labels = p[0].split("\t");// Splits header into the label for each column

		column1.setCellValueFactory((qq) -> qq.getValue().Type);
		column2.setCellValueFactory((qq) -> qq.getValue().chg);
		column3.setCellValueFactory((qq) -> qq.getValue().ytd);
		column4.setCellValueFactory((qq) -> qq.getValue().cars);

		String[] data = p[1].split("\n");// Splits data into each row

		List<TempName> tempName = new ArrayList<>();

		//Cars	555,625 	-9.2	1,374,507	-10.8 // Separated by tabs for each row
		for(String d : data) {// Iterates over each row
			String[] i = d.split("\t");// Splits the row into each item
			tempName.add(new TempName(i[0].trim(), i[1].trim(), i[2].trim(), i[3].trim()));// Takes all of the items trims excess whitespace and creates the storage object for it
		}

		table.getItems().setAll(FXCollections.observableList(tempName));// Add data to table
	}
}

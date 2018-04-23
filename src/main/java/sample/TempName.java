package sample;

import javafx.beans.property.SimpleStringProperty;

public class TempName {
	public SimpleStringProperty Type;
	public SimpleStringProperty chg;
	public SimpleStringProperty ytd;
	public SimpleStringProperty cars;

	/**
	 * Creates class for storing a row of the table
	 *
	 * @param type
	 * @param chg
	 * @param ytd
	 * @param cars
	 */
	public TempName(String type, String chg, String ytd, String cars) {
		this.Type = new SimpleStringProperty(type);
		this.chg = new SimpleStringProperty(chg);
		this.ytd = new SimpleStringProperty(ytd);
		this.cars = new SimpleStringProperty(cars);
	}
}
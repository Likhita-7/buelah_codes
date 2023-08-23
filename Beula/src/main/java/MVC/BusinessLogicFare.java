package MVC;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogicFare {
	// TrainDAL td= new TrainDAL();
	
	public List<Double> bbl(double classfare, double distfare, ArrayList<Passengers> pass) {

		List<Double> fareList = new ArrayList<>();
		for (Passengers y : pass) {
			double TotalFare = distfare * classfare;
			if (y.getage() > 0 && y.getage() < 6) {
				TotalFare = 0;
			} else if (y.getage() > 5 && y.getage() < 13) {
				TotalFare = TotalFare / 2;
			} else if (y.getage() >= 65 && y.getGender().equals("Male")) {
				TotalFare = TotalFare - (TotalFare / 4);
			} else if (y.getage() >= 58 && y.getGender().equals("Female")) {
				TotalFare = TotalFare - (TotalFare / 4);
			}
			fareList.add(TotalFare);

		}

		return fareList;

	}

	public double bblFinal(double classfare, double distfare, ArrayList<Passengers> pass) {
		double TotalFare = distfare * classfare;	

		for (Passengers y : pass) {

			if (y.getage() > 0 && y.getage() < 6) {
				TotalFare += 0;
			} else if (y.getage() > 5 && y.getage() < 13) {
				TotalFare += TotalFare / 2;
			} else if (y.getage() >= 65 && y.getGender().equals("Male")) {
				TotalFare += TotalFare - (TotalFare / 4);
			} else if (y.getage() >= 58 && y.getGender().equals("Female")) {
				TotalFare += TotalFare - (TotalFare / 4);
			}

		}

		return TotalFare;

	}
}
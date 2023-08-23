package MVC;

import java.util.ArrayList;

public class TrainsModel {
	String TrainName;
	int Trainno;

	String from;
	String to;
	ArrayList<String> tn = new ArrayList();
	ArrayList<String> tr = new ArrayList();

	TrainsModel() {

	}

	public String getTrainName() {
		String s = " ";
		for (int i = 0; i < tn.size(); i++) {
			s = s + tn.get(i) + ",";
		}
		return s;

	}

	public void setTrainName(String Trn) {
		tn.add(Trn);
	}

	public String getTrainno() {
		String s = " ";
		for (int i = 0; i < tr.size(); i++) {
			s = s + tr.get(i) + ",";
		}
		return s;
	}

	public void setTrainno(String trno) {
		tr.add(trno);
	}

	public String getfrom() {
		return from;
	}

	public void setfrom(String from) {
		this.from = from;
	}

	public String getto() {
		return to;
	}

	public void setto(String to) {
		this.to = to;
	}
}



package MVC;

import java.util.ArrayList;

public class ClassModel {
	String TrainName;
	int Trainno;

	String from;
	String to;
	ArrayList<String> tnc = new ArrayList();

	ClassModel() {

	}

	public String getTrainName() {
		return TrainName;

	}

	public void setTrainName(String Trn) {
		this.TrainName = Trn;
	}

	public int getTrainno() {
		return Trainno;
	}

	public void setTrainno(int trno) {
		this.Trainno = trno;
	}

	public String getcls() {
		String s = " ";
		for (int i = 0; i < tnc.size(); i++) {
			s = s + tnc.get(i) + ",";
		}
		return s;
	}

	public void setcls(String cls) {
		tnc.add(cls);
	}

}
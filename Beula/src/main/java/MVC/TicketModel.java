package MVC;
import java.util.ArrayList;

public class TicketModel {
	String TrainName;
	int Trainno;
	String cls;
	String from;
	String to;
	ArrayList<Passengers> pass;

	TicketModel(String Trn, int trno, String cls, String from, String to, ArrayList<Passengers> pass) {
		this.TrainName = Trn;
		this.Trainno = trno;
		this.cls = cls;
		this.from = from;
		this.to = to;

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
		return cls;
	}

	public void setcls(String cls) {
		this.cls = cls;
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
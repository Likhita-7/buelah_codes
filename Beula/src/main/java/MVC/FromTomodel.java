package MVC;

import java.util.ArrayList;

public class FromTomodel {

	String from;
	String to;
	ArrayList<String> al = new ArrayList();

	FromTomodel() {

	}

	public String getfrom() {
		String s = " ";
		for (int i = 0; i < al.size(); i++) {
			s = s + al.get(i) + ",";
		}
		return s;
	}

	public void setfrom(String from) {
		al.add(from);
	}

}


package view;

public class InputPrescriptionChoice extends InputIntChoice{
	public InputPrescriptionChoice(int no) {
		super(no);
	}
	public int getPrescription() {
		return getIntChoice();
	}
}

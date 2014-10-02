import java.time.LocalDate;


public class TrainigEvent {

	private static TrainigEvent trainigEvent = null;
	LocalDate localDate;
	private String state;
	
	private TrainigEvent() {
		trainigEvent = new TrainigEvent();
	}
	
	public TrainigEvent(String string) {
	}

	public static TrainigEvent called(String string) {
		if(trainigEvent == null){
			return new TrainigEvent(string);
		}
		return trainigEvent;
	}

	public void scheduleFor(LocalDate curseDate) {
		localDate = curseDate;
	}

	public LocalDate getErlybirdDateLimit() {
		return localDate.minusMonths(1);
	}

	public void in(String string) {
		this.state = string;
		
	}

	public String getState() {
		// TODO Auto-generated method stub
		return this.state;
	}

}

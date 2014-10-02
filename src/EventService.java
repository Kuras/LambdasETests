import java.util.LinkedList;
import java.util.List;


public class EventService {

	private List<TrainigEvent> trainingEvents;
	
	public EventService() {
		trainingEvents = new LinkedList<TrainigEvent>();
	}

	public void register(TrainigEvent trainingEvent) {
		this.trainingEvents.add(trainingEvent);
	}

	public List<TrainigEvent> findEventsIn(String string) {
		List<TrainigEvent> list = new LinkedList<TrainigEvent>();
		for (TrainigEvent trainingEvent : trainingEvents) {
			if (trainingEvent.getState().equals(string)){
				
				list.add(trainingEvent);
			}
		}
		return list; 
	}

}

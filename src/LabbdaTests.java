import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;


public class LabbdaTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		LocalDate curseDate = LocalDate.of(2014, Month.JANUARY, 31);
		
		TrainigEvent trainingEvent = TrainigEvent.called("Bdd In action");
		trainingEvent.scheduleFor(curseDate);
		
		LocalDate erlyBirdTicketsEnd = curseDate.minusMonths(1);
		assertThat(trainingEvent.getErlybirdDateLimit(), is(equalTo(erlyBirdTicketsEnd)));
		
		assertThat(0, is(not(1)));
		
		System.out.println(curseDate);
	}
	
	@Test
	public void test1() {
		
		EventService eventService =new EventService();
		TrainigEvent trainingEvent = TrainigEvent.called("Bdd In action");
		trainingEvent.in("Melbourne");
		trainingEvent.scheduleFor(LocalDate.of(2014, Month.MAY, 21));
		eventService.register(trainingEvent);
		
		TrainigEvent trainingEvent1 = TrainigEvent.called("Bdd In action");
		trainingEvent1.in("Sydney");
		trainingEvent1.scheduleFor(LocalDate.of(2014, Month.MAY, 6));
		eventService.register(trainingEvent1);
		
		List<TrainigEvent> trainigEvents = eventService.findEventsIn("Melbourne");
		
		for (TrainigEvent event : trainigEvents) {
			// Conventional for loop
			assertThat(event.getState(), is("Melbourne"));
			
			System.out.println(event.getState());
		}
		
	}
	
	@Test
	public void test2() {
		
		EventService eventService =new EventService();
		TrainigEvent trainingEvent = TrainigEvent.called("Bdd In action");
		trainingEvent.in("Melbourne");
		trainingEvent.scheduleFor(LocalDate.of(2014, Month.MAY, 21));
		eventService.register(trainingEvent);
		
		TrainigEvent trainingEvent1 = TrainigEvent.called("Bdd In action");
		trainingEvent1.in("Sydney");
		trainingEvent1.scheduleFor(LocalDate.of(2014, Month.MAY, 6));
		eventService.register(trainingEvent1);
		
		List<TrainigEvent> trainigEvents = eventService.findEventsIn("Melbourne");
		
		//USES lambdas for more expresive expectation
		trainigEvents.forEach( (TrainigEvent event) -> {
			
			assertThat(event.getState(), is("Melbourne"));
			System.out.println(event.getState());
		}
		);
		
		for (TrainigEvent event : trainigEvents) {
			// Conventional for loop
			assertThat(event.getState(), is("Melbourne"));
			
			System.out.println(event.getState());
		}
		
	}

	
	@Test
	public void test3() {
		
		EventService eventService =new EventService();
		
		TrainigEvent trainingEvent = TrainigEvent.called("Bdd In action");
		trainingEvent.in("Melbourne");
		trainingEvent.scheduleFor(LocalDate.of(2014, Month.MAY, 21));
		eventService.register(trainingEvent);
		
		TrainigEvent trainingEvent1 = TrainigEvent.called("Bdd In action");
		trainingEvent1.in("Sydney");
		trainingEvent1.scheduleFor(LocalDate.of(2014, Month.MAY, 6));
		eventService.register(trainingEvent1);
		
		List<TrainigEvent> trainigEvents = eventService.findEventsIn("Melbourne");
		
		Predicate<TrainigEvent> inMelbourne = event -> event.getState().equals("Melbourne");
		// using predicate
		assertThat(trainigEvents.stream().allMatch(inMelbourne), is(true));
		
	}
	
}

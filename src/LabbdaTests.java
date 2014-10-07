import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
		assertThat(1, is(1));
		
	}
	
	@Test
	public void test4() {
		
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
		
//		inMelbourne1 = (TrainigEvent event) -> event.getState().equals("Melbourne");
		
		Predicate<TrainigEvent> inMelbourne = (TrainigEvent event) -> event.getState().equals("Melbourne");
		
		Predicate<TrainigEvent> inMelbourne2 = (TrainigEvent event) -> {
				return event.getState().equals("Melbourne");
			};
		Predicate<? super TrainigEvent> predicate = inMelbourne2;
		// using predicate
		assertThat(trainigEvents.stream().allMatch( predicate  ), is(true) );
		
		
	}
	
	@Test
	public void test5() {
		
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
		
		List<String> trainigStates = trainigEvents.stream().map((TrainigEvent event) -> event.getState())
														   .distinct()
														   .collect(Collectors.toList());
		
		trainigStates.forEach(state -> {
			assertThat(state, containsString("Melbourne"));
		});
		
		Predicate<String> predicate = (String state) -> state.equals("Melbourne");
		assertThat(trainigStates.stream().allMatch( predicate   ), is(true) );
	}
	
	@Test
	public void test6() {
		
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
		
		Set<String> trainigStates =  trainigEvents.stream().map((TrainigEvent event) -> event.getState())
														   .collect(Collectors.toSet());
		
		trainigStates.forEach(state -> {
			assertThat(state, containsString("Melbourne"));
		});
		
		Predicate<String> predicate = (String state) -> state.equals("Melbourne");
		assertThat(trainigStates.stream().allMatch( predicate   ), is(true) );
	}
}

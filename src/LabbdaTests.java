import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;


public class LabbdaTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		LocalDate curseDate = LocalDate.of(2014, Month.JANUARY, 31);
		
		TrainigEvent trainingEvent = TrainigEvent.called("Bdd In action").scheduleFor(curseDate);
		
		LocalDate erlyBirdTicketsEnd = curseDate.minusMonths(1);
		assertThat(trainingEvent.getErlybirdDateLimit(), is(equals(erlyBirdTicketsEnd)));
		System.out.println(curseDate);
	}

}
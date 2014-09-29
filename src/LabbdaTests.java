import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;


public class LabbdaTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		LocalDate curseDate = LocalDate.of(2014, Month.JANUARY, 31);
		
		System.out.println(curseDate);
	}

}

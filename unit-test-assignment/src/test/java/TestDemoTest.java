import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class TestDemoTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		
		testDemo = new TestDemo();
		
	}
	
//	Stream of arguments for the test: What integers a and b are, what their expected sum is, 
//	and whether or not we would expect an illegal argument exception.
	
	static Stream<Arguments> argumentsForAddPositive() {
		
		return(Stream.of(arguments(2, 2, 4, false),
				arguments(1, 2, 3, false),
				arguments(5, 5, 10, false),
				arguments(2, 0, 2, true),
				arguments(-1, 2, 1, true), 
				arguments(10, 1, 11, false),
				arguments(0, 0, 0, true),
				arguments(-1, -1, -2, true),
				arguments(0, -1, -1, true))); 
	}
	
//	If we weren't expecting an exception then we make sure that the sum of a and b equals our expected sum, 
//	otherwise it is an instance of an illegal argument exception.  
	
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		
		if(!expectException) {
			  
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		
		} else {
			
			assertThatThrownBy( () -> 
		    
			testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

		}
	}
	
//	Setting the random number to 5 for the test and making sure that 5 squared is indeed 25.
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();			
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
//	I wanted to try this one a second time. (So cool!)
	
//	@Test
//	void assertThatNumberSquaredIsCorrectAgain() {
//		
//		TestDemo mockDemo = spy(testDemo);
//		
//		doReturn(7).when(mockDemo).getRandomInt();
//		
//		int sevenSquared = mockDemo.randomNumberSquared();
//		
//		assertThat(sevenSquared).isEqualTo(49);
//	}

}

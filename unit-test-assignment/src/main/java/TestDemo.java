import java.util.Random;

public class TestDemo {
	
//	Getting the sum of two integers that are greater than zero, 
//	if they aren't greater than zero, we throw an illegal argument exception.
	
	public int addPositive(int a, int b) {
		
		int sum =  0;
		
		if (a > 0 && b > 0) {
			
			sum = a + b;
		
			return sum;
			
		} else {
			
			throw new IllegalArgumentException("Both parameters must be positive!");
			
		}
	}
	
//	Getting the random number from below and squaring it.
	
	public int randomNumberSquared() {
		
		int random = getRandomInt();
	
		int product = random * random;
		
		return product;
		
	}
	
//	Generating a random number between 1 and 10.
	
	public int getRandomInt() {
		
		Random random = new Random();
		
		return random.nextInt(10) + 1;
	}
}

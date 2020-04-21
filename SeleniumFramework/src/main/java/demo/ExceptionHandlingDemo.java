package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		demo();
	}

	public static void demo() throws ArithmeticException {
//		try {
		System.out.println("Hello world ..");
		int i = 1 / 0;
		System.out.println("Completed");
//		} catch (ArithmeticException ae) {
//			System.out.println("Why what exception");
//			System.out.println(ae.getMessage());
//			System.out.println(ae.getCause());
//			ae.printStackTrace();
//		} finally {
//			System.out.println("Inside finally");
//		}
	}

}

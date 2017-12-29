public class TestExtraction {

	public static void main(String input_link[]) {
		String link = input_link[0];

		// www.swabhav.com?stud="sarvesh"?add="bhandup"

		String domain[] = link.split(".com", 2);
		System.out.print("Domain name is: ");
		System.out.println(domain[0] + ".com");

		String parameter[] = link.split("\\?");
		if (parameter.length == 1) {
			System.out.println("No parameters found");
		} else {
			System.out.println("Parameters are: ");
			for (int i = 1; i < parameter.length; i++) {
				System.out.println(parameter[i]);
			}
		}
	}
}

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	private int token;
	private String fname;
	private double cgpa;

	public Solution(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getName() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class Priorities {
	public List < Solution > getSolutions(List < String > events) {
		PriorityQueue < Solution > student_queue = new PriorityQueue(Comparator.comparing(Solution::getCgpa).reversed().thenComparing(Solution::getName).thenComparing(Solution::getToken));
		List < Solution > students = new ArrayList < Solution > ();
		for (String e: events) {
			Scanner in =new Scanner(e);
			String event = in.next();
			if (event.equals("ENTER")) {
				String name = in.next();
				float cgpa = in.nextFloat();
				int token = in.nextInt();

				Solution student = new Solution(token, name, cgpa);
				student_queue.add(student);
			} else if (event.equals("SERVED")) {
				Solution first = student_queue.poll();
			} in .close();
		}
		Solution first = student_queue.poll();
		if (first == null) {
			return students;
		} else {
			while (first != null) {

				students.add(first);
				first = student_queue.poll();

			}
			return students;
		}

	}
}
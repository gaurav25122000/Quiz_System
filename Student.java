package quiz;

public class Student {
	private int score;
	private String name;
	
	Student(String name)
	{
		this.name=name;
		score=0;
	}
	public void set_score(int i)
	{
		this.score=this.score+i;
	}
	public void display()
	{
		System.out.println("\n\nStudent name: "+name);
		System.out.println("Marks Scored: "+score);
	}

}

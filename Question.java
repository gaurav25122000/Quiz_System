package quiz;

import java.util.Scanner;

public class Question {
	private String Ques;
	private int marks;
	private String[] Options;
	private int correct_ans;
	
	Question()
	{
		Ques="";
		marks=0;
		Options = new String[4];
		correct_ans=0;
	}
	public void set(String Ques,int marks,String[] Options,int correct_ans)
	{
		this.Ques=Ques;
		this.marks=marks;
		this.Options=Options;
		this.correct_ans=correct_ans;
	}
	public void input()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the question");
		Ques = s.nextLine();
		System.out.println("Enter marks for the question");
		marks=s.nextInt();
		System.out.println("Enter the options");
		for(int i=0;i<4;++i)
		{
			System.out.print("Enter Option ");
			System.out.print(i+1);
			System.out.print(": ");
			Options[i]=s.next();
		}
		while(true)
		{
			System.out.println("\nEnter the correct Option Number");
			correct_ans=s.nextInt();
			if(correct_ans>4 || correct_ans<1)
			{
				System.out.println("Choose between 1 to 4");
			}
			else 
				break;
		}
	}
	public void display(int no)
	{
		System.out.println("\n\nQuestion "+no+" is: ");
		System.out.println(Ques);
		System.out.println("The options are: ");
		for(int i=0;i<4;++i)
		{
			System.out.print("Option ");
			System.out.print(i+1);
			System.out.println(": "+Options[i]);
		}
	}
	public int correct()
	{
		return correct_ans;
	}
	public int marks()
	{
		return marks;
	}
}

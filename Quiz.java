import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;;

public class Quiz {
	static List<Question> quiz=new ArrayList<Question>();
	static Scanner s=new Scanner(System.in);
	static int ques=5;
	public static void Teacher()
	{
		quiz.clear();
		System.out.println("How many questions you want to create?");
		ques=s.nextInt();
		for(int i=0;i<ques;++i)
		{
			quiz.add(new Question());
			quiz.get(i).input();
		}
	}
	public static void take()
	{
		System.out.print("Enter name: ");
		String name=s.next();
		Student stu=new Student(name);
		int ans;
		for(int i=0;i<ques;++i)
		{
			quiz.get(i).display(i+1);
			ans=s.nextInt();
			if(ans==quiz.get(i).correct())
			{
				stu.set_score(quiz.get(i).marks());
				System.out.println("Correct Answer!!!");
			}
			else
			{
				System.out.println("Incorrect Answer...");
				System.out.println("The Correct Option is "+quiz.get(i).correct());
			}
		}
		stu.display();
	}
	public static boolean login()
	{	
		String user="Admin",pass="Admin";
		String get_user,get_pass;
		System.out.println("Enter username: ");
		get_user=s.next();
		if(get_user.equals(user))
		{
			System.out.println("Enter Password: ");
			get_pass=s.next();
			if(get_pass.equals(pass))
				return true;
			else 
				System.out.println("Wrong Password");
		}
		else
			System.out.println("Wrong Username");
		return false;
	}
	public static void main(String[] args)
	{	 
		Random random=new Random();
		String[] ques= {"How many days in a year?","How many states are there in India?","Who gave the call for Evergreen Revolution?","The mid day meal scheme was launched in the year?","Nuclear sizes are expressed in ","Light year is the unit of ","The most electronegative element is ","The metal used to recover copper from copper sulphate is ","Which part of database holds information of only one type?",".Mov extension refers to which kind of file?"};
		String[][] option= {{"366","365","364","367"},{"25","26","27","28"},{"M. S. Swaminathan","Verghese Kurien","Tribhuvandas Patel","H. M. Dalaya"},{"2002","1992","1995","2005"},{"Fermi","Angstrom","Newton","Tesla"},{"Time","Distance","Light","Intensity of light"},{"Flourine","Bromine","Oxygen","Sodium"},{"Na","Ag","Hg","Fe"},{"Report","Field","Record","File"},{"Image","Audio","Video","Text"}};
		int[] correct= {2,4,1,3,1,2,1,4,2,3};
		int j,flag=0,count=0;
		char choice='n';
		do {
			System.out.println("Choose the option:\n1.Teacher\n2.Student");
			int ch=s.nextInt();
			if(flag==0)
			{
				List<Integer> randomNumbers = random.ints(0, 10).distinct().limit(5).boxed().collect(Collectors.toList());
				for(int i=0;i<5;++i)
				{
					j=randomNumbers.get(i);
					quiz.add(new Question());
					quiz.get(i).set(ques[j],4,option[j],correct[j]);
				}
			}
			switch(ch)
			{
				case 1:do{
							if(login())
							{
								flag=1;
								Teacher();
								break;
							}
							else
								System.out.println("Login Attempt Failed... \n Try Again...");
							count++;
						}while(count<3);
					   break;
				case 2:take();
						break;
				default:System.out.println("Wrong choice");
			}
			System.out.println("\nWant to try again(y/n)");
			String inp=s.next();
			choice=inp.charAt(0);
		}while(choice=='y'||choice=='Y');		
	}
}

import java.util.*;
public class ToDoList 
{
    static ArrayList<HashMap> Todo = new ArrayList();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
	{
	    int menuItem = -1;
        while (menuItem != 0)
		{
            menuItem = menu();
            switch (menuItem)
			{
				case 1:
					seetask();
					break;
				case 2:
					addtask();
					break;
				case 3:
				    removetask();
				    break;
				case 0:
					break;
				default:
					System.out.println("Enter a valid option");
            }
        }
	}
	public static int menu()
	{
	    System.out.println("0. Exit the program");
        System.out.println("1. Display to-do list");
        System.out.println("2. Add item to list");
        System.out.println("3. Remove item from list");
        System.out.println();
        System.out.print("Enter Your choice: ");
        int choice = sc.nextInt();
        return choice;
	}
	public static void seetask()
	{
	    if(Todo.isEmpty())
	    {
	        System.out.println("\033[H\033[2J");
	        System.out.println("Your Todo is Empty!!!");
	        System.out.println();
	    }
	    else
	    {
	        System.out.println("\033[H\033[2J");
	        System.out.println("Todo:");
		    System.out.println("----------------------");
		    int number = 0;
		    for (int itr = 0 ; itr < Todo.size() ; itr += 1)
		    {
		        HashMap mh = new HashMap();
		        mh = Todo.get(itr);
		        System.out.print((++number)+". ");
		        System.out.print("Task : " + mh.get("Task")+" | ");
    		    System.out.print("Priority : " + mh.get("priority")+" | ");
    		    System.out.println("Duration : " + mh.get("Duration"));
		    }
	    }
	}
	public static void addtask()
	{
	    System.out.println("\033[H\033[2J");
	    char ch = '0';
		while(true)
		{
			System.out.println("Did you want add the task (y or n)");
			ch = sc.next().charAt(0);
			if(ch == 'n')
			{
			    System.out.println("\033[H\033[2J");
				break;
			}
			System.out.println("----------------------");
			sc.nextLine();
			System.out.println("Enter an Task: ");
			String item = sc.nextLine();
			System.out.println();
			System.out.println("Enter an Priority , 1.very important , 2.important , 3.unimportant ");
			int priority = sc.nextInt();
			System.out.println();
			System.out.println("Enter a Time in Hours to complete the task");
			int tasktime = sc.nextInt();
			if(priority == 1)
			{
			    String p1 = "Very Important";
			    HashMap hm = new HashMap();
			    hm.put("Task",item);
			    hm.put("priority",p1);
			    hm.put("Duration",tasktime);
			    Todo.add(hm);
			}
			else if (priority == 2)
			{
			    String p2 = "Important";
			    HashMap hm = new HashMap();
			    hm.put("Task",item);
			    hm.put("priority",p2);
			    hm.put("Duration",tasktime);
			    Todo.add(hm);
			}
			else if (priority == 3)
			{
			    String p3 = "UnImportant";
			    HashMap hm = new HashMap();
			    hm.put("Task",item);
			    hm.put("priority",p3);
			    hm.put("Duration",tasktime);
			    Todo.add(hm);
			}
		}
		System.out.println("\033[H\033[2J");
	}
	public static void removetask()
	{
	    System.out.println("\033[H\033[2J");
        seetask();
        System.out.println("Remove Item");
        System.out.println("----------------------");
        System.out.println();
        System.out.println("Enter the task which do you want to remove");
        int index = sc.nextInt();
        if((index-1)<0 || index>Todo.size())
            System.out.println("Wrong index number! Please enter in range of 1 to "+Todo.size());
    	else
            Todo.remove(index-1);
        System.out.println("\033[H\033[2J");
	}
}


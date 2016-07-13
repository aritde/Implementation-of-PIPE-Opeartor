package bonus;
import java.util.*;
public class Operation
{
	private static Chain current;
	public static void main(String[] args)
	{
		System.out.println("The commands considered for this program are ADD / SUBTRACT / EXP");
		System.out.println("If EXP is the first command, then EXP 2 3 would signify (3^2)");
		System.out.println("If SUB is the first command, then SUB 2 3 would signify (3-2)");
		System.out.println("Enter the mathematical expression to be evaluated");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		str = str.toUpperCase();
		boolean flag = true;
		ArrayList<String> list_of_commands = new ArrayList<String>();
		// Picks up the commands to 'command' array_list.
		while(true)
		{
			int j = str.indexOf("|");
			if(j!= -1){
				String each_command = str.substring(0,j).trim();
				list_of_commands.add(each_command);
				str=str.substring(j+1);
			}
			else
			{
				break;
			}
		}
		list_of_commands.add(str.trim());
		Chain firstcommand=null;
		for(int i=0; i<list_of_commands.size();i++)
		{
			int position_between_command_and_parameters = list_of_commands.get(i).indexOf(" ");
			if(position_between_command_and_parameters == -1)
			{
				System.out.println( "All the commands do not have the necessary parameters");
				flag = false;
				break;
			}
			String command = list_of_commands.get(i).substring(0, position_between_command_and_parameters);
			String[] parameters_in_command = list_of_commands.get(i).split(" ");
			if (command.equals("ADD"))
			{
				ADD add = new ADD();
				add.setValue(Integer.parseInt(parameters_in_command[1]));
				if(i+1<list_of_commands.size())
				{
					if(current == null)
					{
						chain_formation(add,list_of_commands,i+1);
					}
					else
					{
						chain_formation(current,list_of_commands,i+1);
					}
				}
				if(i==0)
				{
					firstcommand = add;
				}
			}
			else if(command.equals("SUB"))
			{
				SUBTRACT sub = new SUBTRACT();
				sub.setValue(Integer.parseInt(parameters_in_command[1]));
				if(i+1 < list_of_commands.size())
				{
					if(current == null)
					{
						chain_formation(sub, list_of_commands,i+1);
					}
					else
					{
						chain_formation(current, list_of_commands,i+1);
					}
				}

				if(i==0)
				{
					firstcommand = sub;
				}
			}
			else if (command.equals("EXP"))
			{
				Exponential exponential = new Exponential();
				exponential.setValue(Integer.parseInt(parameters_in_command[1]));
				if(i+1 < list_of_commands.size())
				{
					if(current == null)
					{
						chain_formation(exponential, list_of_commands,i+1);
					}
					else
					{
						chain_formation(current, list_of_commands,i+1);
					}
				}
				if(i==0)
				{
					firstcommand = exponential;
				}
			}
			else
				System.out.println("This program accepts only the following commands : ADD / SUB / EXP");

		}
		if(flag==true)
		{
			if(null != firstcommand)
			{
				String[] firstCommandArgs  = list_of_commands.get(0).split(" ");
				firstcommand.Calculation(Integer.parseInt(firstCommandArgs[2]));
			}
			else
			{
				System.out.println("This program accepts only the following commands : ADD / SUB / EXP");
			}
		}
		else
		{
			System.out.println("All the commands do not have the necessary parameters");
		}
	}
	public static void chain_formation(Chain curr, ArrayList<String> list_of_commands, int index)
	{
		String[] args = list_of_commands.get(index).split(" ");
		if(list_of_commands.get(index).charAt(0)=='S')
		{
			SUBTRACT sub = new SUBTRACT();
			sub.setValue(Integer.valueOf(args[1]));
			curr.setNextChain(sub);
			current = sub;
		}
		if(list_of_commands.get(index).charAt(0)=='E')
		{
			Exponential expnonential = new Exponential();
			expnonential.setValue(Integer.valueOf(args[1]));
			curr.setNextChain(expnonential);
			current=expnonential;
		}
		if(list_of_commands.get(index).charAt(0)=='A')
		{
			ADD add = new ADD();
			add.setValue(Integer.valueOf(args[1]));
			curr.setNextChain(add);
			current=add;
		}

	}

}

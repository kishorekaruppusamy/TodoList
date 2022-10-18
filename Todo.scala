import scala.io.StdIn._
import scala.util.control.Breaks._

object Todo
{   
    var Tasks_array : Array[todos]= Array()

    def main(args: Array[String]): Unit = 
    {
        var menuItem : Int = -1
        while ( true )
        {
            menuItem = menu()
            if (menuItem == 0)
            {
                break
            }
            else
            { 
                Pattern_match(menuItem)
            }
        }   
    }

    def Pattern_match(menuItem : Int) : Unit =
    {
        menuItem match{
            case 1 => see_task()
            case 2 => add_task()
            case 3 => remove_task()
            case _ => println("Enter a valid option")
        }
    }

    def menu() : Int =
    {
        println("0. Exit the program")
        println("1. Display to-do list")
        println("2. Add item to list")
        println("3. Remove item from list")
        println()
        print("Enter Your choice: ")
        val choice = readInt()
        choice
    }

    def see_task() : Unit =
    {
        if (Tasks_array.isEmpty) {
            println("Your Todo is Empty!!!")
            println()
        }
        else {
            println("Todo:")
            println("----------------------")
            var number = 1
            for (task <- Tasks_array)
            {
                print("Task Number : " + number + " | ")
                print("Task Description : " + task.get_task + " | ")
                print("Priority : " + task.get_Priority + " | ")
                println("Duration : " + task.get_Duration)
                number += 1
            }
            println()
        }
    }

    def add_task() : Unit =
    {
        // get the task from user
        print("Enter the task you want to add : ")
        val task = readLine()
        println()

        // get the Priority from user
        print("Enter the Priority of the task  1.High , 2.Medium , 3.Low : ")
        val Priority = readInt()
        println()
        
        // get the Duration from the user
        print("Enter the Duration to complete the task : ")
        val Duration = readInt()
        println()

        if (Priority == 1){ Tasks_array = Tasks_array :+ new todos(task, "High", Duration) }
        else if (Priority == 2){ Tasks_array = Tasks_array :+ new todos(task, "Medium", Duration) }
        else { Tasks_array = Tasks_array :+ new todos(task, "Low", Duration) }

    }

    def remove_task() : Unit =
    {
        see_task()
        println("Remove Item")
        println("----------------------")
        println("Enter the task Number which do you want to remove")
        val index = readInt()
        if ((index - 1) < 0 || index > Tasks_array.length)
            System.out.println("Wrong index number! Please enter in range of 1 to " + Tasks_array.length)
        else
        {
            val task = Tasks_array(index - 1)
            Tasks_array = Tasks_array.filter(_ != task)
        }
        see_task()
    }
}
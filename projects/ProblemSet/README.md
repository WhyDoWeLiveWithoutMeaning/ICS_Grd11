# Basic Java Programming Problems


## Problem Set 1

### 1. Write an application that reads three numbers and prints their average


### 2. Write an application that converts miles to kilometers. One mile equals 1.60935 kilometers. Read the miles value from the user as a double.


### 3. Write a program that lets you enter a number of hours, and that converts it to days and hours. For example, 111 hours = 4 days and 15 hours.


### 4. Chocolate chip cookie problem


There are 12 cookies per box (sold at $1.14) and 24 boxes per carton. Left over boxes are sold for 57¢. Remaining cookies are given away free. Given the number of cookies produced, determine the number of boxes, cartons, left over boxes and the total money made.


Write a program that will ask the user to enter a number of cookies produced. From that information, print the number of cartons, the number of leftover boxes, the number of leftover cookies, and the total profit.


e.g.


Enter the number of cookies baked: 54635


If 54635 cookies were baked you would end up with:


cartons: 189

leftover boxes: 16

leftover cookies: 11

profit: $5,180.16


### 5. Write a program that creates and prints random lock combinations. Each combination should consist of 3 numbers from 0 to 59 inclusive.



### 6. Write an application that reads the (x, y) coordinates for two points. Compute the distance between the two points using the following formula:

dist = square root of (x2 – x1)2 + (y2 – y1)2

## Problem Set 2

### 1. Design and implement an application that plays the Hi-Lo guessing game with numbers. The program should pick a random number between 1 and 10. The program should then ask the user to guess the number and print an appropriate message telling the user they were too high, too low, or correct. Display the correct answer for the user.

### 2. A wholesale egg company bases their process on the number of eggs purchased:


0 up to but not including 4 dozen $0.50 per dozen

4 up to but not including 6 dozen $0.45 per dozen

6 up to but not including 11 dozen $0.40 per dozen

11 or more dozen $0.35 per dozen

Extra eggs are priced at 1/12 the per dozen price


Create an Eggs application that prompts the user for the number of eggs, and then calculates the bill.



### 3. Create a program that will ask the user to input the number of hours they worked in a week, and their hourly rate. Have the program calculate their weekly pay. If the user worked more than 40 hours in a week, they should be paid “time and a half” for any hours beyond the 40 hours. (that’s 1.5 times their regular pay)



### 4. Write a program that will ask a user for an amount of fuel in litres, and a price per litre. Your program should then output the total amount you have to pay. To complicate the calculation, there is a discount based on the amount of fuel you purchase. If you purchase 40 litres or more, there is a discount of 5 cents per litre. If you purchase 70 litres or more you get a discount of 8 cents per litre.



### 5. Create a program to determine the raise and new salary for an employee. The input to the program includes the current annual salary for the employee and a number indicating the performance rating (1=excellent, 2=good, and 3=poor). An employee with a rating of 1 will receive a 6% raise, an employee with a rating of 2 will receive a 4% raise, and one with a rating of 3 will receive a 1.5% raise. Print out the amount of the raise, and the employees new salary.


e.g.


Enter your current salary: 56000

Enter your performance rating: 2


Your raise will be: $2240

Your new salary will be $58240




### 6. Design and implement an application that reads an integer value representing a year input by the user. The purpose of the program is to determine if the year is a leap year (and therefore has 29 days in February) in the Gregorian calendar. A year is a leap year if it is divisible by 4, unless it is also divisible by 100 but not 400. For example, the year 2003 is not a leap year, but 2004 is. The year 1900 is not a leap year because it is divisible by 100, but the year 2000 is a leap year because even though it is divisible by 100, it is also divisible by 400. Produce an error message for any input value less than 1582 (the year the Gregorian calendar was adopted).

## Problem Set 3

### 1. Write a program that will ask the user to enter a number. Continue asking for numbers until the user enters 0 as the number.


### 2. Modify your Hi/Low guessing game from the previous problem set so that you must continue to guess numbers until you get the number correct. When the user guesses the correct number, tell them how many guesses it took.


### 3. Write a program that will ask the user for a number. Print all the numbers from 1 to the number entered.


### 4. Write a program that will ask a user for a number from 1-1000. Have the program print the sum of all the numbers from 1 to the entered number. For example; if the user entered 5 the computer would print 15, (1+2+3+4+5).


### 5. Write a program that will ask the user to enter a number and then have the computer print the sum of the digits in the number. For example; if the user typed 127, the computer would print 10 (1+2+7).


### 6. Have the tortoise and hare complete a race of x units long. Use a random number to determine the distance each travels per unit time.

Tortoise:
  - 50% 3 squares ahead
  - 20% 6 squares back
  - 30% 1 square ahead


Hare: 
 - 20% no move
 - 20% 9 squares ahead
 - 10% 12 squares back
 - 30% 1 square ahead
 - 20% 2 squares back


Include fun commentary on the race.


### 7. A trident is a fork with three tines (prongs). A simple picture of a trident can be made from asterisks and spaces.

![Picture of Trident](https://i.imgur.com/CQZg2pI.png)


#### In this example, each tine is a vertical column of 3 asterisks. Each tine is separated by 2 spaces. The handle is a vertical column of 4 asterisks below the middle tine.
Tridents of various shapes can be drawn by varying three parameters: t, the height of the tines, s, the spaces between tines, and h, the height of the handle. For the example above we have t = 3, s = 2, and h = 4. You are to write an interactive program to print a trident. Your program should accept as input t, s, and h, and print the appropriate trident. You can assume that t,s,h are each at least 0 and not larger than 10.


Sample Session – User input in italics


Enter tine length:  3

Enter tine spacing:  2

Enter handle length:  4

![Picture of Trident](https://i.imgur.com/CQZg2pI.png)

## Problem Set 4

### 1. Write a method that will print your address when called.

### 2. Write a method called lol() that will print the following when called:

*      *****  *
*      *   *  *
*      *   *  *
*      *   *  *
*****  *****  *****

### 3. Write a method called greetings() that will take a String as a parameter. The String should represent the name of the person you are greeting. For example, calling greetings(“Earl”) should print the following:

Greetings Earl! It is a pleasure to meet you!

### 4. Write a method called repeat() that takes a String and an integer as parameters. The method should print the String as many times as specified by the integer. For example, if you called repeat(“Hello”,5) your output should be:

Hello
Hello
Hello
Hello
Hello

### 5. Write a method called trueOrFalse() that returns a boolean value chosen at random. (use Math.random() to generate the randomness)

### 6. Write a method called areaOfCircle(). Have the method accept a double parameter representing the radius of a circle. Have the method return the area of the circle with the given area.

### 7. Write a method that will return a random number from 1 to 6.

### 8. Write a method that will accept an integer parameter. The parameter determines how many numbers to add to a sum. The method should return the sum of random numbers from 1-6 based on the parameter value. (e.g. if the parameter is 3, return the sum of 3 random numbers from 1-6)

### 9. Write a method similar to the above method, but have the method accept a second parameter for the maximum value. The method should use 1-max as the range for the numbers. (e.g. if the method is sent 3 and 10, the method should return the sum of 3 random numbers from 1-10)

## Extra Looping

### 1. Multiplication Table

Use loops to generate a multiplication table for numbers 1 to 10. The table should look like this:

![Multiplication Table](https://i.imgur.com/uFSipD9.png)

### 2. Number Analysis

Create a program that will allow a user to input any integer. Have your program count and output the number of 0’s, odd numbers, and even numbers. For example:

![Example](https://i.imgur.com/tTPt2OH.png)

### 3. Prime Numbers

Create a program that will allow a user to enter any integer. Your program should then print a message stating the number entered IS or IS NOT a prime number.

![Example](https://i.imgur.com/OyOCJMe.png)

## Java Practice Problems

### 1. Write a program that prints the numbers from 10 to 100 by 10’s using a “while” loop.

### 2. Write a program that prints the numbers from 10 to 100 by 10’s using a “for” loop.

### 3. Write a program that askes the user for a single letter. Print out whether the letter is a consonant or a vowel.

### 4. Write a program in Java to display the cube of the number up to a given integer.

Example:
  - Input number of terms : 4


Expected Output :
  - Number is : 1 and cube of 1 is : 1
  - Number is : 2 and cube of 2 is : 8
  - Number is : 3 and cube of 3 is : 27
  - Number is : 4 and cube of 4 is : 64


### 5. Write a program that will ask the user to enter a single word command. Keep asking for commands until the user enters “quit” as the command.

import java.util.Scanner;

public class LongestChainWarmUp {

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter a num.");
//        long chainNum = getLong(input);
//        System.out.println(longestCollatz(chainNum));
        long chainNum = -1;
        long maxChain = -1;
        for (long i = 1; i < 1000000; i++) {
            long currentChain = longestCollatz(i);
           if(currentChain > maxChain)
           {
               maxChain = currentChain;
               chainNum = i;
           }
        }
        System.out.println(chainNum + " gives the biggest chain of "+ maxChain);
    }

    public static long longestCollatz(long num)
    {
        long chainCount = 0;
       while(num >= 1)
       {
           if(num == 1)
           {
               chainCount++;
               return chainCount;
           }
           else if(num%2==0)
           {
               chainCount++;
               num = num/2;
           }
           else if(num%2!=0)
           {
               chainCount++;
               num = num*3+1;
           }

       }
       return chainCount;
    }


    //verifying if an int is passed in
    public static long getLong(Scanner input)
    {
        while(!input.hasNextLong())
        {
            input.nextLine();
            System.out.println("That is not an integer! Try again!");

        }
        return input.nextLong();
    }
}

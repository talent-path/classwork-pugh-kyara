public class App {

    public static void main(String[] args) {
        int num1 = 1233;
        int num2 = 2000;
        int num3 = 1111;
        int num4 = 5;
        int num5 = 957;
        int num6 = -7;

        System.out.println("The reverse of "+num1+" is "+ toFlip(num1));
        System.out.println("The reverse of "+num2+" is "+ toFlip(num2));
        System.out.println("The reverse of "+num3+" is "+ toFlip(num3));
        System.out.println("The reverse of "+num4+" is "+ toFlip(num4));
        System.out.println("The reverse of "+num5+" is "+ toFlip(num5));
        System.out.println("The reverse of "+num6+" is "+ toFlip(num6));

    }

    public static int toFlip(int n)
    {
        int flip = 0;
        while (n!=0)
        {
            //get the last digit in the original number
            int flippedNum = n%10;
            //add the remainder to the new digit to flip
            flip = flippedNum+(flip*10);
            //decrement n by 10
            n/=10;
        }
        return flip;
    }
}


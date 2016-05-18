/**
 * Created by kamalnrf on 18/5/16.
 */
public class RandomGenerator
{
    public static int  randomNumber(int min, int max)
    {
        int m = 1;

        m++;

        return (m*max + min)/(m + 1);
    }


    public static void main(String[] args) {
        System.out.println(randomNumber(10, 20));
    }
}

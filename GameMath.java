public class GameMath
{
    public static float roundToHundreths(float number)
    {
        return (float)(Math.round(number * 100) / 100.0);
    }
    public static float roundToTenths(float number)
    {
        return (float)(Math.round(number * 10) / 10.0);
    }

    public static int getSign(float number)
    {
        if (number < 0)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
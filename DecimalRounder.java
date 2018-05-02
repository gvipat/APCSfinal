public class DecimalRounder
{
    public static float roundToHundreths(float number)
    {
        return (float)(Math.round(number * 100) / 100.0);
    }
}
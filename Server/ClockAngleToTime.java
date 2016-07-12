class ClockAngleToTime
{
	
	public static void main(String args[])
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		
		System.out.println("Enter anlge in degree:");
		int angle=sc.nextInt();
		System.out.println("Time is:"+convertAngleToTimeString(angle));
		sc.close();
	}
	
	public static String convertAngleToTimeString(float angle) {
    String time = "";
    float decimalValue = 3.0f - (1.0f/30.0f) * (angle % 360);
    if (decimalValue < 0)
        decimalValue += 12.0f;

    int hours = (int)decimalValue;
    if (hours == 0)
        hours = 12;
    time += (hours < 10 ? "0" + hours: hours) + ":";
    int minutes = (int)(decimalValue * 60) % 60; 
    time += minutes < 10 ? "0" + minutes: minutes;
    return time;
}	

}
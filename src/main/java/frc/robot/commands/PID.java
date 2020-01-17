public class PID
{
    private double Kp;
    private double Ki;
    private double Kd;
    private double refreshRate;
    private double sum;
    private double num;

    public PID(double Kp, double Ki, double Kd, double refreshRate)
    {
        this.Kp = Kp;
        this.Ki = Ki;
        this.Kd = Kd;
        this.refreshRate = refreshRate;
        this.sum = 0;
        this.num = 0;
    }

    public double getControl(double error)
    {
        sum += error;
        num ++;
        return Kp * error + Ki * refreshRate * sum; // +  Kd * derivateEstim
    }

    public double clearCache()
    {
        sum = 0;
        num = 0;
    }
}
    

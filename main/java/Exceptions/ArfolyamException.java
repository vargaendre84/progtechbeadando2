package Exceptions;

public class ArfolyamException extends Exception
{
    public ArfolyamException(String Message, double Arfolyam)
    {
        super(Message);
        this.Arfolyam = Arfolyam;
    }
    private double Arfolyam;
    public double getArfolyam() {return Arfolyam;}
    public void setArfolyam(double value) {Arfolyam = value;}
}


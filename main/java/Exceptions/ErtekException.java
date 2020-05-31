package Exceptions;

public class ErtekException extends Exception
{
    public ErtekException(String Message, long Ertek)
    {
        super(Message);
        this.Ertek = Ertek;
    }
    private long Ertek;
    public long getErtek() {return Ertek;}
    public void setErtekm(long value) {Ertek = value;}
}


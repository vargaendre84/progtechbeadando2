package Observer;

public class Arfolyam_Euro implements IObserver, IDisplay
{
    private double eurArfolyam;
    private ISubject penzvalto;

    public Arfolyam_Euro(ISubject penzvalto )
    {
        this.penzvalto = penzvalto;
        penzvalto.RegisterObserver(this);
    }

    @Override
    public void Update(double eurArfolyam, double usdArfolyam)
    {
        this.eurArfolyam = eurArfolyam;
    }

    public double getEuroArfolyam()
    {
        return eurArfolyam;
    }

    @Override
    public void Display()
    {
        System.out.println("Az Euró árfolyama: " + eurArfolyam);
    }
}

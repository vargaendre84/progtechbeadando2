package ArfolyamObserver;
import Exceptions.ArfolyamException;

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
    public void Update(double eurArfolyam, double usdArfolyam, double kriptoETHArfolyam) throws ArfolyamException
    {
        if (eurArfolyam > 0.0)
            this.eurArfolyam = eurArfolyam;
        else throw new ArfolyamException("Rossz árfolyam értéket adott meg!", eurArfolyam);
    }

    public double getArfolyam()
    {
        return eurArfolyam;
    }

    @Override
    public void Display()
    {
        System.out.println("Az Euró árfolyama: " + eurArfolyam);
    }
}

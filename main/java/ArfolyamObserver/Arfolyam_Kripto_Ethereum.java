package ArfolyamObserver;
import Exceptions.ArfolyamException;

public class Arfolyam_Kripto_Ethereum implements IObserver,IDisplay
{
    private double kriptoETHArfolyam;
    private ISubject penzvalto;

    public Arfolyam_Kripto_Ethereum(ISubject penzvalto )
    {
        this.penzvalto = penzvalto;
        penzvalto.RegisterObserver(this);
    }

    @Override
    public void Update(double eurArfolyam, double usdArfolyam, double kriptoETHArfolyam) throws ArfolyamException
    {
        if (kriptoETHArfolyam > 0.0)
             this.kriptoETHArfolyam = kriptoETHArfolyam;
        else throw new ArfolyamException("Rossz árfolyam értéket adott meg!", kriptoETHArfolyam);
    }

    public double getArfolyam()
    {
        return kriptoETHArfolyam;
    }

    @Override
    public void Display()
    {
        System.out.println("Az Ethereum árfolyama: " + kriptoETHArfolyam);
    }
}

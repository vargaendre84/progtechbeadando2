package ArfolyamObserver;

import Exceptions.ArfolyamException;

import java.util.ArrayList;

public class Penzvalto implements ISubject
{
    private ArrayList<IObserver> observers;
    private double EurArfolyam;
    private double USDArfolyam;
    private double kriptoETHArfolyam;

    public Penzvalto()
    {
        observers = new ArrayList<IObserver>();
    }

    @Override
    public void RegisterObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveObserver(IObserver o) {
        int i = observers.indexOf(o);
        if(i >= 0) observers.remove(i);
    }

    @Override
    public void NotifyObservers() throws Exception {
        for(int i = 0; i < observers.size(); i++)
        {
            IObserver observer = (IObserver)observers.get(i);
            observer.Update(EurArfolyam,USDArfolyam,kriptoETHArfolyam);
        }
    }

    public void MegvaltozottAzArfolyam() throws Exception {NotifyObservers();}

    public void ArfolyamBeallitas(double EurArfolyam, double USDArfolyam, double kriptoETHArfolyam)
            throws Exception
    {
        if (EurArfolyam > 0.0)
            this.EurArfolyam = EurArfolyam;
        else throw new ArfolyamException("Rossz árfolyam értéket adott meg!", EurArfolyam);
        if (USDArfolyam > 0.0)
            this.USDArfolyam = USDArfolyam;
        else throw new ArfolyamException("Rossz árfolyam értéket adott meg!",USDArfolyam);
        if (kriptoETHArfolyam > 0.0)
            this.kriptoETHArfolyam = kriptoETHArfolyam;
        else throw new ArfolyamException("Rossz árfolyam értéket adott meg!", kriptoETHArfolyam);

        MegvaltozottAzArfolyam();
    }
}

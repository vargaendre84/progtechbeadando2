package ArfolyamObserver;
import Exceptions.ArfolyamException;

public interface IObserver
{
    void Update(double EURArfolyam, double USDArfolyam, double kriptoETHArfolyam) throws Exception, ArfolyamException;
}

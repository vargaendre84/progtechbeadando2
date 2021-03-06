package ArfolyamObserver;

public interface ISubject
{
    void RegisterObserver(IObserver o);
    void RemoveObserver(IObserver o);
    void NotifyObservers() throws Exception;
}

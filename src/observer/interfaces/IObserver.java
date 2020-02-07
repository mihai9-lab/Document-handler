package observer.interfaces;

public interface IObserver {
	void addObserver(IOListener listener);
	void removeObserver(IOListener listener);
	void notifyObserver(Object event);
}

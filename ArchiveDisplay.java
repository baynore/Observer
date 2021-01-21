import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class ArchiveDisplay implements Observer, DisplayElement {
	Observable observable;
	ArrayList<Float> al;
	
	public ArchiveDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
		
		al = new ArrayList<Float>();
	}
	
	public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			al.add(weatherData.getTemperature());
            display();
		}
	}
	
	public void display() {
        //System.out.println(al); //for testing
        System.out.println("------------------------\n" +
                           "|     Temperatures     |\n" +
                           "------------------------"); //print table header
        for (int i = 0; i < al.size(); i++)
            System.out.println("|         " + al.get(i) +
                               "         |");
        System.out.print("------------------------\n"); //print table body
	}
}

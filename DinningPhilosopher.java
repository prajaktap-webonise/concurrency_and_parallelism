
public class DinningPhilosopher{
	public static void main(String[] args){

	int executions=5;

	//System.out.println(String.valueOf(executions));

	Chopstick[] sticks = new Chopstick[5];

	
	for(int i=0; i< sticks.length; i++){
		sticks[i] = new Chopstick("Chopstick "+i);
	}
	Philosopher[] person = new Philosopher[5];
	
	person[0] = new Philosopher("A- 0  ", sticks[0], sticks[1], executions);
	person[1] = new Philosopher("B- 1  ", sticks[1], sticks[2], executions);
	person[2] = new Philosopher("C- 2  ", sticks[2], sticks[3], executions);
	person[3] = new Philosopher("D- 3  ", sticks[3], sticks[4], executions);
	person[4] = new Philosopher("E- 4  ", sticks[0], sticks[4], executions);

	for(int i=0;i<person.length;i++){
		System.out.println("Thread "+ i + " started");
		Thread t= new Thread( person[i]);
		t.start();
	}
 	}
}

class Philosopher extends Thread
{
	private Chopstick leftChopistick;
	private Chopstick rightChopistick;
	private String name;
	private int state;
	private int rounds;

	public Philosopher ( String goodname, Chopstick leftstick, Chopstick rightstick, int count){
		this.state = 1;
		this.name = goodname;
		leftChopistick = leftstick;
		rightChopistick = rightstick;
		rounds = count;
	}
 
	public void eat()
	{
		if(! leftChopistick.used){
		if(!rightChopistick.used){
		leftChopistick.take();
		rightChopistick.take();

		System.out.println(name + " -> Eat");
				
		Sleep.Delay(1000);

		rightChopistick.release();
		 leftChopistick.release();
		}
		}		
		think();
	}

	public void think(){
	 	this.state = 1;
	 	System.out.println(name + " -> Thinking**");
	 	Sleep.Delay(1000);
		
  }

	public void run(){
		for(int i=0; i<=rounds; i++){
		eat();
		}
	}
}

class Chopstick{

	public boolean used;
	public String name;

	public Chopstick(String goodname){
		this.name = goodname;
	}

	public synchronized void take() {
		System.out.println ("Put - " + name );
		this.used = true;
	}
	public synchronized void release() {
		System.out.println ("Released - " + name );
		this.used = false ;
	}
}

class Sleep{

	public static void Delay(int ms){
		try{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex){ }
	}
}




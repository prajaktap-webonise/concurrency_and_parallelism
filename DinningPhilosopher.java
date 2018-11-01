public class DinningPhilosopher{
  public static void main(String[] args){

    int numbersOfphilosopher = 5;
    int numbersOfChopisticks = 5;
    int executions=5;
    Chopstick[] sticks = new Chopstick[numbersOfChopisticks];

    for(int count=0; count< numbersOfChopisticks; count++){
    sticks[count] = new Chopstick("Chopstick "+count);
    }

    Philosopher[] person = new Philosopher[numbersOfphilosopher];

    person[0] = new Philosopher("A- 0  ", sticks[0], sticks[1], executions);
    person[1] = new Philosopher("B- 1  ", sticks[1], sticks[2], executions);
    person[2] = new Philosopher("C- 2  ", sticks[2], sticks[3], executions);
    person[3] = new Philosopher("D- 3  ", sticks[3], sticks[4], executions);
    person[4] = new Philosopher("E- 4  ", sticks[0], sticks[4], executions);

    for(int count=0; count< numbersOfphilosopher; count++){
    System.out.println("Thread "+ count + " started");
    Thread t= new Thread( person[count]);
    t.start();
    }
  }
}

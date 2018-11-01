class Philosopher extends Thread {
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

  public void eat() {
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

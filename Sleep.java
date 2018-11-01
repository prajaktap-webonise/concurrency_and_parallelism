class Sleep{

  public static void Delay(int ms){
    try{
    Thread.sleep(ms);
    }
    catch(InterruptedException ex){ }
  }
}

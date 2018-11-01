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

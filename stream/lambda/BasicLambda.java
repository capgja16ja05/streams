package stream.lambda;

public class BasicLambda {
	
	
	public static void main(String[] args) {
		
		BasicLambda obj = new BasicLambda();
		//obj.approach1();
		//obj.approach2();
		obj.approach3();
	}
	
	// lambda approach 1
	void approach1()
	{
		Bluetooth b = (fileName)-> {
			System.out.println("Reading and sharing "+fileName);
			int dataTF = 80+4858+965; 
			return dataTF;
			
		};
		int x = b.shareData("MyMusicFile.mp3");
		System.out.println(x);
	}

	void approach2()
	{
		Bluetooth b = (fileName)-> 	fileName.length()+1;
			
		
		int x = b.shareData("a.mp3");
		System.out.println(x);
	}
	
	void approach3()
	{
		Bluetooth b = fileName -> 	fileName.length()+2;
			
		
		int x = b.shareData("a.mp3");
		System.out.println(x);
	}
	
	
	
	
}//end class












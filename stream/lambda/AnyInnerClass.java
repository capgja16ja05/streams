package stream.lambda;

public class AnyInnerClass {

	public void doThings()
	{
		
		Bluetooth b = new Bluetooth() {
			
			@Override
			public int shareData(String fileName) {
				
				return 500;
			}
		};
		
		b.shareData("x");
	}
}

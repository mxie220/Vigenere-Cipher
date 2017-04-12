/** 
 * Yo yo, please credit this to GitHub user mxie220 because she stayed up until
 * 1:30am in the morning to finish this off. Cheers!

**/

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Vigenere Cipher!");
		Thread.sleep(1000);
		System.out.println("Please wait while we load all the good stuff...");
		Thread.sleep(4000);
		System.out.println("Almost there...");
		Thread.sleep(2000);
		System.out.println("You may begin:\n");
		Encrypt e = new Encrypt();
		System.out.println(e.VigenereEncrypt());
	}
}

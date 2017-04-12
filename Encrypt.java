import java.util.Hashtable;
import java.util.Scanner;

public class Encrypt {
		Scanner input = new Scanner(System.in);
		
	public int[] Key() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Enter Key Length: ");
		Scanner key_length = input;
		int kl = Integer.parseInt(key_length.nextLine().replaceAll("\\s", ""));

		int[] keys;
		keys = new int[kl];
		
		int count = kl; 
		
		while (count > 0) {
			System.out.println("Enter Key: ");
			Scanner k = input;
			int key = Integer.parseInt(k.nextLine().replaceAll("\\s", ""));
			keys[kl-count] = key;
			count -= 1;
		}

		return keys;
	}
	
	
	public String PlainText() {
		String plain_message = "";
		System.out.println("Enter Plain Text: ");
		Scanner message = input;
		plain_message += message.nextLine();

		return plain_message;
	}
	
	public Hashtable<Integer, Character> LookUpByPosition() {
		int num = 0;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Hashtable<Integer, Character> p = new Hashtable<Integer, Character>();
		for (char alpha : alphabet.toCharArray()) {
			p.put(num, alpha);
			num += 1;
		}
		return p;
		
	}
	
	public Hashtable<Character, Integer> LookUpByLetter() {
		int num = 0;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Hashtable<Character, Integer> l = new Hashtable<Character, Integer>();
		for (char alpha : alphabet.toCharArray()) {
			l.put(alpha, num);
			num += 1;
		}
		return l;
		
	}
	
	public String Caesar(char letter, int key, 
			Hashtable<Integer, Character> lookUpByPosition, Hashtable<Character, Integer> lookUpByLetter) {
		String cipher_text;
		int shift = lookUpByLetter.get(letter) + key;
		if (shift > 26) {
			int move_to = shift - 26;
			cipher_text = (lookUpByPosition.get(move_to)).toString();
		}
		else {
			shift = lookUpByLetter.get(letter) + key;
			cipher_text = (lookUpByPosition.get(shift)).toString();
		}
		return cipher_text;
	}
	
	public String VigenereEncrypt() throws InterruptedException {
		String return_text = "";
		String plain_text = PlainText().toLowerCase();
		int text_length = plain_text.length();
		int[] keys = Key();
		int key_pos = 0;
		Hashtable<Character, Integer> look_up_letter = LookUpByLetter();
		Hashtable<Integer, Character> look_up_position = LookUpByPosition();
		while (text_length > 0) {
			char letter = plain_text.charAt(plain_text.length() - text_length);
			if (Character.toString(letter).matches("([a-z?])")) {
				if (key_pos < keys.length) {
					int key = keys[key_pos];
					String l = Caesar(letter, key, look_up_position, look_up_letter);
					return_text += l;
					key_pos += 1;
				}
				else if (key_pos == keys.length) {
					key_pos = 0;
					int key = keys[key_pos];
					String l = Caesar(letter, key, look_up_position, look_up_letter);
					return_text += l;
					key_pos += 1;
				}
			}
			else {
				// check for other symbols
				return_text += Character.toString(letter);
			}
			text_length -= 1;
		}
		input.close();
		return return_text;
		
	}
	
}

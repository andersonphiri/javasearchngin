import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String plain = scanner.nextLine();
        String cipher = scanner.nextLine();
        var cipherMap = getCipherMap(plain, cipher);
        var plainTextToBeCipher = scanner.nextLine();
        var ciphertextToBePlain = scanner.nextLine();
        var plainTextCiphered = encryptPlaintext(plainTextToBeCipher, cipherMap);
        var ciphertextPlain = decipher(ciphertextToBePlain, cipherMap);
        System.out.println(plainTextCiphered);
        System.out.println(ciphertextPlain);

    }
    static String encryptPlaintext(String plainCharSequence, Map<Character, Character> cipherMap) {
        StringBuilder cipherText = new StringBuilder();
        for (Character c :
                plainCharSequence.toCharArray()) {
            cipherText.append(cipherMap.get(c));
        }
        return cipherText.toString();
    }
    static String decipher(String cipherText, Map<Character, Character> cipherMap) {
        StringBuilder plainText = new StringBuilder();
        var decipherMap = reverseMap(cipherMap);
        for (Character c :
                cipherText.toCharArray()) {
            plainText.append(decipherMap.get(c));
        }
        return plainText.toString();
    }

    static Map<Character, Character> getCipherMap(String plainCharSequence, String secureCharSequence) {
        Map<Character, Character> result = new LinkedHashMap<>();
        for (int i = 0; i < plainCharSequence.length(); i++) {
            result.put(plainCharSequence.charAt(i), secureCharSequence.charAt(i));
        }
        return result;
    }
    static Map<Character, Character> reverseMap(Map<Character, Character> toReverse) {
        final Map<Character, Character> result = new LinkedHashMap<>();
        toReverse.forEach((k, v) -> result.put(v, k));
        return result;
    }
}
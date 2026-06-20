public class Main {
    public static void main(String[] args) {
        char[][] letters = {
                {'S', 'o', 'f'},
                {'t', 'w', 'a'},
                {'r', 'e'}
        };
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters[i].length; j++) {
                char ch = Character.toLowerCase(letters[i][j]);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Ratio (V:C) = " + vowels + ":" + consonants);
    }
}
import java.util.Hashtable;

public class Lab5SampleAnswer {

    public static Hashtable<Character, Integer> buildCharacterCountsForString(String s) {
        Hashtable<Character, Integer> characterCounts = new Hashtable<Character, Integer>();

        // Count characters in the string
        for (int i = 0; i < s.length(); i++) {
            Character noteCharacter = new Character(s.charAt(i));
            Integer count = characterCounts.get(noteCharacter);
            count = count == null ? new Integer(1) : new Integer(count.intValue() + 1);

            characterCounts.put(noteCharacter, count);
        }
        return characterCounts;
    }

    public static void main(String[] args) {
        String note = "aakk";
        String magazine = "aaabcdekfghikj";

        magazine = magazine.replaceAll("\\s","");
        note = note.replaceAll("\\s","");

        Hashtable<Character, Integer> noteCharacterCounts = Lab5SampleAnswer.buildCharacterCountsForString(note);

        // For each magazine character, decrement the associated character in the note
        // Note: This is case sensitive
        for(int i = 0; i < magazine.length() && !noteCharacterCounts.isEmpty(); i++) {
            Character magazineCharacter = new Character(magazine.charAt(i));
            Integer count = noteCharacterCounts.get(magazineCharacter);

            if (count != null) {
                Integer newCount = new Integer(count.intValue() - 1);
                if (newCount.intValue() == 0) {
                    noteCharacterCounts.remove(magazineCharacter);
                }
                else {
                    noteCharacterCounts.put(magazineCharacter, newCount);
                }
            }
        }
        System.out.println(noteCharacterCounts.isEmpty());
    }
}
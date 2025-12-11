package tugofwar.mechanic;

public class TugOfWarField implements ITugOfWarMechanic {

    private int position = 0;   // -10 ... 0 ... +10
    private final int minPosition = -10;
    private final int maxPosition = 10;

    @Override
    public void onWrongAnswer() {
        if (position < maxPosition) {
            position++;
        }
    }

    @Override
    public void onCorrectAnswer() {
        if (position > minPosition) {
            position--;
        }
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String renderField() {
        // Panjang field = 21 karakter, index 0..20, tengah = 10
        int length = maxPosition - minPosition + 1; // 21
        char[] field = new char[length];
        for (int i = 0; i < length; i++) {
            field[i] = '-';
        }
        int index = position - minPosition; // geser supaya -10 -> 0, 0 -> 10, +10 -> 20
        field[index] = '0';

        return "PLAYER [" + new String(field) + "] AI";
    }
}

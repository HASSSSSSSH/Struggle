package questions;

public class TNNDay0712 {

    public static void main(String[] args) {
        TNNDay0712 t = new TNNDay0712();
        int numbers[] = new int[]{2, 2, 0};
        int duplication[] = new int[]{-1};
        t.duplicate(numbers, numbers.length, duplication);
        System.out.println(duplication[0]);
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if ((length >> 1) <= 0)
            return false;

        duplication[0] = -1;

        loop:
        for (int i = 0; i < length; i++) {
            if (i == numbers[i])
                continue;

            int temp = numbers[numbers[i]];
            do {
                if (temp == numbers[i]) {
                    duplication[0] = numbers[i];
                    break loop;
                }
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
                temp = numbers[temp];
            } while (i != numbers[i]);
        }

        return duplication[0] != -1;
    }
}

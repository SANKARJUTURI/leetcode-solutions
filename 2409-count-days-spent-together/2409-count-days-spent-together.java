class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int[] M = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aad = Integer.parseInt(arriveAlice.substring(3));
        int aam = Integer.parseInt(arriveAlice.substring(0, 2));
        int add = Integer.parseInt(leaveAlice.substring(3));
        int adm = Integer.parseInt(leaveAlice.substring(0, 2));

        int bad = Integer.parseInt(arriveBob.substring(3));
        int bam = Integer.parseInt(arriveBob.substring(0, 2));
        int bdd = Integer.parseInt(leaveBob.substring(3));
        int bdm = Integer.parseInt(leaveBob.substring(0, 2));

        int a1 = aad, a2 = add, b1 = bad, b2 = bdd;

        for (int i = 0; i < aam - 1; i++) a1 += M[i];
        for (int i = 0; i < adm - 1; i++) a2 += M[i];
        for (int i = 0; i < bam - 1; i++) b1 += M[i];
        for (int i = 0; i < bdm - 1; i++) b2 += M[i];

        int start = Math.max(a1, b1);
        int end = Math.min(a2, b2);

        return Math.max(0, end - start + 1);
    }
}
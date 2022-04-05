package chap02;

class IntArray {
    public static void main(String[] args) {
        int[] a = new int[5];//선언
        a[1] = 37;
        a[2] = 51;
        a[4] = a[1] * 2;//a[4]에 a[1]*2, 곧 74를 대입
        for (int i = 0; i < a.length; i++)
            System.out.println("a[" + i + "] = " + a[i]);
    }
}
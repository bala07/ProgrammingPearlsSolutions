public class SortingBitStrings {

    public static void main(String[] args) {
        String str = "1111110";
        System.out.println("sort(str) = " + new SortingBitStrings().sort(str));
    }
    public String sort(String bitString) {
        char[] str = bitString.toCharArray();
        int j = -1;
        for(int idx = 0; idx < str.length; ++idx) {
            if(str[idx] == '0') {
                ++j;
                swap(str, idx, j);
            }
        }

        return new String(str);
    }

    private void swap(char[] a, int idx1, int idx2) {
        char tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}

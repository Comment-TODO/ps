class L7 {
  public int reverse(int x) {
        String strX = String.valueOf(x);
        StringBuilder reverseStrX = new StringBuilder();

        int minIdx = 0;
        if (strX.charAt(0) == '-') {
            reverseStrX.append('-');
            minIdx = 1;
        }
        for (int i = strX.length() - 1; i >= minIdx; i--) {
            reverseStrX.append(strX.charAt(i));
        }

        try {
            int reverseX = Integer.parseInt(reverseStrX.toString());
            return reverseX;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

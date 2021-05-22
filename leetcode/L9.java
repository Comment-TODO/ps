class L9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        String strX = String.valueOf(x);
        for (int i = 0; i < strX.length() / 2; i++) {
            if (strX.charAt(i) != strX.charAt(strX.length() - 1 - i)) return false;
        }
        
        return true;
    }
}

class L26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int idx = 0;
        int lastVal = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lastVal) {
                lastVal = nums[i];
                nums[++idx] = lastVal;
            }
        }
        
        return idx + 1;
    }
}

class Solution {
    private List<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList());
        iterate(nums, 0, 0);

        return ans;
    }

    private void iterate(int[] nums, int subset, int start) {
        for (int i = start; i < nums.length; i++) {
            subset |= (1 << (nums.length - 1 - i));
            addSubset(nums, subset);
            iterate(nums, subset, i + 1);
            subset &= ~(1 << (nums.length - 1 - i));
        }
    }

    private void addSubset(int[] nums, int subset) {
        // bitwise left point
        int lp = (1 << nums.length);
        int idx = -1;
        List<Integer> l = new ArrayList();

        while (lp > 0) {
            lp >>= 1;
            idx++;
            if ((lp & subset) > 0) {
                l.add(nums[idx]);
            }
        }

        ans.add(l);
    }
}

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            temp.add(nums[i]);      // choose
            used[i] = true;

            backtrack(result, temp, nums, used); // explore

            used[i] = false;        // un-choose
            temp.remove(temp.size() - 1);
        }
    }
}
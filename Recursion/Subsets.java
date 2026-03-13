import java.util.*;

public class Subsets{

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        helper(0,nums,new ArrayList<>(),ans);

        return ans;
    }

    void helper(int index,int[] nums,List<Integer> ds,List<List<Integer>> ans){

        ans.add(new ArrayList<>(ds));

        for(int i=index;i<nums.length;i++){

            ds.add(nums[i]);

            helper(i+1,nums,ds,ans);

            ds.remove(ds.size()-1);
        }
    }
}
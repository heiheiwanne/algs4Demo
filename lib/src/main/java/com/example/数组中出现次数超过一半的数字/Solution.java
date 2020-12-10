package com.example.数组中出现次数超过一半的数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xumingqiang@keepreal.group
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/12/9 2:14 PM
 */
public class Solution {

    //1.排序
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //map
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length / 2;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > n) {
                return num;
            }
        }
        return 0;
    }

    //分治
//    如果元素a是整个数组的众数，那么将数组一分为二，a也必定至少是其中一部分的众数，所以可以将数组分成左右两部分，分别求出左半部分的众数 a1 以及右半部分的众数 a2，随后在 a1 和 a2 中选出正确的众数。
//    分治递归求解，直到所有的子问题都是长度为 1 的数组。长度为 1 的子数组中唯一的数显然是众数，直接返回即可。如果回溯后某区间的长度大于 1，我们必须将左右子区间的值合并。如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。
    public int majorityElement3(int[] nums) {
        return majority(nums, 0, nums.length - 1);
    }

    public int majority(int[] nums, int left, int right) {
        // 如果区间里只有一个元素，那它就是众数
        if(left == right) {
            return nums[left];
        }

        // 分别递归找出左右半边的众数
        int mid = left + (right - left) / 2;
        int leftNum = majority(nums, left, mid);
        int rightNum = majority(nums, mid + 1, right);

        // 左右半边众数一致
        if(leftNum == rightNum) {
            return leftNum;
        }

        // 左右半边众数不一致，数一下哪个多
        int leftNumCount = count(nums, leftNum, left, right);
        int rightNumCount = count(nums, rightNum, left, right);
        return leftNumCount > rightNumCount ? leftNum : rightNum;
    }

    // 两半边数组众数不一样，所以需要数一下哪边多
    public int count(int[] nums, int num, int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++) {
            if(nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    //摩尔投票

    /**
     * 这个思路比较有趣，但限定一定存在众数的情况
     * 把众数记为 +1，把其他数记为 -1，将它们全部加起来，显然和大于 0，从结果本身可以看出众数比其他数多。
     *
     * 维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
     * 遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予candidate，随后我们判断 x：
     * （1）如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
     * （2）如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
     * 在遍历完成后，candidate 即为整个数组的众数。
     *
     * 作者：Sophia_fez
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/pai-xu-map-fen-zhi-boyer-moore-mo-er-tou-piao-wei-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @return
     */
    public int majorityElement4(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]){
                count++;
            }else {
                count--;
                if (count == 0) {  //若count为0，更换候选人
                    candidate = nums[i];
                    count++;
                }
            }
        }
        return candidate;
    }

    /**
     * 解题思路5】位运算
     * 这个解法限定一定存在众数的情况
     * 由于主要元素是数组中多一半的数，那么这个主要元素的每位二进制也是数组每个元素二进制数中多一半的数
     * 统计每位数字的第i位二进制，假如第i位为1比较多，那么将ans的第i位置为1，否则为0
     *
     * 作者：Sophia_fez
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/pai-xu-map-fen-zhi-boyer-moore-mo-er-tou-piao-wei-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int majorityElement5(int[] nums) {
        int ans = 0;
        int n = nums.length;
        //统计每位数字的第i位二进制
        for(int i = 0; i < 32; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                //如果第i位为1
                if((nums[j] >> i & 1) == 1) cnt++;
            }
            //如果所有数字的二进制数中，第i位1比0多
            if(cnt > n / 2) ans ^= (1 << i);
        }
        int C = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == ans) C++;
        }
        if(C <= n / 2) ans = -1;
        return ans;
    }



}

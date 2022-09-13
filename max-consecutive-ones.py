# Leetcode: https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
class Solution:
    # Max # of consecutive 1s
    # Iterate through array
    # Set counter to 0
    # Set max to 0
    # If value is 1 then increment counter and update max
    # If value is not 1 then reset counter
    
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        max_ones = 0
        counter = 0
        
        for v in nums:
            if v == 1:
                counter += 1
                max_ones = max(counter, max_ones)
            else:
                counter = 0
                
        return max_ones

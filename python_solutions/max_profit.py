from typing import List

def solve(prices: List[int]) -> int:
  if 0 <= len(prices) <= 1:
    return 0

  min_index = 0
  cur_min = prices[min_index]
  max_index = cur_max = 0
  
  for i in range(1, len(prices)):
    if prices[i] <= cur_min:
      min_index = i
      cur_min = prices[min_index]
    else:
      diff = prices[i] - cur_min

      if diff > cur_max:
        max_index = i
        cur_max = diff

  return cur_max

# Keep track of cur_min, if we ever drop below that then we reset
# Otherwise, we get the max difference between cur value and cur_min
#
#  
# [7,1,5,3,6,4]
# cur_min = 0
# max_diff = 0
#
#  V
# [7,1,5,3,6,4]
# cur_min = 7
# max_diff = 0
#
#    V
# [7,1,5,3,6,4]
# cur_min = 1
# max_diff = 0
#
#      V
# [7,1,5,3,6,4]
# cur_min = 1
# max_diff = 4
#
#        V
# [7,1,5,3,6,4]
# cur_min = 1
# max_diff = 4, index_max = 2
#
#          V
# [7,1,5,3,6,4]
# cur_min = 1, index_min = 2
# max_diff = 5, index_max = 4
#
#            V
# [7,1,5,3,6,4]
# cur_min = 1, index_min = 2
# max_diff = 5, index_max = 4

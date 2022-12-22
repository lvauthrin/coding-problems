# url: https://leetcode.com/discuss/general-discussion/1734481/apple-top-100-questions
# difficulty: medium
#
# Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
# and return an array of the non-overlapping intervals that cover all the intervals in the input.


def overlap(range_a, range_b):
    max_of_mins = max(range_a[0], range_b[0])
    min_of_maxes = min(range_a[1], range_b[1])

    if max_of_mins <= min_of_maxes:
        return [[min(range_a[0], range_b[0]), max(range_a[1], range_b[1])]]
    else:
        return [range_a, range_b]


def solve(lists):
    merged_lists = [lists[0]]
    cur_index = 0

    for i in range(1, len(lists)):
        result = overlap(merged_lists[cur_index], lists[i])

        if len(result) == 1:
            merged_lists[cur_index] = result[0]
        else:
            cur_index += 1
            merged_lists.append(lists[i])

    return merged_lists

def main(buildings):
    """doc"""
    indexes = []
    cur_max = 0

    for i in range(len(buildings) - 1, -1, -1):
        if buildings[i] > cur_max:
            cur_max = buildings[i]
            indexes.append(i)

    indexes.reverse()
    return indexes


if __name__ == "__main__":
    assert main([1, 2, 3, 4]) == [3]
    assert main([4, 3, 2, 1]) == [0, 1, 2, 3]
    assert main([6, 3, 5, 1]) == [0, 2, 3]
    assert main([6, 3, 2, 4]) == [0, 3]

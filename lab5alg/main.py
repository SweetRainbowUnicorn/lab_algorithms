import math


def get_distance(num1, num2, w):
    return math.sqrt(int(w) ** 2 + (int(num1) - int(num2)) ** 2)


if __name__ == '__main__':
    wire_length = 0
    w = int(input())
    heights = [int(n) for n in input().split()]
    length = heights.__len__()

    max_distance = 0

    way_to_one_old = 0
    way_to_max_old = 0

    first_way = 0
    second_way = 0

    max_to_max = 0
    max_to_one = 0
    one_to_max = 0
    one_to_one = 0

    for i in range(0, length-1):
        way_to_one_old = first_way
        way_to_max_old = second_way

        max_to_max = get_distance(heights[i], heights[i + 1], w)
        max_to_one = get_distance(heights[i], 1, w)
        one_to_max = get_distance(1, heights[i + 1], w)
        one_to_one = get_distance(1, 1, w)

        if(max_to_one + way_to_max_old > one_to_one + way_to_one_old):
            first_way = max_to_one + way_to_max_old
        else:
            first_way = one_to_one + way_to_one_old

        if(one_to_max + way_to_one_old > max_to_max + way_to_max_old):
            second_way = one_to_max + way_to_one_old
        else:
            second_way = max_to_max + way_to_max_old

    if(first_way >= second_way):
        max_distance = first_way
    else:
        max_distance = second_way

    print(max_distance)


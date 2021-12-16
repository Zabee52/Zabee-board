shop_menus = ["만두", "떡볶이", "오뎅", "사이다", "콜라"]
shop_orders = ["오뎅", "콜라", "만두"]

# 이분탐색 사용하기
def is_available_to_order(menus, orders):
    menus.sort()
    orders.sort()

    for order in orders:
        min_idx = 0
        max_idx = len(menus) - 1
        target_idx = (min_idx + max_idx) // 2

        while(min_idx <= max_idx):
            if menus[target_idx] == order:
                break
            elif menus[target_idx] > order:
                max_idx = target_idx - 1
            else:
                min_idx = target_idx + 1
            target_idx = (min_idx + max_idx) // 2

        if min_idx > max_idx:
            return False
    return True


result = is_available_to_order(shop_menus, shop_orders)
print(result)

shop_menus = ["만두", "떡볶이", "오뎅", "사이다", "콜라"]
shop_orders = ["오뎅", "콜라", "만두"]


def is_available_to_order(menus, orders):
    menus_set = set(menus)
    for order in orders:
        if order not in menus_set:
            return False
    return True


result = is_available_to_order(shop_menus, shop_orders)
print(result)

shop_menus = ["만두", "떡볶이", "오뎅", "사이다", "콜라"]
shop_orders = ["오뎅", "콜라", "만두"]


class MaxHeap:
    def __init__(self):
        self.items = [None]

    def insert(self, value):
        self.items.append(value)
        cur_index = len(self.items) - 1

        while cur_index > 1:  # cur_index 가 1이 되면 정상을 찍은거라 다른 것과 비교 안하셔도 됩니다!
            parent_index = cur_index // 2
            if self.items[parent_index] < self.items[cur_index]:
                self.items[parent_index], self.items[cur_index] = self.items[cur_index], self.items[parent_index]
                cur_index = parent_index
            else:
                break

    def delete(self):
        if len(self.items) <= 1:
            return "heap is empty!"
        elif len(self.items) == 2:
            return self.items.pop(-1)
        else:
            # 맨 위 노드와 맨 아래 노드를 교체 후 pop
            self.items[1], self.items[-1] = self.items[-1], self.items[1]
            return_value = self.items.pop()

            current_idx = 1
            # 왼쪽 자식 노드 : 부모의 인덱스 * 2, 오른쪽 자식 노드 : 부모의 인덱스 * 2 + 1
            while current_idx < len(self.items):
                left_child_idx = current_idx * 2
                right_child_idx = current_idx * 2 + 1
                max_idx = current_idx

                if left_child_idx < len(self.items) and self.items[left_child_idx] > self.items[max_idx]:
                    max_idx = left_child_idx

                if right_child_idx < len(self.items) and self.items[right_child_idx] > self.items[max_idx]:
                    max_idx = right_child_idx

                if max_idx == current_idx:
                    break

                self.items[max_idx], self.items[current_idx] = self.items[current_idx], self.items[max_idx]
                current_idx = max_idx

        return return_value  # 8 을 반환해야 합니다.


max_heap = MaxHeap()
max_heap.insert(8)
max_heap.insert(6)
max_heap.insert(7)
max_heap.insert(2)
max_heap.insert(5)
max_heap.insert(4)
print(max_heap.items)  # [None, 8, 6, 7, 2, 5, 4]
print(max_heap.delete())  # 8 을 반환해야 합니다!
print(max_heap.items)  # [None, 7, 6, 4, 2, 5]

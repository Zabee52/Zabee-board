class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

#
class LinkedList:
    def __init__(self, value):
        self.head = Node(value)

    def append(self, value):
        cur = self.head
        while cur.next is not None:
            cur = cur.next
        cur.next = Node(value)

    # 끝에서 k번째 노드의 값 구하기
    def get_kth_node_from_last(self, k):
        # 구현해보세요!
        data = []
        cur = self.head
        while cur is not None:
            data.append(cur)
            cur = cur.next

        return data[-k]

    # 개선 코드

    # def get_kth_node_from_last(self, k):
    #     slow = self.head
    #     fast = self.head
    #
    #     for i in range(k):
    #         fast = fast.next
    #
    #     while fast is not None:
    #         slow = slow.next
    #         fast = fast.next
    #
    #     return slow


linked_list = LinkedList(6)
linked_list.append(7)
linked_list.append(8)

print(linked_list.get_kth_node_from_last(2).data)  # 7이 나와야 합니다!
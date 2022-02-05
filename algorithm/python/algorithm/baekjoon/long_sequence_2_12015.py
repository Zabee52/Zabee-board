# 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
# 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 30, 50} 이고, 길이는 4이다.

# 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
# 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)

# 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

# 1과 달리 N이 100만까지 주어진다.

# 이 문제는 어떻게 푸는거야?

n = int(input())
a = list(map(int, input().split()))

# 수열 저장을 위한 리스트 변수. 최초 if 에서 비교를 위해 0을 줌.
lis = [0]
for ai in a:
    # 1. ai가 lis 의 최댓값(마지막 값)보다 높음 = 수열이 성립. 즉시 append
    if lis[-1] < ai:
        lis.append(ai)
    else:
        # 2. 아닐 경우 lis 로 이분탐색 시작.
        left = 0
        right = len(lis)

        while left < right:
            mid = (right + left) // 2

            # 3. lis[mid]가 ai 보다 작음 = min_len 을 끌어올리고
            if lis[mid] < ai:
                left = mid + 1
            else:
                right = mid
        lis[right] = ai

# 처음에 0을 줬기 때문에 1을 빼줌.
print(len(lis) - 1)

from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        answer = [0] * len(nums)
        
        pre_products: List[int] = []
        product_tracker = 1
        for num in nums:
            product_tracker *= num
            pre_products.append(product_tracker)
            
        post_products: List[int] = []
        product_tracker = 1
        reversed_nums = reversed(nums)
        for num in reversed_nums:
            product_tracker *= num
            post_products.append(product_tracker)
            
        post_products = list(reversed(post_products))
        
        nums_length = len(nums)
        for i in range(nums_length):
            if i == 0:
                answer[i] = post_products[i+1]
            elif i == nums_length-1:
                answer[i] = pre_products[i-1]
            else:
                answer[i] = post_products[i+1] * pre_products[i-1]
                
        return answer
    

testcases = [
    {
        "nums": [1,2,3,4]
    },
    {
        "nums": [-1,1,0,-3,3]
    },
    {
        "nums": [0,0]
    },
    {
        "nums": [1,1]
    },
    {
        "nums": [-1, 1, 2, 2, -3]
    },
]

sol = Solution()

for testcase in testcases:
    print(f"Test Case: {testcase}")
    answer = sol.productExceptSelf(**testcase)
    print(f"Answer: {answer}")
            

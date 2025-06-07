# https://leetcode.com/problems/insert-delete-getrandom-o1/?envType=study-plan-v2&envId=top-interview-150
import random
class RandomizedSet:

    def __init__(self):
        self.set = set()

    def insert(self, val: int) -> bool:
        prev_len = len(self.set)
        self.set.add(val)
        post_len = len(self.set)
        if (prev_len == post_len):
            return False
        else:
            return True

    def remove(self, val: int) -> bool:
        prev_len = len(self.set)
        self.set.discard(val)
        post_len = len(self.set)
        if (prev_len == post_len):
            return False
        else:
            return True

    def getRandom(self) -> int:
        random_number = random.randint(0,len(self.set)-1)
        return list(self.set)[random_number]
        


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()

randomizedSet = RandomizedSet();
print(randomizedSet.insert(1)); # Inserts 1 to the set. Returns true as 1 was inserted successfully.
print(randomizedSet.remove(2)); # Returns false as 2 does not exist in the set.
print(randomizedSet.insert(2)); # Inserts 2 to the set, returns true. Set now contains [1,2].
print(randomizedSet.getRandom()); # getRandom() should return either 1 or 2 randomly.
print(randomizedSet.remove(1)); # Removes 1 from the set, returns true. Set now contains [2].
print(randomizedSet.insert(2)); # 2 was already in the set, so return false.
print(randomizedSet.getRandom()); # Since 2 is the only number in the set, getRandom() will always return 2.
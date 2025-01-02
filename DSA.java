// 1.Tree (binary search tree,inorder,post order,pre order)
class Node:
    def __init__(self,data):
        self.val = data
        self.left = None
        self.right = None

def printInorder(root):
    if root:
        printInorder(root.left)
        print(root.val),
        printInorder(root.right)

def printPostorder(root):
    if root:
        printPostorder(root.left)
        printPostorder(root.right)
        print(root.val),

def printPreorder(root):
    if root:
        print(root.val),
        printPreorder(root.left)
        printPreorder(root.right)

root = Node(4)
root.left = Node(5)
root.left.left = Node(3)
root.left.right = Node(1)
root.right = Node(2)

print("inorder")
printInorder(root)

print("post order")
printPostorder(root)

print("preorder")
printPreorder(root)

// 2. searching BST____________________________
  class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def printPostorder(node):
    if node is None:
        return
    printPostorder(node.left)
    printPostorder(node.right)
    print(node.data, end=" ")

def searchInTree(node, key):
    if node is None:
        return None  # Node not found
    if node.data == key:
        return node  # Node found
    return searchInTree(node.left, key) or searchInTree(node.right, key)  # Efficient search

# Create tree
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.right = Node(6)

print("------- Postorder --------")
printPostorder(root)  # Output: 4 5 2 6 3 1

key = 5
found_node = searchInTree(root, key)

if found_node:
    print("\nNode", key, "is found")
else:
    print("\nNode", key, "is not found")

// 3. Array rotation
    def find_max_min(arr):
    if not arr:
        return None, None  # Handle empty array case
    max_val = arr[0]
    min_val = arr[0]
    for num in arr:
        if num > max_val:
            max_val = num
        if num < min_val:
            min_val = num
    return max_val, min_val

# Example usage
array = [3, 5, 7, 2, 8, -1, 4]
max_val, min_val = find_max_min(array)
print("Maximum:", max_val)
print("Minimum:", min_val)
    -----right rotation--------

    def find_max_min(arr):
    max_val = max(arr)
    min_val = min(arr)
    return max_val, min_val

def rotate_array(arr, d, direction='left'):
    n = len(arr)
    d %= n  # Handle cases where d > n
    if direction == 'left':
        return arr[d:] + arr[:d]
    elif direction == 'right':
        return arr[-d:] + arr[:-d]

# Example usage
array = [10, 20, 30, 40, 50]

# Find max and min
max_val, min_val = find_max_min(array)
print("Maximum:", max_val)
print("Minimum:", min_val)

# Rotate the array
left_rotated = rotate_array(array, 2, 'left')
right_rotated = rotate_array(array, 2, 'right')
print("Left Rotated Array:", left_rotated)
print("Right Rotated Array:", right_rotated)

//     4.Implementing Recursive
// Algorithms
// (a) Factorial
// (b) Fibonacci 
// (c) Tower of Hanoi 
a) 
    def factorial(n):
    if n == 0 or n == 1:  # Base case
        return 1
    return n * factorial(n - 1)  # Recursive call

# Example usage
number = 5
result = factorial(number)
print(f"Factorial of {number} is {result}")
b)

    def fibonacci(n):
    if n == 0:  # Base case 1
        return 0
    if n == 1:  # Base case 2
        return 1
    return fibonacci(n - 1) + fibonacci(n - 2)  # Recursive call

# Example usage
n_terms = 10
print(f"First {n_terms} Fibonacci numbers:")
for i in range(n_terms):
    print(fibonacci(i), end=" ")
c)

    def tower_of_hanoi(n, source, target, auxiliary):
    if n == 1:  # Base case: only one disk
        print(f"Move disk 1 from {source} to {target}")
        return
    # Move n-1 disks from source to auxiliary
    tower_of_hanoi(n - 1, source, auxiliary, target)
    # Move the nth disk from source to target
    print(f"Move disk {n} from {source} to {target}")
    # Move the n-1 disks from auxiliary to target
    tower_of_hanoi(n - 1, auxiliary, target, source)

# Example usage
num_disks = 3
tower_of_hanoi(num_disks, 'A', 'C', 'B')

    
// 5. linked list all parts 

    class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class SSL:
    def __init__(self):
        self.head = None

    def insertnext(self, data):
        p = Node(data)
        if not self.head:
            self.head = p
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = p

    def display(self):
        temp = self.head
        while temp:
            print(temp.data, end="->")
            temp = temp.next
        print("None")

    def merge(self, L2):
        dummy = Node(-1)
        tail = dummy
        p1 = self.head
        p2 = L2.head

        # Merging the two lists
        while p1 and p2:
            if p1.data <= p2.data:
                tail.next = Node(p1.data)  # Create a new node for the merged list
                p1 = p1.next
            else:
                tail.next = Node(p2.data)  # Create a new node for the merged list
                p2 = p2.next
            tail = tail.next

        # Append remaining elements
        while p1:
            tail.next = Node(p1.data)
            p1 = p1.next
            tail = tail.next

        while p2:
            tail.next = Node(p2.data)
            p2 = p2.next
            tail = tail.next

        # Create a new SSL object for the result
        result = SSL()
        result.head = dummy.next
        return result

    def reversal(self):
        p = self.head
        q = None
        r = None
        while p:
            r = q
            q = p
            p = p.next
            q.next = r
        self.head = q


    def concat(self, L2):
        if not self.head:  # If L1 is empty, return L2
            return L2
        if not L2.head:  # If L2 is empty, return L1
            return self

        temp = self.head
        while temp.next:  # Traverse to the end of L1
            temp = temp.next
        temp.next = L2.head  # Link the last node of L1 to the head of L2

        result = SSL()
        result.head = self.head  # The concatenated list starts from L1's head
        return result


# Example Usage
L1 = SSL()
L2 = SSL()

L1.insertnext(1)
L1.insertnext(5)
L1.insertnext(3)
L1.insertnext(7)

L2.insertnext(2)
L2.insertnext(4)
L2.insertnext(6)
L2.insertnext(10)

print("Before merge:")
L1.display()
L2.display()

# Merged Sorted List
print("Merged Sorted List:")
merged_list = L1.merge(L2)
merged_list.display()

print("After merge:")
L1.display()  # Ensure L1 is unchanged
L2.display()  # Ensure L2 is unchanged

print("Concatenated List:")
concatenated_list = L1.concat(L2)
concatenated_list.display()

print("After concatenation:")
L1.display()  # Ensure L1 is updated
L2.display()  # Ensure L2 is unchanged



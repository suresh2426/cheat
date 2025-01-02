#******Breadth First Search Trees(BFS)******

from collections import deque

def bfs(vtx, adjacency_matrix, n):
    queue = deque()
    visited = [0] * n

    # Initial
    print(f"Vertex {vtx}: ", end="")
    print(vtx, end=", ")
    visited[vtx] = 1
    queue.append(vtx)

    # Explore
    while queue:
        u = queue.popleft() 
        for v in range(n):  
            if adjacency_matrix[u][v] == 1 and visited[v] == 0:  
                print(v, end=", ")
                visited[v] = 1
                queue.append(v)
    print()


adjacency_matrix = [
    [0, 0, 0, 0, 0, 0, 0,0],
    [0, 0, 1, 1, 1, 0, 0,0],
    [0, 1, 0, 1, 0, 0, 0,0],
    [0, 1, 1, 0, 1, 1, 0,0],
    [0, 1, 0, 1, 0, 1, 0,0],
    [0, 0, 0, 1, 1, 0, 1,1],
    [0, 0, 0, 0, 0, 1, 0,0],
    [0, 0, 0, 0, 0, 1, 0,0]
]

# Perform BFS
print("BFS from Vertex 1:")
bfs(1, adjacency_matrix, len(adjacency_matrix))

print("BFS from Vertex 4:")
bfs(4, adjacency_matrix, len(adjacency_matrix))


******Depth First Search Trees(DFS)******

def dfs(u, adjacency_matrix, visited):
   
    if not visited[u]:
        print(u, end=", ")  
        visited[u] = 1  

        
        for v in range(len(adjacency_matrix[u])):
            if adjacency_matrix[u][v] == 1 and not visited[v]:
                dfs(v, adjacency_matrix, visited)


adjacency_matrix = [
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 1, 1, 0, 0, 0],
    [0, 1, 0, 1, 0, 0, 0, 0],
    [0, 1, 1, 0, 1, 1, 0, 0],
    [0, 1, 0, 1, 0, 1, 0, 0],
    [0, 0, 0, 1, 1, 0, 1, 1],
    [0, 0, 0, 0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0, 1, 0, 0],
]


visited = [0] * len(adjacency_matrix)


print("DFS from Vertex 4:")
dfs(4, adjacency_matrix, visited)
print()


#********Binary Search Tree(BST)*******

# Binary Search Tree (BST)

class Node:
    def __init__(self, data):
        self.data = data
        self.lchild = None
        self.rchild = None


class BST:
    def __init__(self):
        self.root = None

    def search(self, key):
        t = self.root
        while t is not None:
            if key == t.data:
                return t
            elif key < t.data:
                t = t.lchild
            else:
                t = t.rchild
        return None

    def recSearch(self, key, t):  # Recursive search
        if t is None:
            return None
        if key == t.data:
            return t
        elif key < t.data:
            return self.recSearch(key, t.lchild)
        else:
            return self.recSearch(key, t.rchild)

    def insert_with_tail_pointer(self, key):
        t = self.root
        r = None  # Tail pointer
        while t is not None:
            r = t
            if key == t.data:
                print(f"Key {key} already exists in the tree.")
                return t
            elif key < t.data:
                t = t.lchild
            else:
                t = t.rchild

        new_node = Node(key)

        if r is None:
            self.root = new_node
        elif key < r.data:
            r.lchild = new_node
        else:
            r.rchild = new_node

    def insert_recursive(self, key, t):  # Recursive insert
        if t is None:
            t = Node(key)
            return t
        if key < t.data:
            t.lchild = self.insert_recursive(key, t.lchild)
        elif key > t.data:
            t.rchild = self.insert_recursive(key, t.rchild)
        return t

    def delete_node(self, key):
        t = self.root
        parent = None

        while t is not None and t.data != key:
            parent = t
            if key < t.data:
                t = t.lchild
            else:
                t = t.rchild

        if t is None:
            print(f"Key {key} not found in the tree.")
            return

        if t.lchild is None and t.rchild is None:
            if t == self.root:  # Special case for root
                self.root = None
            elif parent.lchild == t:
                parent.lchild = None
            else:
                parent.rchild = None

        elif t.lchild is None or t.rchild is None:
            child = t.lchild if t.lchild else t.rchild
            if t == self.root:
                self.root = child
            elif parent.lchild == t:
                parent.lchild = child
            else:
                parent.rchild = child

        else:
            succ_parent = t
            succ = t.rchild
            while succ.lchild:
                succ_parent = succ
                succ = succ.lchild

            t.data = succ.data

            if succ_parent.lchild == succ:
                succ_parent.lchild = succ.rchild
            else:
                succ_parent.rchild = succ.rchild

    def delete_node_recursive(self, key, node):
        if node is None:
            return node

        if key < node.data:
            node.lchild = self.delete_node_recursive(key, node.lchild)
        elif key > node.data:
            node.rchild = self.delete_node_recursive(key, node.rchild)
        else:
            if node.lchild is None and node.rchild is None:
                return None

            if node.lchild is None:
                return node.rchild
            elif node.rchild is None:
                return node.lchild

            succ = self.get_min_value_node(node.rchild)
            node.data = succ.data  # Replace node's data with successor's data
            node.rchild = self.delete_node_recursive(succ.data, node.rchild)  # Delete successor

        return node

    def get_min_value_node(self, node):
        current = node
        while current.lchild is not None:
            current = current.lchild
        return current


def inorder(t):
    if t is not None:
        inorder(t.lchild)
        print(t.data, end=" ")
        inorder(t.rchild)


# Test BST functionality
def test_bst():
    bst = BST()

    print("Inserting nodes...")
    bst.insert_with_tail_pointer(50)
    bst.insert_with_tail_pointer(30)
    bst.insert_with_tail_pointer(70)
    bst.insert_with_tail_pointer(20)
    bst.insert_with_tail_pointer(40)
    bst.root = bst.insert_recursive(60, bst.root)
    bst.root = bst.insert_recursive(80, bst.root)
    print("In-order after insertions (should be sorted):")
    inorder(bst.root)
    print()

    print("Testing search...")
    print("Search 40 (iterative):", "Found" if bst.search(40) else "Not Found")
    print("Search 100 (iterative):", "Found" if bst.search(100) else "Not Found")
    print("Search 30 (recursive):", "Found" if bst.recSearch(30, bst.root) else "Not Found")
    print("Search 90 (recursive):", "Found" if bst.recSearch(90, bst.root) else "Not Found")

    print("Deleting nodes...")
    bst.delete_node(20)  # Leaf node
    bst.delete_node(50)  # Root node
    bst.root = bst.delete_node_recursive(70, bst.root)  # Internal node with recursive delete
    print("In-order after deletions:")
    inorder(bst.root)
    print()


# Call the test function
test_bst()


**************Control Statement*****************

#If-Else Example
number = int(input("Enter a number: "))
if number > 0:
    print("The number is positive.")
elif number < 0:
    print("The number is negative.")
else:
    print("The number is zero.")




# For Loop Example
print("\nFor Loop Example:")
for i in range(5):
    print("Iteration", i)



# While Loop Example
print("\nWhile Loop Example:")
count = 0
while count < 3:
    print("Count is:", count)
    count += 1


#*******************Libraries**************************



from collections import deque, defaultdict, Counter 
import heapq


#1. Deque Example
print("Deque Example:")
dq = deque()
dq.append(1)
dq.append(2)
dq.appendleft(0)
print("Deque after appends:", dq)
dq.pop()
dq.popleft()
print("Deque after pops:", dq)


#2. Default Dictionary Example
print("Default Dictionary Example:")
dd=defaultdict(int) # Default value is 8 for integers
dd['a'] += 1
dd['b'] += 2
print("Default Dictionary:", dd)


#3. Heap Example
print("Heap Example:")
heap= []
heapq.heappush (heap, 3)
heapq.heappush (heap, 1)
heapq.heappush (heap, 2)
print("Heap after pushes:", heap)
heapq.heappop(heap)
print("Heap after pop:", heap)


#4. Counter Example
print("Counter Example:")
ctr = Counter([1, 2, 2, 3, 3, 3])
print("Counter:", ctr)



# LinkedList

#************Singly Linked List**************

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None

    def traverse(self):
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")

    def insert(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = new_node

    def delete(self, data):
        if not self.head:
            print("List is empty")
            return

        if self.head.data == data:
            self.head = self.head.next
            return

        temp = self.head
        while temp.next and temp.next.data != data:
            temp = temp.next

        if temp.next:
            temp.next = temp.next.next
        else:
            print(f"data {data} not found")



sll = SinglyLinkedList()

sll.insert(10)
sll.insert(20)
sll.insert(30)

print("Linked List:")
sll.traverse()

sll.delete(20)
print("After deleting 20:")
sll.traverse()

# *****Circular Linked List********

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class CircularLinkedList:
    def __init__(self):
        self.head = None

    def traverse(self):
        if not self.head:
            print("List is empty")
            return

        temp = self.head
        while True:
            print(temp.data, end=" -> ")
            temp = temp.next
            if temp == self.head:
                break
        print("(back to head)")

    def insert(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            new_node.next = self.head
        else:
            temp = self.head
            while temp.next != self.head:
                temp = temp.next
            temp.next = new_node
            new_node.next = self.head

    def delete(self, data):
        if not self.head:
            print("List is empty")
            return

        if self.head.data == data:
            if self.head.next == self.head:  # Only one node
                self.head = None
            else:
                temp = self.head
                while temp.next != self.head:
                    temp = temp.next
                temp.next = self.head.next
                self.head = self.head.next
            return

        temp = self.head
        while temp.next != self.head and temp.next.data != data:
            temp = temp.next

        if temp.next == self.head:
            print(f"data {data} not found")
        else:
            temp.next = temp.next.next


cll = CircularLinkedList()

cll.insert(10)
cll.insert(20)
cll.insert(30)

print("Circular Linked List:")
cll.traverse()

cll.delete(20)
print("After deleting 20:")
cll.traverse()


# Queue

#*********** Basic Operation **********

class Queue:
  def __init__(self):
    self.q = []
    self.front = -1
    self.rear = -1

  def enqueue(self,data):
    self.rear +=1
    self.q.append(data)
    print(f"{data} added to the queue ")

  def dequeue(self):
    if self.rear == self.front:
      print("Queue is empty")
    else:
      self.front += 1
      self.q.remove(self.q[0])

  def printQ(self):
    print(self.q)


Q = Queue()
Q.enqueue(20)
Q.enqueue(10)
Q.enqueue(50)
Q.enqueue(40)

Q.printQ();

print("Queue after Dequeue")
Q.dequeue()
Q.printQ();


# ********Circular linked list **************

class CircularQueue:
    def __init__(self, size):
        self.size = size
        self.q = [None] * size
        self.front = -1
        self.rear = -1

    def enqueue(self, data):
        if (self.rear + 1) % self.size == self.front:
            print("Queue is full")
        else:
            if self.front == -1:  # If the queue is empty
                self.front = 0
            self.rear = (self.rear + 1) % self.size
            self.q[self.rear] = data
            print(f"{data} added to the queue")

    def dequeue(self):
        if self.front == -1:
            print("Queue is empty")
        else:
            removed_item = self.q[self.front]
            if self.front == self.rear:  # Only one element in the queue
                self.front = self.rear = -1
            else:
                self.front = (self.front + 1) % self.size
            print(f"{removed_item} removed from the queue")

    def printQ(self):
        if self.front == -1:
            print("Queue is empty")
        else:
            i = self.front
            while i != self.rear:
                print(self.q[i], end=" -> ")
                i = (i + 1) % self.size
            print(self.q[self.rear])



Q = CircularQueue(5)
Q.enqueue(20)
Q.enqueue(10)
Q.enqueue(50)
Q.enqueue(40)

Q.printQ()

print("Queue after Dequeue")
Q.dequeue()
Q.printQ()



***** Factorial *****

+++++ Recursive +++++

  def factorial(n):
      if n == 0 or n == 1:
          return 1
      else:
          return n * factorial(n - 1)

  print(factorial(5)) 

++++++ iterative +++++++

  n = int(input("Enter the number: "))
  fact = 1
  for i in range(1,n+1,1):
    fact = fact*i

  print(fact)

********* fibonacci *********

++++++++++ Recursion ++++++++++

def fibonacci_recursive(n):
    if n <= 1:
        return n
    else:
        return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2)

print(fibonacci_recursive(5))


++++++++++ Iterative ++++++++++++

def fibonacci(n):
  a = 0
  b = 1
  print(a)
  print(b)
  
  for i in range(2,n):
    c = a+b
    print(c)
    a = b
    b = c

fibonacci(20)



# ***** TowerofHentai ******

# +++ Recursion ++++

def TowerOfHanoi(s, d, n):
    t = 6 - s - d
    if n == 1:
        print(f"Disk moving from {s} to {d}")
    else:
        TowerOfHanoi(s, t, n - 1)
        print(f"Disk moving from {s} to {d}")
        TowerOfHanoi(t, d, n - 1)

TowerOfHanoi(1, 3, 3)



# *********Stack Operations**********
#Code: 
stack = []

def push():
    ele = input("Enter the element to push: ")
    stack.append(ele)
    print("Stack after push:", stack)

def pop_ele():
    if not stack:  # Check if the stack is empty
        print("Stack is empty, nothing to pop.")
    else:
        ele = stack.pop()
        print("Removed element:", ele)
        print("Stack after pop:", stack)

def peek():
    if not stack:
        print("Stack is empty, no elements to peek.")
    else:
        print("Top element is:", stack[-1])

# Main loop for user input
while True:
    print("\n1. Push")
    print("2. Pop")
    print("3. Peek")
    print("4. Quit")

    try:
        choice = int(input("Enter your choice (1/2/3/4): "))
    except ValueError:
        print("Invalid input! Please enter a number between 1 and 4.")
        continue

    if choice == 1:
        push()
    elif choice == 2:
        pop_ele()
    elif choice == 3:
        peek()
    elif choice == 4:
        print("Exiting...")
        break
    else:
        print("Invalid choice! Please select 1, 2, 3, or 4.")




# *********Stack using Linked List**********
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.top = None

    def push(self, data):
        new_node = Node(data)
        new_node.next = self.top
        self.top = new_node
        print(f"Pushed: {data}")

    def pop(self):
        if not self.top:
            print("Stack is empty!")
            return None
        popped_data = self.top.data
        self.top = self.top.next
        print(f"Popped: {popped_data}")
        return popped_data

    def peek(self):
        if not self.top:
            print("Stack is empty!")
            return None
        print(f"Top element: {self.top.data}")
        return self.top.data

    def display(self):
        if not self.top:
            print("Stack is empty!")
            return
        current = self.top
        print("Stack elements:", end=" ")
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")



#***************** Bubble Sort ********************
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:  # Compare adjacent elements
                arr[j], arr[j + 1] = arr[j + 1], arr[j]  # Swap if needed

arr = [64, 34, 25, 12, 22, 11, 90]
bubble_sort(arr)
print("Sorted array is:", arr)





#*************** Insertion Sort ******************
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key


arr = [64, 34, 25, 12, 22, 11, 90]
insertion_sort(arr)
print("Sorted array is:", arr)




#**************Heap Sort*******************
def heap_sort(arr):
    # Build a max heap
    for i in range(len(arr) // 2 - 1, -1, -1):
        # For each parent node, heapify its subtree
        heapify(arr, len(arr), i)

    # Extract elements from the heap one by one
    for i in range(len(arr) - 1, 0, -1):
        # Move the current root to the end (swap)
        arr[0], arr[i] = arr[i], arr[0]
        # Heapify the root
        heapify(arr, i, 0)

    return arr

def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    # Check if left child is larger than root
    if left < n and arr[left] > arr[largest]:
        largest = left

    # Check if right child is larger than largest so far
    if right < n and arr[right] > arr[largest]:
        largest = right

    # If largest is not root, swap and heapify the affected subtree
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

# Example Usage
arr = [12, 11, 13, 5, 6, 7]
print("Sorted array is:", heap_sort(arr))



#**************Heapify******************
def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    # Check if left child is larger than root
    if left < n and arr[left] > arr[largest]:
        largest = left

    # Check if right child is larger than largest so far
    if right < n and arr[right] > arr[largest]:
        largest = right

    # If largest is not root, swap and heapify the affected subtree
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

# Example Usage for Heapify
arr = [12, 11, 13, 5, 6, 7]
heapify(arr, len(arr), 0)
print("Array after heapify:", arr)





#************ insert code Heap ********************
def insert(heap, key):
  heap.append(key)
  i = len(heap) - 1

  while i>0:
    parent = (i-1)//2
    if heap[i] <= heap[parent]:
      break
    heap[i], heap[parent] = heap[parent], heap[i]
    i = parent

A = [50, 30, 20, 15, 10, 8, 16]
insert(A,60)
print(A)




# ************ deletion code Heap ****************
def delete(heap):
  if len(heap) == 0:
    print("Heap is empty")
    return None

  heap[0], heap[-1] = heap[-1], heap[0]

  max_value = heap.pop()

  i = 0
  n = len(heap)

  while True:
    left = 2 * i + 1
    right = 2 * i + 2
    largest = i

    if left < n and heap[left] > heap[largest]:
      largest = left

    if right < n and heap[right] > heap[largest]:
      largest = right

    if largest != i:
      heap[i], heap[largest] = heap[largest], heap[i]
      i = largest
    else:
      break

  return max_value


A = [10,9,8,2,4,5,7]
H = []

for value in A:
  insert(H, value)
print("Initial Max-Heap:", H)

while H:
  max_elem = delete(H)
  print(f"Deleted: {max_elem}, Remaining Heap: {H}")




#*****************Quick Sort****************
def partition(A, low, high):
    pivot = A[high]
    i = low - 1

    for j in range(low, high):
        if A[j] < pivot:
            i += 1
            A[i], A[j] = A[j], A[i]

    # Place the pivot in its correct position
    A[i + 1], A[high] = A[high], A[i + 1]
    return i + 1

def quick_sort(A, low, high):
    if low < high:
        # Partition the array and get the pivot index
        pi = partition(A, low, high)

        # Recursively sort the left and right parts
        quick_sort(A, low, pi - 1)  # Left side
        quick_sort(A, pi + 1, high)  # Right side

# Example usage
A = [18, 5, 8, 12, 15, 6, 9, 16, 17, 0]
quick_sort(A, 0, len(A) - 1)
print("Sorted array:", A)









#**********Radix Sort*****************
def largest (arr):
  n = len(arr)
  max = arr[0]
  for i in range(1, n):
    if(arr[i] > max):
      max = arr[i]
  return max


# Radix sort
def radixSort(a):
  max_val = largest(a)
  pos = 1

  while max_val // pos > 0:
    countSort(a, pos)
    pos *= 10

def countSort(a, pos):
  n = len(a)
  b = [0] * n
  count = [0] * 10

  for i in range(n):
    digit = (a[i] // pos) % 10;
    count[digit] += 1

  for i in range(1,10):
    count[i] += count[i-1]

  for i in range(n-1, -1, -1):
    digit = (a[i] // pos) % 10;
    b[count[digit]-1] = a[i]
    count[digit] -= 1

  for i in range(n):
    a[i] = b[i]

myA = [786,543,675,45,362,678,435,457]
radixSort(myA)
print(myA)




#***************Linear Search************
#------------iterative method-------------
def linear_search_iterative(arr, target):
    for i in range(len(arr)):
        if arr[i] == target:
            return i  # Return the index if found
    return -1  # Return -1 if not found



#-----------recursive method-------------
def linear_search_recursive(arr, target, index=0):
    if index >= len(arr):
        return -1  # Return -1 if not found
    if arr[index] == target:
        return index  # Return the index if found
    return linear_search_recursive(arr, target, index + 1)




#***************Binary Search************
#-------------iterative method------------
import math as mp
arr = [1, 2, 3, 4, 5]
ui = len(arr) - 1
li = 0
ele = 5
while(li <= ui):
    mid = mp.floor((li + ui) / 2)
    if(arr[mid] == ele):
        print("element is at ", mid)
        break
    elif(arr[mid] < ele):
        li = mid + 1  # Update lower index
    else:
        ui = mid - 1  # Update upper index
else:
    print("element not found")




#-------------recursive method------------
import math as mp

def binary_search(arr, li, ui, ele):
    if li <= ui:
        mid = mp.floor((li + ui) / 2)
        if arr[mid] == ele:
            print("Element is at", mid)
            return
        elif arr[mid] < ele:
            binary_search(arr, mid + 1, ui, ele)  # Search in the right half
        else:
            binary_search(arr, li, mid - 1, ele)  # Search in the left half
    else:
        print("Element not found")

arr = [1, 2, 3, 4, 5]
ele = 2
binary_search(arr, 0, len(arr) - 1, ele)

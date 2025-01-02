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

1.Tree (binary search tree,inorder,post order,pre order)
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

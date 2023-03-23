class TreeNode(var tag: String, var attributes: MutableMap<String,String> = mutableMapOf()) {
    var parent: TreeNode? = null
        private set
    var children: MutableList<TreeNode> = mutableListOf()
        private set
    var depth = 0
        private set
    var index = 0
        private set
    var lowestChildIndex = 0
        private set
    fun addChild(tag: String, attributes: MutableMap<String, String>) {
        val childNode = TreeNode(tag, attributes)
        childNode.parent = this
        childNode.index = lowestChildIndex
        lowestChildIndex++
        childNode.depth = depth + 1
        children.add(childNode)
    }
}
class Tree {
    var root: TreeNode? = null
    fun inOrderTraversal() {
        inOrderTraversalHelper(root)
    }
    private fun inOrderTraversalHelper(currentNode: TreeNode?) {
        if (currentNode == null) {
            return
        }
        for (childNode in currentNode.children) {
            if (childNode != null) {
                print(childNode.tag)
            }
            inOrderTraversalHelper(childNode)
        }
    }
}

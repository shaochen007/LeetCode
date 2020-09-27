package subject538

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *            5
 *           / \
 *          2  13
 *
 * 输出: 转换为累加树:
 *            18
 *           /  \
 *          20  13
 */
fun main() {
    val root = TreeNode(5).apply {
        left = TreeNode(3)
        right = TreeNode(13)
    }
    convertBST(root)
}

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
fun convertBST(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }

    convertBST(root.right)
    sum += root.`val`
    root.`val` = sum
    convertBST(root.left)

    return root
}

var sum = 0

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
public class Leetcode199 {
    class Solution {
        class LayerNode{
            TreeNode node;
            int layer;
            LayerNode(TreeNode n, int l){
                node = n;
                layer = l;
            }
        }
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            // init the queue
            List<LayerNode> q = new ArrayList<>();
            q.add(new LayerNode(root, 0));

            while(q.size() != 0){
                // pop out
                LayerNode cur = q.remove(0);
                if(cur.node == null) continue;
                addLayerNode(ans, cur.layer, cur.node.val);
                // add new node
                q.add(new LayerNode(cur.node.left, cur.layer + 1));
                q.add(new LayerNode(cur.node.right, cur.layer + 1));
            }
            return ans;
        }

        private void addLayerNode(List<Integer> ans, int layer, int val){
            if(layer < ans.size()){
                ans.set(layer, val);
            }else{
                ans.add(val);
            }
        }
    }
}

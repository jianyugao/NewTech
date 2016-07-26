        List<String> path = new LinkedList<String>();
        if(root==null) return path;
        if(root.left==null&&root.right==null){
            
        path.add(String.valueOf(root.val));
        return path;
        }
        if (root.left!=null) {
			treepathList(String.valueOf(root.val), root.left, path);
		}
		if (root.right!=null) {
			treepathList(String.valueOf(root.val), root.right, path);
		}
        return path;
        
    }
    public static void treepathList(String a, TreeNode root,List<String> list){
		String temp= a+"->"+root.val;

			if (root.left!=null) {
				
				treepathList(String.valueOf(root.val), root.left, list);
			}
			if (root.right!=null) {
				treepathList(String.valueOf(root.val), root.right, list);
			}
			if(root.left==null&&root.right==null){
				
				list.add(temp);
				return;
			}
 
  
}
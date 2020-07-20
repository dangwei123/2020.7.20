给定一个无向图graph，当这个图为二分图时返回true。

如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。

graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-graph-bipartite
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph.length==0) return false;
        int[] status=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(status[i]==0){
                if(!bfs(i,status,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int index,int[] status,int[][] graph){
        Queue<Integer> queue=new LinkedList<>();
        status[index]=1;
        queue.add(index);
        while(!queue.isEmpty()){
            int j=queue.poll();
            for(int i:graph[j]){
                if(status[i]==status[j]){
                    return false;
                }
                if(status[i]==0){
                    status[i]=-1*status[j];
                    queue.offer(i);
                }
            }
        }
        return true;
    }

}
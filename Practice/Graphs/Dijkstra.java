class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        int []dist=new int[v];
        Set<Integer> visited=new HashSet<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new int[]{src,0});
        
        dist[src]=0;
        
        while(visited.size()!=v) {
            if(pq.isEmpty())
                break;
            
            int u=pq.poll()[0];
            
            if(visited.contains(u)) continue;
            
            visited.add(u);
            
            for(int i=0;i<adj.get(u).size();i++) {
                List<Integer> curr=adj.get(u).get(i);
                int currCost=curr.get(1),currNode=curr.get(0);
                
                if(!visited.contains(currNode)) {
                    int newDist=dist[u]+currCost;
                    
                    if(newDist<dist[currNode])
                        dist[currNode]=newDist;
                        
                    pq.add(new int[]{currNode,dist[currNode]});
                }
            }
        }
        return dist;
    }
}
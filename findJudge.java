class Solution {
    public int findJudge(int N, int[][] trust) {
        HashSet<Integer> s1 = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        if (trust.length==0 && N==1) return N;
        for (int i=0;i<trust.length;i++) {
            s1.add(trust[i][0]);
            
            if (map.containsKey(trust[i][0])) {
                map.remove(trust[i][0]);
            }
            if (!s1.contains(trust[i][1])) {
                map.put(trust[i][1],map.getOrDefault(trust[i][1],0)+1);
            }
        }
        if (map.size()==1) { 
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == N-1) {
                    return e.getKey();
                }
            }
        }
        return -1;
    }
}

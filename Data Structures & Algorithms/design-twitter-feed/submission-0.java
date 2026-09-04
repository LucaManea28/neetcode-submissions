class Twitter {
    class Pair{
        int id;
        int time;
        public Pair(int id, int time){
            this.id = id;
            this.time = time;
        }
    }
    static int count = 0;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Pair>> postMap;
    public Twitter() {
        followMap = new HashMap<>();
        postMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!postMap.containsKey(userId))
            postMap.put(userId, new ArrayList<>());
        postMap.get(userId).add(new Pair(tweetId, count));
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.time, b.time));
        Set<Integer> userToIterate = new HashSet<>();
        userToIterate.add(userId);
        if(followMap.containsKey(userId))
            userToIterate.addAll(followMap.get(userId));
        for(int followersId: userToIterate){
            if(postMap.containsKey(followersId)){
                for(Pair post: postMap.get(followersId)){
                    heap.add(post);
                    if(heap.size() > 10)
                        heap.poll();
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!heap.isEmpty()){
            result.add(0, heap.poll().id); // ca sa inversam ordinea
        }
        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId))
            followMap.put(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followMap.containsKey(followerId))
            return;
        followMap.get(followerId).remove(followeeId);
    }
}

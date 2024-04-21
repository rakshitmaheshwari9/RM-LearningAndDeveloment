package Heaps.HardProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Twitter {

    List<Pair> list;
    Map<Integer, List<Integer>> mp;

    public Twitter() {
        this.list = new ArrayList<>();
        this.mp = new HashMap<>();
    }


    public void postTweet(int userId, int tweetId) {
        list.add(new Pair(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();

        List<Integer> followeeIdList;
        if(!mp.containsKey(userId))  {
            followeeIdList=new ArrayList<>();
        } else {
            followeeIdList = mp.get(userId);
        }
        followeeIdList.add(userId);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (followeeIdList.contains(list.get(i).userId)) {
                ans.add(list.get(i).tweetId);
                if (ans.size() >= 10) {
                    return ans;
                }
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!mp.containsKey(followerId)) {
            mp.put(followerId, new ArrayList<>());
        }
        mp.get(followerId).add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
        if(!mp.containsKey(followerId)) return ;
        mp.get(followerId).remove(mp.get(followerId).indexOf(followeeId));
    }

    class Pair {
        int userId;
        int tweetId;

        Pair(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;

        }

    }
}

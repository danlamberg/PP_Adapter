public class TwitterAPI {
    public static class TwitterPost {
        public String tweetText;
        public String mediaId;
    }

    public String postTweet(TwitterPost post) {
        System.out.println("Twitter - Publicanco Tweet: " + post.tweetText);
        return "TWT-" + System.currentTimeMillis();
    }
}

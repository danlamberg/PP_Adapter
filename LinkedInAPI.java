public class LinkedInAPI {
    public static class LinkedInShare {
        public String postContent;
        public String acessToken;
    }

    public boolean sharePost(LinkedInShare share) {
        System.out.println("LinkedInAPI - Compartilhamento post: " + share.postContent);
        return true;
    }
}

public class InstagramAPI {
    public static class InstagramMedia {
        public String caption;
        public String mediaBytes;
    }

    public int uploadMedia(InstagramMedia media) {
        System.out.println("Instagram - Uploading Mídia com legenda: " + media.caption);
        return 201;
    }
}

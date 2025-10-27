public class TikTokAPI {
    public static class TikTokUploadReport {
        public boolean status;
        public long internalId;
    }

    public static class TikTokVideo {
        public byte videoData;
        public String description;
    }

    public TikTokUploadReport publishVideo(TikTokVideo video) {
        System.out.println("TikTok - Publicando video com descrição: " + video.description);
        TikTokUploadReport report = new TikTokUploadReport();
        report.status = true;
        report.internalId = System.currentTimeMillis();
        return report;
    }
}

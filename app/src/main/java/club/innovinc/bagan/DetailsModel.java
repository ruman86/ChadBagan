package club.innovinc.bagan;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class DetailsModel {
        @SerializedName("srl")
        @Expose
        private String srl;
        @SerializedName("subject")
        @Expose
        private String subject;
        @SerializedName("conpreview")
        @Expose
        private String conpreview;
        @SerializedName("contentdetails")
        @Expose
        private String contentdetails;

        public String getSrl() {
            return srl;
        }

        public void setSrl(String srl) {
            this.srl = srl;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getConpreview() {
            return conpreview;
        }

        public void setConpreview(String conpreview) {
            this.conpreview = conpreview;
        }

        public String getContentdetails() {
            return contentdetails;
        }

        public void setContentdetails(String contentdetails) {
            this.contentdetails = contentdetails;
        }

    }

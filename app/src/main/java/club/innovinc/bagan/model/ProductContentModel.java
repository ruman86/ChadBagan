package club.innovinc.bagan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ProductContentModel {

        @SerializedName("srl")
        @Expose
        private String srl;
        @SerializedName("productname")
        @Expose
        private String productname;
        @SerializedName("productdesc")
        @Expose
        private String productdesc;
        @SerializedName("product_image")
        @Expose
        private String productImage;

        public String getSrl() {
            return srl;
        }

        public void setSrl(String srl) {
            this.srl = srl;
        }

        public String getProductname() {
            return productname;
        }

        public void setProductname(String productname) {
            this.productname = productname;
        }

        public String getProductdesc() {
            return productdesc;
        }

        public void setProductdesc(String productdesc) {
            this.productdesc = productdesc;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

    }


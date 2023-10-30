package ra.constant;

public class Containt {
    public static final String ADMIN_CODE = "1010101010";
    public static class Role {
        public static final int ADMIN = 1;
        public static final int USER = 2;

    }
    public static class Status {
        public static final boolean ACTIVE = true;
        public static final boolean INACTIVE = false;

    }

    public static  class Importance {
        public static final boolean BLOCK = false;
        public static final boolean OPEN = true;

    }

    public static class FIlePath {
        public static final String COMMON_PATH = "data";
        public static final String USER_FILE = "/user.dat";
        public static final String PRODUCT_FILE = "/product";
        public static final String CATEGORY_FILE  = "/category";
        public static final String ODER_FILE  = "/order";
    }

}

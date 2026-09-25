package week2.first_bad_version;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        boolean isBadVersion = false;
        for (int i = n; i >= 1; i --) {
            if (isBadVersion) {
                return i;
            }
        }
        return n; //just added so it doesn't question me on the
                  // not properly implemented boolean
    }
}

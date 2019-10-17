public class CustomerModel {
    public int mCustomerID;
    public String mName, mAddress;
    public double mPhone;

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(mCustomerID).append(",");
        sb.append("\"").append(mName).append("\"").append(",");
        sb.append(mAddress).append(",");
        sb.append(mPhone).append(")");
        return sb.toString();
    }
}

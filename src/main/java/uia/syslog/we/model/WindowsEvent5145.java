package uia.syslog.we.model;

public class WindowsEvent5145 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String objectType;

    private String sourceAddress;

    private int sourcePort;

    private String shareName;

    private String sharePath;

    private String relativeTargetName;

    private String accessMask;

    private String accesses;

    private String accessCheckResults;

    public WindowsEvent5145() {
        super("Security-Auditing", "5145");
    }

    public String getSecurityId() {
        return this.securityId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountDomain() {
        return this.accountDomain;
    }

    public String getLogonId() {
        return this.logonId;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    public int getSourcePort() {
        return this.sourcePort;
    }

    public String getShareName() {
        return this.shareName;
    }

    public String getSharePath() {
        return this.sharePath;
    }

    public String getRelativeTargetName() {
        return this.relativeTargetName;
    }

    public String getAccessMask() {
        return this.accessMask;
    }

    public String getAccesses() {
        return this.accesses;
    }

    public String getAccessCheckResults() {
        return this.accessCheckResults;
    }

}

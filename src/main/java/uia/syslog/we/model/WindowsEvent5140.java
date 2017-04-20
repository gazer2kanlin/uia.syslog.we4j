package uia.syslog.we.model;

public class WindowsEvent5140 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String objectType;

    private String sourceAddress;

    private int sourcePort;

    private String shareName;

    private String sharePath;

    private String accessMask;

    private String accesses;

    public WindowsEvent5140() {
        super("Security-Auditing", "5140");
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

    public String getAccessMask() {
        return this.accessMask;
    }

    public String getAccesses() {
        return this.accesses;
    }

}

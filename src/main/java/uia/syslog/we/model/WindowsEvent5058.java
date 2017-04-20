package uia.syslog.we.model;

public class WindowsEvent5058 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String providerName;

    private String algorithmName;

    private String keyName;

    private String keyType;

    private String filePath;

    private String operation;

    private String returnCode;

    public WindowsEvent5058() {
        super("Security-Auditing", "5058");
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

    public String getProviderName() {
        return this.providerName;
    }

    public String getAlgorithmName() {
        return this.algorithmName;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public String getKeyType() {
        return this.keyType;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

}

package uia.syslog.we.model;

/**
 * A trusted logon process has been registered with the Local Security Authority.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4740 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String lockSecurityId;

    private String lockAccountName;

    private String callerComputerName;

    public WindowsEvent4740() {
        super("Security-Auditing", "4740");
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

    public String getLockSecurityId() {
        return this.lockSecurityId;
    }

    public String getLockAccountName() {
        return this.lockAccountName;
    }

    public String getCallerComputerName() {
        return this.callerComputerName;
    }

}

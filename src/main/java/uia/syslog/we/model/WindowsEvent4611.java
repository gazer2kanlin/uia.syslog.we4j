package uia.syslog.we.model;

/**
 * A trusted logon process has been registered with the Local Security Authority.
 *
 * @author Kyle K. Lin
 *
 */
public class WindowsEvent4611 extends WindowsEvent {

    private String securityId;

    private String accountName;

    private String accountDomain;

    private String logonId;

    private String logonProcessName;

    public WindowsEvent4611() {
        super("Security-Auditing", "4611");
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

    public String getLogonProcessName() {
        return this.logonProcessName;
    }

}

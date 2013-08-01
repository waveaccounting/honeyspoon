package honeyspoon.driver;

import org.apache.hive.jdbc.HiveConnection;

import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Pattern;

public class HSDriver implements Driver {
    static {
        try {
            java.sql.DriverManager.registerDriver(new HSDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Is this driver JDBC compliant?
     */
    private static final boolean JDBC_COMPLIANT = false;

    /**
     * The required prefix for the connection URL.
     */
    private static final String URL_PREFIX = "jdbc:hive2://";

    /**
     * If host is provided, without a port.
     */
    private static final String DEFAULT_PORT = "10000";

    /**
     * Property key for the database name.
     */
    private static final String DBNAME_PROPERTY_KEY = "DBNAME";

    /**
     * Property key for the Hive Server2 host.
     */
    private static final String HOST_PROPERTY_KEY = "HOST";

    /**
     * Property key for the Hive Server2 port.
     */
    private static final String PORT_PROPERTY_KEY = "PORT";


    public HSDriver() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkWrite("foobar");
        }
    }

    public boolean acceptsURL(String url) throws SQLException {
        return Pattern.matches(URL_PREFIX + ".*", url);
    }

    public java.sql.Connection connect(String url, Properties info) throws SQLException {
        return new HSConnection(new HiveConnection(url, info));
    }

    public int getMajorVersion() {
        return 0;
    }

    public int getMinorVersion() {
        return 1;
    }

    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        if (info == null) {
            info = new Properties();
        }

        if ((url != null) && url.startsWith(URL_PREFIX)) {
            info = parseURL(url, info);
        }

        DriverPropertyInfo hostProp = new DriverPropertyInfo(HOST_PROPERTY_KEY,
                info.getProperty(HOST_PROPERTY_KEY, ""));
        hostProp.required = false;
        hostProp.description = "Hostname of Hive Server2";

        DriverPropertyInfo portProp = new DriverPropertyInfo(PORT_PROPERTY_KEY,
                info.getProperty(PORT_PROPERTY_KEY, ""));
        portProp.required = false;
        portProp.description = "Port number of Hive Server2";

        DriverPropertyInfo dbProp = new DriverPropertyInfo(DBNAME_PROPERTY_KEY,
                info.getProperty(DBNAME_PROPERTY_KEY, "default"));
        dbProp.required = false;
        dbProp.description = "Database name";

        DriverPropertyInfo[] dpi = new DriverPropertyInfo[3];

        dpi[0] = hostProp;
        dpi[1] = portProp;
        dpi[2] = dbProp;

        return dpi;
    }

    public boolean jdbcCompliant() {
        return JDBC_COMPLIANT;
    }

    private Properties parseURL(String url, Properties defaults) throws SQLException {
        Properties urlProps = (defaults != null) ? new Properties(defaults)
                : new Properties();

        if (url == null || !url.startsWith(URL_PREFIX)) {
            throw new SQLException("Invalid connection url: " + url);
        }

        if (url.length() <= URL_PREFIX.length()) {
            return urlProps;
        }

        // [hostname]:[port]/[db_name]
        String connectionInfo = url.substring(URL_PREFIX.length());

        // [hostname]:[port] [db_name]
        String[] hostPortAndDatabase = connectionInfo.split("/", 2);

        // [hostname]:[port]
        if (hostPortAndDatabase[0].length() > 0) {
            String[] hostAndPort = hostPortAndDatabase[0].split(":", 2);
            urlProps.put(HOST_PROPERTY_KEY, hostAndPort[0]);
            if (hostAndPort.length > 1) {
                urlProps.put(PORT_PROPERTY_KEY, hostAndPort[1]);
            } else {
                urlProps.put(PORT_PROPERTY_KEY, DEFAULT_PORT);
            }
        }

        // [db_name]
        if (hostPortAndDatabase.length > 1) {
            urlProps.put(DBNAME_PROPERTY_KEY, hostPortAndDatabase[1]);
        }

        return urlProps;
    }
}

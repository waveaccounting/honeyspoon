package honeyspoon;

import com.cloudera.sqoop.SqoopOptions;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.sqoop.manager.ConnManager;
import org.apache.sqoop.manager.DefaultManagerFactory;
import org.apache.sqoop.metastore.JobData;

public class HSManagerFactory extends DefaultManagerFactory {
    public static final Log LOG = LogFactory.getLog(
            HSManagerFactory.class.getName());

    public ConnManager accept(JobData data) {
        SqoopOptions options = data.getSqoopOptions();
        String connectStr = options.getConnectString();
        if (connectStr.startsWith("jdbc:hive2:")) {
            return new HSManager(options);
        } else {
            return null;
        }
    }
}

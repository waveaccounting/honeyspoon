Honeyspoon
----------

Honeyspoon is a Sqoop connector that allows using Hive as a data *source*,
not just as a destination point.

With Honeyspoon it is possible to transfer data between Hive clusters like this:

    $ sqoop import --connect jdbc:hive2://hive-host:10000 \
                   --query "select name, weight from cats where can_haz_cheezburger > 3" \
                   --hive-table really_fat_cats \
                   --hive-import \
                   --hive-overwrite \
                   --split-by weight

To enable Honeyspoon, put `honeyspoon.jar` into the Sqoop lib directory (usually `/usr/lib/sqoop/lib`),
then add `HSManagerFactory` to the list of connection factories in the Sqoop config
file (`/etc/sqoop/conf/sqoop-site.xml`):

    <property>
      <name>sqoop.connection.factories</name>
      <value>honeyspoon.HSManagerFactory,com.cloudera.sqoop.manager.DefaultManagerFactory</value>
      <description>A comma-delimited list of ManagerFactory implementations
        which are consulted, in order, to instantiate ConnManager instances
        used to drive connections to databases.
      </description>
    </property>

That should be enough to get it working.

Please note that although it works for us, this is a work-in-progress, alpha-quality piece of software
and there is no documentation. If you discover a bug or have a feature request, please open an issue.


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

## Installation and usage

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

Building from source:

    ant -f honeyspoon.xml

## Warning!

Please note that although it works for us, this is a work-in-progress, alpha-quality piece of software
and there is no documentation. If you discover a bug or have a feature request, please open an issue.


## License and Copyright

Copyright 2013 Wave Inc., http://waveapps.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

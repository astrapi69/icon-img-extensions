## Change log
----------------------

Version 2-SNAPSHOT
-------------

ADDED:

- new factory methods in ImageIconFactory class with new argument of description
- extracted sections from build.gradle to its own gradle files for clearness

CHANGED:

- update of jdk version 11
- update gradle to new version 7.5.1
- update of dependency lombok to new version 1.18.24
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new version 6.5.1
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new version 6.11.0
- update of gradle plugin dependency org.ajoberstar.grgit:grgit-gradle to new version 5.0.0
- update of dependency jobj-core to new version 7
- update of test dependency file-worker to new version 11.3
- update of test dependency junit-jupiter-api and junit-jupiter-engine to new version 5.9.1

Version 1.2
-------------

ADDED:

- new JButtonInfo class created for build JButton objects from the given fields
- new workflow for 'Java CI with Gradle' with codecov-action
- new gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle in version 6.2.2
- new gradle plugin dependency org.ajoberstar.grgit:grgit-gradle in version 4.1.1

CHANGED:

- update gradle to new version 7.4
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new version 0.42.0
- update of dependency jobj-core to new version 5.3
- update of test dependency file-worker to new version 8.2
- update of test dependency junit-jupiter-api and junit-jupiter-engine to new version 5.8.2

Version 1.1
-------------

CHANGED:

- change of type from int to float from svg conversion method for fixing type errors

Version 1
-------------

ADDED:

- new CHANGELOG.md file created
- all related classes moved from swing-components to this repository

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into changelogs

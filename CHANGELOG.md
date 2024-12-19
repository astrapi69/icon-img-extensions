## Change log
----------------------

Version 4.1
-------------

## [Unreleased]

### Added
- **ImageIconPreloader**: New utility class for preloading and caching tray icons.
- **Gradle modularization**: Introduced `apply-gradle-files.gradle` and `gradle-files.list` to streamline configuration management.
- **Parameterized tests**: Implemented CSV-based parameterized tests for `ImageIconPreloader`.
- **New Gradle plugins**: Integrated `jacoco` for code coverage and updated plugin versions.

### Changed
- **Gradle version**: Upgraded Gradle wrapper to version `8.12-rc-2`.
- **Java compatibility**: Updated source compatibility from Java 17 to Java 21.
- **Dependency management**: Consolidated dependencies into bundles for improved clarity.
- **Repositories script**: Enhanced with detailed comments and dynamic property handling for URLs.
- **Licensing script**: Refactored for improved readability using `setHeader` and `setIgnoreFailures`.

### Removed
- **Unused annotations**: Removed `@AllArgsConstructor` and `@EqualsAndHashCode` from `RgbIntegerModel` and `RgbFloatModel`.

### Fixed
- **Spotless configuration**: Enhanced formatting tasks to include unused import removal.

### Miscellaneous
- Added IntelliJ run configurations for `spotlessApply` and `tagRelease`.

Version 4
-------------

ADDED:

- new generic model class GenericRgbModel with a generic type that extends Number
- new model class RgbFloatModel for the representation of the RGB with float numbers
- new test dependency silly-collection in major version 27.1
- new libs.versions.toml file for new automatic catalog versions update

CHANGED:

- rename of RgbModel to RgbIntegerModel
- update gradle to new version 8.8
- update of dependency lombok to new version 1.18.32
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new version 7.0.0.BETA1
- update of test dependency junit-jupiter-api to new version 5.11.0-M2
- update of test dependency junit-platform-launcher to new version 1.11.0-M2

Version 3.3
-------------

ADDED:

- new extension class for the class Color
- new model class HsbModel for the representation of the HSB
- new model class RgbModel for the representation of the RGB

CHANGED:

- update gradle to new version 8.6
- update of dependency lombok to new version 1.18.30
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new version 8.6
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new version 0.51.0
- update of gradle plugin dependency org.ajoberstar.grgit:grgit-gradle to new version 5.2.2
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new version 6.25.0
- update of dependency jobj-core to new version 8.2
- update of test dependency junit-jupiter-api to new version 5.10.2
- replaced of test dependency junit-jupiter-engine with new test dependency junit-platform-launcher to new version 1.10.2

Version 3.2
-------------

ADDED:

- exports to the class file module-info.java for the corresponding package that have to be exported

CHANGED:

- update gradle to new version 8.3

Version 3.1
-------------

ADDED:

- new class file module-info.java that modularize this library

CHANGED:

- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new version 8.3
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new version 0.48.0
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new version 6.21.0
- removed all dependencies from 'org.apache.xmlgraphics:batik-*' because of not providing modularization
- removed dependency from 'org.imgscalr:imgscalr-lib' because of not providing modularization
- moved class SvgImageTranscoder to legacy library swing-components
- removed all resize-related methods from class ImageExtensions to new class ResizeImageExtensions in legacy library swing-components
- removed all batik-related methods from class ImageIconFactory to new class BatikImageIconFactory in legacy library swing-components

Version 3
-------------

ADDED:

- new factory method in class ImageIconFactory that creates a BufferedImage object with custom width, height and a textual description for the image
- new factory methods for create BufferedImage in class ImageExtensions
- new package-info classes for javadoc

CHANGED:

- update of jdk version 17
- update gradle to new version 8.3-rc-4
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new version 8.2.2
- update of test dependency 'com.github.meanbeanlib:meanbean' to new version 3.0.0-M9
- code coverage increased
- moved class IconDimensions to package 'io.github.astrapi69.icon.model'

Version 2.2
-------------

ADDED:

- new extension method in class ImageExtensions for convert an Image object to an Icon object
- new extension method in class ImageExtensions that converts an Image object to a BufferedImage object
- new extension method IconExtensions for store a given Icon object to a given file object
- new extension method IconExtensions that converts an Icon object to a BufferedImage object

CHANGED:

- update of test dependency junit-jupiter-api and junit-jupiter-engine to new version 5.10.0

Version 2.1
-------------

ADDED:

- new extension class IconExtensions for provide extension methods for Icon objects
- new extension method in class IconExtensions for convert an Icon object to an Image object

CHANGED:

- update gradle to new version 8.3-rc-1
- update of dependency lombok to new version 1.18.28
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new version 8.1.0
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new version 0.47.0
- update of gradle plugin dependency org.ajoberstar.grgit:grgit-gradle to new version 5.2.0
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new version 6.20.0
- update of dependency jobj-core to new version 7.1
- update of dependencies batik-* to new version 1.16
- update of test dependency file-worker to new version 11.6
- update of test dependency junit-jupiter-api and junit-jupiter-engine to new version 5.10.0-RC2

Version 2
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

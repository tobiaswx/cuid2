# ❗Important 17/02/2023
For various personal and work-related reasons, I have not been able to maintain this project (and others that are currently set to "private") for almost a year. Now I have time again! Soon I will update this project and fix the build pipeline. Regular updates of the dependencies and kotlin version are planned for the future. More information will follow soon.

# Kotlin Cuid2 MultiPlatform Library

<!-- TOC -->
* [Kotlin Cuid2 MultiPlatform Library](#kotlin-cuid2-multiplatform-library)
  * [Platform Support](#platform-support)
  * [Usage](#usage)
  * [License](#license)
<!-- TOC -->

## Platform Support

| Platform   | Supported | Underlying Library                                                      |
|------------|:---------:|-------------------------------------------------------------------------|
| JVM        |     ✅     | [paralleldrive / cuid2](https://github.com/paralleldrive/cuid2)         |
| JS, NodeJS |     ✅     | [thibaultmeyer / cuid-java](https://github.com/thibaultmeyer/cuid-java) |
| Native     |     ❌     |                                                                         |

## Usage

**Include dependency in pom.xml**

```xml
<dependency>
  <groupId>com.sakoss.library</groupId>
  <artifactId>cuid2</artifactId>
  <!-- always check for latests version -->
  <version>2.0.0-RC1</version>
</dependency>
```

**Use in code**

```kotlin
fun main() {
  // Generates a cuid with the default length (24 characters) 
  generateCUID()
  // Generates a cuid with customized length **
  generateCUID(length = 10)
}
```
_** Attention: on the JVM the length must be in the range of 1 to 50_

## License
This project is released under terms of the [GNU Lesser General Public License v2.1](https://github.com/Sakoss-Developers/cuid/blob/main/LICENSE).

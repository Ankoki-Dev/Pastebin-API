# Pastebin-API
An attempt at an updated Pastebin-API because all the ones for java that I found were abandoned/archived/all of the above.

Refer to the examples folder for examples of how to read, create, and get pastebins.

## Using this repo.
To import this repository into your project using maven, utilize jitpack!  
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>


<dependency>
    <groupId>com.github.Ankoki-Dev</groupId>
    <artifactId>Pastebin-API</artifactId>
    <version>RELEASE-VERSION</version>
    <scope>compile</scope> <!-- i use maven-shade-plugin to shade this into my jar -->
</dependency>
```
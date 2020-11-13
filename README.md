# Homework 2

## Виконала
Дулгер Лія

## IMPORTANT
IntelliJ Idea 2020.2.2(Community Edition), на якому виконувалась
робота, не розпізнає наступний плагін, тому в файлі pom.xml
його закоментовано.
````
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-pmd-plugin</artifactId>
                <version>3.5</version>
                <configuration>
                    <linkXref>true</linkXref>
                    <sourceEncoding>UTF8</sourceEncoding>
                    <minimumTokens>30</minimumTokens>
                    <targetJdk>1.7</targetJdk>
                </configuration>
                <executions>
                    <execution>
                        <phase>verify</phase>
                        <goals>
                            <goal>pmd</goal>
                            <goal>cpd</goal>
                        </goals>

                    </execution>
                </executions>
            </plugin>
````
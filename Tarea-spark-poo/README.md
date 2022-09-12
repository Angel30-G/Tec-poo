   Para solucionar el error de compilación, se agregó la siguiente dependencia
   
   <dependency>   
        <groupId>org.slf4j</groupId>   
        <artifactId>slf4j-jdk14</artifactId>   
        <version>1.7.30</version>     
    </dependency>
    
  Además de la dependencia, se agregó el siguiente plugin:
  
  <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>1.2.1</version>
        <executions>
            <execution>
                <goals>
                    <goal>java</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <mainClass>tec.poo.spark.App</mainClass>
        </configuration>
    </plugin>
        <plugin>
    
De esta forma al utilizar mvn compile, no sucede ningun error

    

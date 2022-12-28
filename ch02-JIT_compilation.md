# JVM

Main.java -> javac -> Main.class -> { JVM <-> JIT }

```mermaid
flowchart LR
  Main.java -- javac --> m["Main.class"] -- JIT --> JVM
```

`java -XX:+PrintCompilation com.vpp.ch02.Main 10000`

ms since jvm has started | order of the code block compiled | Flag | Compilation Level | Method | X
--- | --- | --- | --- | --- | ---
45  |  28 |    n  | 0 |  jdk.internal.misc.Unsafe::compareAndSetLong (native) |
46  |  25 |  !    | 3 |  java.util.concurrent.ConcurrentHashMap::putVal (432 bytes) |
116 | 69  |%      | 4 |  com.vpp.ch02.PrimeNumbers::isPrime @ 2 (35 bytes) |
120 | 70  |       | 4 |  com.vpp.ch02.PrimeNumbers::isPrime (35 bytes) | level 4 but not in code cache


#### Flag

* __n__: natively compiled
* __!__: exception handling
* __s__: synchronized method
* __%__: code have been natively compiled and is now running is a special part of memory called the _code cache_, 
meaning also the code is running in most optimal way possible 

#### Compilation Level
* `0` : no compilation, the code just interpreted
* `1` to `4` : progressively deeper level of compilation
  *  `1` to `4` : C1
  *  `4` : C2

#### JIT Compilers
* __C1__: 1 to 3
* __C2__: 4

> If the code is called enough times C2 might enter the stage, and also putting it in code cache, 
but if that code is not doing anything complex jit might consider not to optimise it. 


#### Code cache

Code cache has a limited size, and for new ones to appear, old ones needs to be removed.

VM warning: CodeCache is full. Compiler has been disabled. -> no new optimized code added in the code cache, old ones still used

this can be changed with:

* _InitialCodeCacheSize_ - initial size
* _ReservedCodeCacheSize_ - max code cache size
* _CodeCacheExpansionSize_ - how much extra space should be added whenever code cache needs to grow

### Monitor code cache usage

jconsole

but jconsole will need new code to run inside the process and PrintCompilation will show new methods executed ???

### [Java/c](https://docs.oracle.com/en/java/javase/11/tools/javac.html)

`C:\>javac -classpath \examples;\lib\Banners.jar \examples\greetings\Hi.java`

`javac .\java\com\vpp\ch02\*.java -d ..\..\target\classes -s ..\..\target\generated-sources`

`java -XX:+PrintCompilation com.vpp.ch02.Main 10000`

`java -XX:+UnlockDiagnosticVMOptions -XX:+LogCompilation com.vpp.ch02.Main 10000`

`java -XX:+PrintCodeCache com.vpp.ch02.Main 10000`

`java -XX:+PrintCodeCache -XX:ReservedCodeCacheSize=28m com.vpp.ch02.Main 10000`

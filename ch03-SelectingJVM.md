# Selecting the JVM 32/64

## JVM versions
32 bit | 64 bit
---    | ---
Might be faster if heap < 3GB (each pointer will be smaller - 32bit) | Might be faster for heavy usage of long /doubles
Max heap size = 4GB  |  Necessary of heap > 4GB 
Only C1 available (client compiler) | both C1 and C2 (server compiler)
native compiling adds some overhead, so some applications might not needed | you can specifcy wich compiler to use: `-client`

> client: short lived (highly unlikely the code will run enough time for C2 to kick in)

> server: long lived
 

`java -XX:+PrintCompilation com.vpp.ch02.Main 20000`

`java -client com.vpp.ch02.Main 20000`
 * notice not much difference, this is rigged, based on the above the higher the number with C2 will obtain better results[^1] 


### JVM Compiler flags:

* `-client` : selects client compiler
* `-server` : selects 32bit server compiler
* `-d64` : selects 64bit server compiler

> on 64bit OS `-server` and `-d64` are equivalent, waste of flags[^1]

* `-XX:-TieredCompilation` : run in interpreted mode only


### Native compiling tunning:

Some factors affects JIT compilation:

* How many threads are available (C1/C2 are running in a separate threads) - `CICompilerCount`
* What many times a method needs to be run befoare jit decides for native compiling - `CompileThreshold`

Print all default flags and their values:

`java -XX:+PrintFlagsFinal`

`java -XX:+PrintFlagsFinal | findstr "CICompiler"`

```
intx CICompilerCount                          = 4 -> 4 thraeds available for native compiling
```

or

`jps`

`jinfo -flag CICompilerCount 1184`

`java -XX:CICompilerCount=6 -XX:+PrintCompilation com.vpp.ch02.Main 5000`

`java -XX:+PrintFlagsFinal | findstr "CompileThreshold"`

[^1]: Just my unprofessional comments, don't mind them.

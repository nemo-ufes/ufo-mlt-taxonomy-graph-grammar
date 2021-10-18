#!/bin/sh

JAVA=java
VM_OPTIONS="-Xms4000M -Xmx4000M -XX:SoftRefLRUPolicyMSPerMB=10"

GROOVE=./groove-dev/
LIB_JAR_NAMES=`sed -ne 's%.*<classpathentry kind="lib" path="lib/\([^"]*\).*%\1%p' $GROOVE/.classpath 2> /dev/null`

CLASSPATH=$GROOVE/bin
for LIB in $LIB_JAR_NAMES; do
    CLASSPATH=$CLASSPATH:$GROOVE/lib/$LIB
done

$JAVA $VM_OPTIONS -classpath $CLASSPATH groove.GroovyChecker $*

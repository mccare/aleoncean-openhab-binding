aleoncean-openhab-binding
=========================

This projected started as a openHAB 1 binding.

The upstream development of openHAB 1 is not completely stopped, but the main focus is moved to the openHAB 2 project now.

We are using this binding with the openHAB 2 compatibility layer for openHAB 1 bindings (compat1x), only.

The binding code uses OSGi service component annotations.
The annotations are part of the OSGi™ Service Platform Compendium Specification Release 4 Version 4.3 and above.

openHAB 1 is currently using the version 4.2

So this binding will not work out of the box using the openHAB 1 runtime anymore.


Compiling for Openhab2
======================
 * clone repository
 * change to the required branch
 * run <pre>mvn clean package</pre>
 * copy the <pre>target/org.openhab.binding.aleoncean-VERSION-SNAPSHOT.jar</pre> into the addons directory of openHAB2
 * Also compile the library https://github.com/aleon-GmbH/aleoncean and copy it to the addons directory of openHAB2
 * see the [Configuration] (doc/) for examples how to use the binding

 

Debugging
=========

See if the bundle loaded in openHAB2:
```
osgi> bundles aleoncean
org.openhab.binding.aleoncean_1.7.4.SNAPSHOT [169]
  Id=169, Status=INSTALLED   Data Root=/Users/cvdl/Desktop/openhab/runtime/server/configuration/org.eclipse.osgi/169/data  "No registered services."
  No services in use.
osgi> start 169
```

if a configured item is using this services the output will be like:
```
osgi> bundles aleoncean
eu.aleon.aleoncean_1.9.0.SNAPSHOT [170]
  Id=164, Status=ACTIVE    ....
....
org.openhab.binding.aleoncean_1.7.4.SNAPSHOT [163]
  Id=163, Status=ACTIVE      Data Root=/Users/cvdl/WorkArea/openhab/openhab2/runtime/server/configuration/org.eclipse.osgi/163/data  "Registered Services"

```
  

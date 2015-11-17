The global configuration is placed in the openhab.cfg file.

For Openhab2 the configuration is residing in <pre>conf/services/aleoncean.cfg</pre> 

# serial port

You have to configure the serial port that should be used to communicate with the hardware.
<pre>aleoncean:port=/dev/ttyUSB0</pre>

For Openhab2 use the following instead: 
<pre>port=/dev/ttyUSB0</pre>

# base id

If you do not know, what base id is used for, please read [What is difference between Base ID and Chip ID?](http://www.enocean.com/en/knowledge-base-doku/enoceansystemspecification:issue:what_is_a_base_id/?purge=1) or do not use it.

Additional you COULD configure the base ID that should be set.

**USE THIS WITH CAUTION**

The base ID could be changed 10 times, then NO further changes could be done. See ESP3, that states this.
<pre>aleoncean:baseid=FF:80:20:00</pre>

For Openhab2 use 
<pre>baseid=FF:80:20:00</pre>
